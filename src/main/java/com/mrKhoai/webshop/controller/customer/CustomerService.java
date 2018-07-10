package com.mrKhoai.webshop.controller.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrKhoai.webshop.controller.ObjectService;
import com.mrKhoai.webshop.objects.Customer;
import com.mrKhoai.webshop.repositories.CustomerRepository;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class CustomerService implements ObjectService<Customer> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void save(Customer customer){
        customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer){
        customerRepository.delete(customer);
    }

    @Override
    public Customer findById(String id){
        return null;
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public boolean contains(String id) {
        return false;
    }

    @Override
    public boolean contains(int id) {
        return false;
    }

    public Customer findByName(String username) {
        Iterator<Customer> userList = customerRepository.findAll().iterator();
        while (userList.hasNext()) {
            Customer customer = userList.next();
            if (customer.getCustomerName().equals(username)) {
                return customer;
            }
        }
        return null;
    }

    public boolean containsName(String username){
        Iterator<Customer> userList = customerRepository.findAll().iterator();
        while (userList.hasNext()) {
            Customer customer = userList.next();
            if (customer.getCustomerName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public JSONArray getAll() throws JsonProcessingException {
        JSONArray jsonArray = new JSONArray();
        Iterator<Customer> userList = customerRepository.findAll().iterator();
        while (userList.hasNext()) {
            Customer customer = userList.next();
            ObjectMapper mapper = new ObjectMapper();
            jsonArray.put(mapper.writeValueAsString(customer));
        }
        return jsonArray;
    }

    public Customer getCurrentUser()
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
