package com.example.demo2.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "produit")
public class Produit {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "name", nullable = false)
  private String name;
  @ManyToOne
  private Categories idc;
  @Column(name = "quatite")
  private int quatite;
  @Column(name = "disponible")
 private  boolean disponible;
  @CreationTimestamp
  @Column(name = "datec", nullable = false)
  private Timestamp datec;

  @Column(name = "datem")
  private Timestamp datem;
  public Produit() {
  }

  public Produit(long id, String name, int quatite, boolean disponible, Timestamp datec, Timestamp datem, Categories idc) {
    this.id = id;
    this.name = name;
    this.quatite = quatite;
    this.disponible = disponible;
    this.datec = datec;
    this.datem = datem;
    this.idc = idc;

  }

  public Categories getIdc() {
    return idc;
  }

  public void setIdc(Categories idc) {
    this.idc = idc;
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

  public boolean isDisponible() {
    return disponible;
  }

  public void setDisponible(boolean disponible) {
    this.disponible = disponible;
  }

  public Timestamp getDatec() {
    return datec;
  }

  public void setDatec(Timestamp datec) {
    this.datec = datec;
  }

  public Timestamp getDatem() {
    return datem;
  }

  public void setDatem(Timestamp datem) {
    this.datem = datem;
  }
}
