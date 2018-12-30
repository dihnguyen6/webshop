package com.mrKhoai.webshop.objects;

import java.io.Serializable;

public interface Identifiable<T extends Serializable> {
    T getId();
}
