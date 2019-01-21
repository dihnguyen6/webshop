package com.mrKhoai.webshop.controller.staff;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrKhoai.webshop.controller.ObjectService;
import com.mrKhoai.webshop.objects.Staff;
import com.mrKhoai.webshop.repositories.StaffRepository;
import org.json.JSONArray;
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
    public String getAll() throws JsonProcessingException {
        JSONArray jsonArray = new JSONArray();
        Iterator<Staff> staffList = staffRepository.findAll().iterator();
        while (staffList.hasNext()) {
            Staff staff = staffList.next();
            ObjectMapper mapper = new ObjectMapper();
            jsonArray.put(mapper.writeValueAsString(staff));
        }
        return jsonArray.toString();
    }
}
