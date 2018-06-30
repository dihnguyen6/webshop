package com.mrKhoai.webshop.objects.user;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {
    private enum Role {
        ADMINISTRATOR, SALE_ASSISTANT, PRODUCT_MANAGER, WEB_DEV
    }

}
