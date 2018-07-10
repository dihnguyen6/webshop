package com.mrKhoai.webshop.repositories;

import com.mrKhoai.webshop.objects.Coupon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends CrudRepository<Coupon, Integer> {

}
