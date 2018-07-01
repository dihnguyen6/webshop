package com.mrKhoai.webshop.controller.user;

import com.mrKhoai.webshop.controller.WebshopConst;
import com.mrKhoai.webshop.objects.Staff;
import com.mrKhoai.webshop.repositories.StaffRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public void addCustomer(Staff staff){
        staffRepository.save(staff);
    }

    public void deleteCustomer(Staff staff){
        staffRepository.delete(staff);
    }

    public Staff findCustomerById(String id){
        return staffRepository.findById(id).get();
    }

    public Staff findCustomerByName(String username) {
        Iterator<Staff> userList = staffRepository.findAll().iterator();
        while (userList.hasNext()) {
            Staff tempStaff = userList.next();
            if (tempStaff.getStaffName().equals(username)) {
                return tempStaff;
            }
        }
        return null;
    }

    public boolean containsCustomer(String username){
        Iterator<Staff> userList = staffRepository.findAll().iterator();
        while (userList.hasNext()) {
            Staff tempStaff = userList.next();
            if (tempStaff.getStaffName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsMail(String email){
        Iterator<Staff> userList = staffRepository.findAll().iterator();
        while (userList.hasNext()) {
            Staff tempStaff = userList.next();
            if (tempStaff.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public JSONObject checkCustomer(Staff staff) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        boolean status = true;
        if (containsCustomer(staff.getStaffName())) {
            status = false;
            jsonObject.put(WebshopConst.USER_NAME, WebshopConst.USER_NAME + WebshopConst.REGITERED);
        }
        if (staff.getEmail().matches(WebshopConst.MAIL_REGEX)) {
            status = false;
            jsonObject.put(WebshopConst.USER_MAIL, WebshopConst.USER_MAIL + WebshopConst.INVALID);
        }
        if (containsMail(staff.getEmail())) {
            status = false;
            jsonObject.put(WebshopConst.USER_MAIL, WebshopConst.USER_MAIL + WebshopConst.REGITERED);
        }
        jsonObject.put(WebshopConst.STATUS, status);
        return jsonObject;
    }

    public Staff getCurrentUser()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //Check if it isn't an authenticated user
        if (authentication instanceof AnonymousAuthenticationToken) {
            return null;
        }
        String currentUserName = authentication.getName();
        return findCustomerByName(currentUserName);
    }
}
