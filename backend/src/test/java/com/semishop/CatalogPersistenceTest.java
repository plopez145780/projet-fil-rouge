package com.semishop;

import com.semishop.domain.Categorie;
import com.semishop.domain.Produit;
import com.semishop.repository.CategorieRepository;
import com.semishop.repository.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class CatalogPersistenceTest {

    @Test
    void shouldReturnSeedDataFromRepositoryMocks() {
        CategorieRepository categorieRepository = Mockito.mock(CategorieRepository.class);
        ProduitRepository produitRepository = Mockito.mock(ProduitRepository.class);

        Categorie c1 = new Categorie();
        c1.setLibelle("Électronique");
        c1.setSlug("electronique");

        Categorie c2 = new Categorie();
        c2.setLibelle("Maison");
        c2.setSlug("maison");

        Produit p1 = new Produit();
        p1.setSku("ELECTRO-001"); p1.setLibelle("Smartphone"); p1.setCategorie(c1);
        p1.setGrade("A"); p1.setPrixHt(new BigDecimal("699.99")); p1.setTauxTva(new BigDecimal("0.200")); p1.setStock(15);
        p1.setActif(true); p1.setGarantieMois(24); p1.setDateAjout(LocalDateTime.now());

        Produit p2 = new Produit();
        p2.setSku("ELECTRO-002"); p2.setLibelle("Casque audio"); p2.setCategorie(c1);
        p2.setGrade("B"); p2.setPrixHt(new BigDecimal("129.50")); p2.setTauxTva(new BigDecimal("0.200")); p2.setStock(8);
        p2.setActif(true); p2.setGarantieMois(12); p2.setDateAjout(LocalDateTime.now());

        Produit p3 = new Produit();
        p3.setSku("MAISON-001"); p3.setLibelle("Lampe LED"); p3.setCategorie(c2);
        p3.setGrade("A"); p3.setPrixHt(new BigDecimal("39.90")); p3.setTauxTva(new BigDecimal("0.200")); p3.setStock(20);
        p3.setActif(true); p3.setGarantieMois(12); p3.setDateAjout(LocalDateTime.now());

        Produit p4 = new Produit();
        p4.setSku("MAISON-002"); p4.setLibelle("Tasse en céramique"); p4.setCategorie(c2);
        p4.setGrade("C"); p4.setPrixHt(new BigDecimal("12.00")); p4.setTauxTva(new BigDecimal("0.200")); p4.setStock(50);
        p4.setActif(true); p4.setGarantieMois(6); p4.setDateAjout(LocalDateTime.now());

        when(categorieRepository.findAll()).thenReturn(Arrays.asList(c1, c2));
        when(produitRepository.findAll()).thenReturn(Arrays.asList(p1, p2, p3, p4));

        List<Categorie> categories = categorieRepository.findAll();
        List<Produit> products = produitRepository.findAll();

        assertThat(categories).hasSize(2);
        assertThat(products).hasSize(4);
        assertThat(categories).extracting(Categorie::getSlug).containsExactlyInAnyOrder("electronique", "maison");
        assertThat(products).extracting(Produit::getSku).containsExactlyInAnyOrder(
                "ELECTRO-001",
                "ELECTRO-002",
                "MAISON-001",
                "MAISON-002"
        );
    }
}
