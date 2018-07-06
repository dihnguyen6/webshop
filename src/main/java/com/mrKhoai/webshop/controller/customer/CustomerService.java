package com.mrKhoai.webshop.controller.customer;

import com.mrKhoai.webshop.controller.ObjectService;
import com.mrKhoai.webshop.controller.WebshopConst;
import com.mrKhoai.webshop.objects.Customer;
import com.mrKhoai.webshop.repositories.CustomerRepository;
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
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer findById(int id) {
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

    public boolean containsMail(String email){
        Iterator<Customer> userList = customerRepository.findAll().iterator();
        while (userList.hasNext()) {
            Customer customer = userList.next();
            if (customer.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public JSONObject checkCustomer(Customer customer) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        boolean status = true;
        if (containsName(customer.getCustomerName())) {
            status = false;
            jsonObject.put(WebshopConst.USER_NAME, WebshopConst.USER_NAME + WebshopConst.REGITERED);
        }
        if (customer.getEmail().matches(WebshopConst.MAIL_REGEX)) {
            status = false;
            jsonObject.put(WebshopConst.USER_MAIL, WebshopConst.USER_MAIL + WebshopConst.INVALID);
        }
        if (containsMail(customer.getEmail())) {
            status = false;
            jsonObject.put(WebshopConst.USER_MAIL, WebshopConst.USER_MAIL + WebshopConst.REGITERED);
        }
        jsonObject.put(WebshopConst.STATUS, status);
        return jsonObject;
    }

    @Override
    public JSONArray getAll() throws JSONException {
        JSONArray jsonArray = new JSONArray();
        Iterator<Customer> userList = customerRepository.findAll().iterator();
        while (userList.hasNext()) {
            Customer customer = userList.next();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(WebshopConst.USER_NAME, customer.getCustomerId());
            jsonObject.put(WebshopConst.USER_MAIL, customer.getEmail());
            jsonObject.put(WebshopConst.USER_FULLNAME, customer.getCustomerFullName());
            jsonArray.put(jsonObject);
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
