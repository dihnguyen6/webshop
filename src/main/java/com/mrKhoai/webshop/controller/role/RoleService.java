package com.mrKhoai.webshop.controller.role;

import com.mrKhoai.webshop.controller.ObjectService;
import com.mrKhoai.webshop.controller.WebshopConst;
import com.mrKhoai.webshop.objects.Customer;
import com.mrKhoai.webshop.objects.Role;
import com.mrKhoai.webshop.objects.Staff;
import com.mrKhoai.webshop.repositories.RoleRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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
    public JSONArray getAll() throws JSONException {
        JSONArray jsonArray = new JSONArray();
        Iterator<Role> roleList = roleRepository.findAll().iterator();
        while (roleList.hasNext()) {
            Role role = roleList.next();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("roleId", role.getRoleId());
            jsonObject.put("roleName", role.getRoleName());
            jsonArray.put(jsonObject);
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
