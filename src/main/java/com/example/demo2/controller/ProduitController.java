package com.example.demo2.controller;


import com.example.demo2.dto.ProduitDto;
import com.example.demo2.model.Categories;
import com.example.demo2.model.Produit;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/produit")
public class ProduitController {
  @Autowired
  private ModelMapper mapper ;
@Autowired
  private com.example.demo2.repository.produitRepository pp;
  @Autowired
  private com.example.demo2.repository.categoriesRepository cc;
  @GetMapping("/ll/editp/")
  public List<Produit> getAllproduitall() {

    return  pp.findAll();
  }
  @GetMapping("/ll/editp/{id}")
  public List<Produit> getAllproduitt(@PathVariable("id") Long id) {

    return  pp.findByIdc_Id(id);
  }

  @GetMapping("/ll/{idc}/editp/{id}")
  public ResponseEntity<Produit> getproduitById(@PathVariable(value = "id") Long  produitId)
    throws ResourceNotFoundException {
    var  produit =  pp.findById( produitId)
      .orElseThrow(() -> new ResourceNotFoundException("produit not found for this id : " +  produitId));
    return ResponseEntity.ok().body( produit);
  }

  @PostMapping("/ll/editp/{id}")
  public Produit createproduit(@Valid @RequestBody ProduitDto p, @PathVariable("id") Long id) {
    var prod=mapper.map(p, Produit.class);
    prod.setDatec(new Timestamp(System.currentTimeMillis()));
    prod.setDatem(null);
    Categories m=cc.findById(id).orElseThrow(() -> new NoSuchElementException());
    prod.setIdc(m);
    return  pp.save(prod);
  }

  @PutMapping("/ll/editp/{id}")
  public ResponseEntity<Produit> updateproduit(@PathVariable(value = "id") Long  id, @Valid @RequestBody  ProduitDto  p) throws ResourceNotFoundException {
    var  produit=  pp.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("produit not found for this id :: " +  id));
    produit.setName( p.getName());
    produit.setQuatite(p.getQuatite());

    produit.setDatem(new Timestamp(System.currentTimeMillis()));
    final var updatedproduit = pp.save(produit);
    return ResponseEntity.ok(updatedproduit);
  }

  @DeleteMapping("/ll/editp/{id}")
  public Map<String, Boolean> deleteproduit(@PathVariable(value = "id") Long produitId)
    throws ResourceNotFoundException {
    var produit = pp.findById(produitId)
      .orElseThrow(() -> new ResourceNotFoundException("produit not found for this id :: " + produitId));
    pp.delete(produit);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }

}
