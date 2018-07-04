package com.mrKhoai.webshop.controller.user;

import com.mrKhoai.webshop.controller.ObjectService;
import com.mrKhoai.webshop.controller.WebshopConst;
import com.mrKhoai.webshop.objects.Staff;
import com.mrKhoai.webshop.repositories.StaffRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class StaffService implements ObjectService<Staff> {

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public void save(Staff staff){
        staffRepository.save(staff);
    }

    @Override
    public void delete(Staff staff){
        staffRepository.delete(staff);
    }

    @Override
    public Staff findById(String id){
        return staffRepository.findById(id).get();
    }

    @Override
    public Staff findById(int id) {
        return null;
    }

    @Override
    public boolean contains(String id) {
        return false;
    }

    @Override
    public boolean contains(int id) {
        return false;
    }

    public Staff findByName(String username) {
        Iterator<Staff> userList = staffRepository.findAll().iterator();
        while (userList.hasNext()) {
            Staff tempStaff = userList.next();
            if (tempStaff.getStaffName().equals(username)) {
                return tempStaff;
            }
        }
        return null;
    }

    public boolean containsName(String username){
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
        if (containsName(staff.getStaffName())) {
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

    @Override
    public JSONArray getAll() throws JSONException {
        JSONArray jsonArray = new JSONArray();
        Iterator<Staff> userList = staffRepository.findAll().iterator();
        while (userList.hasNext()) {
            Staff tempStaff = userList.next();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(WebshopConst.USER_NAME, tempStaff.getStaffName());
            jsonObject.put(WebshopConst.USER_PASSWORD, tempStaff.getPassword());
            jsonObject.put(WebshopConst.USER_MAIL, tempStaff.getEmail());
            jsonObject.put(WebshopConst.USER_COMPANY, tempStaff.getCompanyName());
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }

    public Staff getCurrentUser()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //Check if it isn't an authenticated user
        if (authentication instanceof AnonymousAuthenticationToken) {
            return null;
        }
        String currentUserName = authentication.getName();
        return findByName(currentUserName);
    }
}
