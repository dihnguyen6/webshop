package com.mrKhoai.webshop.controller.role;

import com.mrKhoai.webshop.controller.ObjectService;
import com.mrKhoai.webshop.objects.Role;
import com.mrKhoai.webshop.repositories.RoleRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public JSONArray getAll() throws JSONException {
        return null;
    }
}
