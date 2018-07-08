package com.mrKhoai.webshop.controller.staff;

import com.mrKhoai.webshop.controller.ObjectService;
import com.mrKhoai.webshop.controller.WebshopConst;
import com.mrKhoai.webshop.objects.Staff;
import com.mrKhoai.webshop.repositories.StaffRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class StaffService implements ObjectService<Staff> {

    private static final Logger LOGGER = LoggerFactory.getLogger(StaffService.class);

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public void save(Staff staff) {
        staffRepository.save(staff);
    }

    @Override
    public void delete(Staff staff) {
        staffRepository.delete(staff);
    }

    @Override
    public Staff findById(String id) {
        return null;
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

    @Override
    public JSONArray getAll() throws JSONException {
        JSONArray jsonArray = new JSONArray();
        Iterator<Staff> staffList = staffRepository.findAll().iterator();
        while (staffList.hasNext()) {
            Staff staff = staffList.next();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(WebshopConst.USER_NAME, staff.getStaffName());
            jsonObject.put(WebshopConst.USER_MAIL, staff.getEmail());
            jsonObject.put(WebshopConst.USER_FULLNAME, staff.getStaffFullName());
            jsonObject.put(WebshopConst.ROLE, staff.getRole().getRoleName());
            jsonObject.put("id", staff.getStaffId());
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }

    public Staff findByName(String username) {
        username = username.toLowerCase();
        Iterator<Staff> staffList = staffRepository.findAll().iterator();
        while (staffList.hasNext()) {
            Staff staff = staffList.next();
            LOGGER.info("{} compare with {}", staff.getStaffName(), username);
            if (staff.getStaffName().equals(username)) {
                return staff;
            }
        }
        LOGGER.info("Cant find Staff " + username);
        return null;
    }

    public boolean containsName(String username){
        Iterator<Staff> userList = staffRepository.findAll().iterator();
        while (userList.hasNext()) {
            Staff staff = userList.next();
            if (staff.getStaffName().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
