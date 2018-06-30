package com.mrKhoai.webshop.controller.user;

import com.mrKhoai.webshop.objects.Staff;
import com.mrKhoai.webshop.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void addCustomer(Staff staff){
        customerRepository.save(staff);
    }

    public void deleteCustomer(Staff staff){
        customerRepository.delete(staff);
    }

    public Staff findCustomerById(String id){
        return customerRepository.findById(id).get();
    }

    public Staff findCustomerByName(String username) {
        Iterator<Staff> userList = customerRepository.findAll().iterator();
        while (userList.hasNext()) {
            Staff tempStaff = userList.next();
            if (tempStaff.getStaffName().equals(username)) {
                return tempStaff;
            }
        }
        return null;
    }

    public boolean containsCustomer(String username){
        Iterator<Staff> userList = customerRepository.findAll().iterator();
        while (userList.hasNext()) {
            Staff tempStaff = userList.next();
            if (tempStaff.getStaffName().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
