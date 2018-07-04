package com.mrKhoai.webshop.controller.staff;

import com.mrKhoai.webshop.controller.ObjectService;
import com.mrKhoai.webshop.objects.Staff;
import com.mrKhoai.webshop.repositories.StaffRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class StaffService implements ObjectService<Staff> {

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
        return null;
    }

    public Staff findByName(String username) {
        Iterator<Staff> userList = staffRepository.findAll().iterator();
        while (userList.hasNext()) {
            Staff staff = userList.next();
            if (staff.getStaffName().equals(username)) {
                return staff;
            }
        }
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
