package com.example.demo2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Categories {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
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

  @Column(name = "datem")
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

  public List<Produit> getProduitc() {
    return produitc;
  }

  public void setProduitc(List<Produit> produitc) {
    this.produitc = produitc;
  }


  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public int getQuatite() {
    return quatite;
  }

  public void setQuatite(int quatite) {
    this.quatite = quatite;
  }


  public Timestamp getDatec() {
    return datec;
  }
  public void setDatec(Timestamp datec) {
    this.datec = datec;
  }
  @Column(name = "datem", nullable = false)
  public Timestamp getDatem() {
    return datem;
  }

  public void setDatem(Timestamp datem) {
    this.datem = datem;
  }

  @Override
  public String toString() {
    return "categories[id=" + id + ", name=" + name + ", quatite=" + quatite + ", datec=" + datec+ ", datem=" + datem
      + "]";
  }
}
