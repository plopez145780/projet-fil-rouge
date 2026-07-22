package com.semishop.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProduitRequest {

    @NotBlank
    private String sku;
    @NotBlank
    private String libelle;
    private String description;
    @NotNull
    private Long categorieId;
    @NotBlank
    private String grade;
    @NotNull
    private BigDecimal prixHt;
    @NotNull
    private BigDecimal tauxTva;
    @NotNull
    private Integer stock;
    @NotNull
    private Boolean actif;
    @NotNull
    private Integer garantieMois;

    public ProduitRequest() {}

    // getters and setters
    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }
    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Long getCategorieId() { return categorieId; }
    public void setCategorieId(Long categorieId) { this.categorieId = categorieId; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
    public BigDecimal getPrixHt() { return prixHt; }
    public void setPrixHt(BigDecimal prixHt) { this.prixHt = prixHt; }
    public BigDecimal getTauxTva() { return tauxTva; }
    public void setTauxTva(BigDecimal tauxTva) { this.tauxTva = tauxTva; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
    public Boolean getActif() { return actif; }
    public void setActif(Boolean actif) { this.actif = actif; }
    public Integer getGarantieMois() { return garantieMois; }
    public void setGarantieMois(Integer garantieMois) { this.garantieMois = garantieMois; }
}
