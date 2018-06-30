package com.mrKhoai.webshop.controller.user;

import com.mrKhoai.webshop.objects.Customer;
import com.mrKhoai.webshop.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void deleteCustomer(Customer customer){
        customerRepository.delete(customer);
    }

    public Customer findCustomerById(String id){
        return customerRepository.findById(id).get();
    }

    public Customer findCustomerByName(String username) {
        Iterator<Customer> userList = customerRepository.findAll().iterator();
        while (userList.hasNext()) {
            Customer tempCustomer = userList.next();
            if (tempCustomer.getCustomerName().equals(username)) {
                return tempCustomer;
            }
        }
        return null;
    }

    public boolean containsCustomer(String username){
        Iterator<Customer> userList = customerRepository.findAll().iterator();
        while (userList.hasNext()) {
            Customer tempCustomer = userList.next();
            if (tempCustomer.getCustomerName().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
