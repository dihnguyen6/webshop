package com.mrKhoai.webshop.repositories;

import com.mrKhoai.webshop.objects.Carousel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarouselRepository extends CrudRepository<Carousel, Integer> {
    @Query(
            value = "SELECT * FROM carousel",
            nativeQuery = true
    )
    List<Carousel> getAll();
}
