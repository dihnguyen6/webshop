package com.mrKhoai.webshop.controller.role;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrKhoai.webshop.controller.ObjectService;
import com.mrKhoai.webshop.objects.Role;
import com.mrKhoai.webshop.repositories.RoleRepository;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class RoleService implements ObjectService<Role> {

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }

    @Override
    public Role findById(String id) {
        return null;
    }

    @Override
    public Role findById(int id) {
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
    public JSONArray getAll() throws JsonProcessingException {
        JSONArray jsonArray = new JSONArray();
        Iterator<Role> roleList = roleRepository.findAll().iterator();
        while (roleList.hasNext()) {
            Role role = roleList.next();
            ObjectMapper mapper = new ObjectMapper();
            jsonArray.put(mapper.writeValueAsString(role));
        }
        return jsonArray;
    }

    public Role findByName(String roleName) {
        Iterator<Role> userList = roleRepository.findAll().iterator();
        while (userList.hasNext()) {
            Role role = userList.next();
            if (role.getRoleName().equals(roleName)) {
                return role;
            }
        }
        return null;
    }
}
