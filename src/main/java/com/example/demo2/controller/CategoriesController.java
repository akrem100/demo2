package com.example.demo2.controller;
import com.example.demo2.conf.Config;

import com.example.demo2.dto.CategoriesDto;
import com.example.demo2.model.Categories;
import com.example.demo2.model.Produit;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;


@EnableJpaRepositories("com.example.demo.repository.categoriesRepository")
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/categories")
public class CategoriesController {
@Autowired
  private  ModelMapper mapper ;
@Autowired
private com.example.demo2.repository.categoriesRepository categoriesRepository;
  @Autowired
  private com.example.demo2.repository.produitRepository pp;

  @GetMapping("/ll")
  public List<Categories> getAllcategories() {
    return  categoriesRepository.findAll();
  }

  @GetMapping("/ll/{id}")
  public ResponseEntity<Categories> getcategoriesById(@PathVariable(value = "id") Long  categoriesId)
    throws ResourceNotFoundException {
    var  categories =  categoriesRepository.findById(categoriesId)
      .orElseThrow(() -> new ResourceNotFoundException("categories not found for this id :: " +  categoriesId));
    return ResponseEntity.ok().body(categories);
  }

  @PostMapping("/add")
  public Categories createcategoriese(@Valid @RequestBody CategoriesDto c ) {
   var cat=mapper.map(c, Categories.class);
    cat.setDatec(new Timestamp(System.currentTimeMillis()));


    return  categoriesRepository.save(cat);
  }

  @PutMapping("/edit/{id}")
  public ResponseEntity<Categories> updatecategories(@PathVariable(value = "id") Long  categoriesId,
                                                     @Valid @RequestBody  CategoriesDto  categoriesDetails) throws ResourceNotFoundException {

    var  categories=  categoriesRepository.findById(categoriesId)
      .orElseThrow(() -> new ResourceNotFoundException("categories not found for this id :: " +  categoriesId));

    categories.setName( categoriesDetails.getName());
    categories.setQuatite(categoriesDetails.getQuatite());
    categories.setDatem(new Timestamp(System.currentTimeMillis()));
    final var updatedcategories = categoriesRepository.save(categories);
    return ResponseEntity.ok(updatedcategories);
  }

  @DeleteMapping("/ll/{id}")
  public String deletecategories(@PathVariable(value = "id") Long categoriesId)
    throws ResourceNotFoundException {
   /*** categories categories = categoriesRepository.findById(categoriesId)
      .orElseThrow(() -> new ResourceNotFoundException("categories not found for this id :: " + categoriesId));

    categoriesRepository.delete(categories);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE); return response;***/
    List<Produit> produitsList = pp.findAll();
    for(Produit p : produitsList)
      pp.deleteById(p.getId());
    categoriesRepository.deleteById(categoriesId);
    return "Categorie deleted";

  }
}

