package com.example.demo2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "categories")
public class Categories {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;
  @Column(name = "quatite")
  private int quatite;

  @OneToMany(mappedBy="idc")
  @JsonIgnore
  private List<Produit> produitc = new ArrayList<>();
  @CreationTimestamp
  @Column(name = "datec", nullable = false)
  private Timestamp datec;


  private Timestamp datem;
  public Categories() {
super();
  }

  public Categories(String name, int quatite, Timestamp datec, Timestamp datem ) {
    this.name = name;
    this.quatite = quatite;
    this.datec = datec;
    this.datem=datem;

  }


}
