package com.example.demo2.repository;


import com.example.demo2.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface produitRepository extends JpaRepository<Produit, Long> {
  List<Produit> findByIdc_Id(long id);
  List<Produit> findByName(String id);
//date
}
