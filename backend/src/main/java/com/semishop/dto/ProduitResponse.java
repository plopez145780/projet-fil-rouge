package com.semishop.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProduitResponse {
    private Long id;
    private String sku;
    private String libelle;
    private String description;
    private CategorieResponse categorie;
    private String grade;
    private BigDecimal prixHt;
    private BigDecimal tauxTva;
    private Integer stock;
    private Boolean actif;
    private Integer garantieMois;
    private LocalDateTime dateAjout;

    public ProduitResponse() {
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategorieResponse getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieResponse categorie) {
        this.categorie = categorie;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public BigDecimal getPrixHt() {
        return prixHt;
    }

    public void setPrixHt(BigDecimal prixHt) {
        this.prixHt = prixHt;
    }

    public BigDecimal getTauxTva() {
        return tauxTva;
    }

    public void setTauxTva(BigDecimal tauxTva) {
        this.tauxTva = tauxTva;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public Integer getGarantieMois() {
        return garantieMois;
    }

    public void setGarantieMois(Integer garantieMois) {
        this.garantieMois = garantieMois;
    }

    public LocalDateTime getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(LocalDateTime dateAjout) {
        this.dateAjout = dateAjout;
    }
}
