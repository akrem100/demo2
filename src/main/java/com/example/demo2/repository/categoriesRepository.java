package com.example.demo2.repository;


import com.example.demo2.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoriesRepository extends JpaRepository<Categories, Long> {

}
