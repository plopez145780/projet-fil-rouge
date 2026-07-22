package com.semishop.service;

import com.semishop.domain.Categorie;
import com.semishop.domain.Produit;
import com.semishop.repository.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProduitServiceTest {

    @Mock
    ProduitRepository produitRepository;

    @InjectMocks
    ProduitService produitService;

    private Produit sampleProduit(Long id) {
        Produit p = new Produit();
        if (id != null) p.setSku("sku-" + id);
        p.setLibelle("Produit " + (id == null ? "X" : id));
        p.setDescription("desc");
        Categorie c = new Categorie();
        c.setId(11L);
        c.setSlug("cat-slug");
        p.setCategorie(c);
        p.setGrade("A");
        p.setPrixHt(new BigDecimal("10.00"));
        p.setTauxTva(new BigDecimal("0.200"));
        p.setStock(5);
        p.setActif(true);
        p.setGarantieMois(12);
        return p;
    }

    @Test
    void listProduits_returnsPage() {
        Page<Produit> page = new PageImpl<>(List.of(sampleProduit(1L)), PageRequest.of(0, 10), 1);
        when(produitRepository.findAll(ArgumentMatchers.<Specification<Produit>>any(), ArgumentMatchers.any(Pageable.class)))
                .thenReturn(page);

        Page<Produit> res = produitService.listProduits("cat-slug", "search", "A", PageRequest.of(0, 10));
        assertThat(res).isNotNull();
        assertThat(res.getTotalElements()).isEqualTo(1);
        verify(produitRepository, times(1)).findAll(ArgumentMatchers.<Specification<Produit>>any(), ArgumentMatchers.any(Pageable.class));
    }

    @Test
    void findById_found() {
        Produit p = sampleProduit(2L);
        when(produitRepository.findById(2L)).thenReturn(Optional.of(p));

        Optional<Produit> res = produitService.findById(2L);
        assertThat(res).isPresent();
        assertThat(res.get().getLibelle()).startsWith("Produit");
    }

    @Test
    void findById_notFound() {
        when(produitRepository.findById(99L)).thenReturn(Optional.empty());
        Optional<Produit> res = produitService.findById(99L);
        assertThat(res).isEmpty();
    }

    @Test
    void create_savesProduit() {
        Produit toSave = sampleProduit(null);
        Produit saved = sampleProduit(3L);
        when(produitRepository.save(toSave)).thenReturn(saved);

        Produit res = produitService.create(toSave);
        assertThat(res).isNotNull();
        assertThat(res.getLibelle()).isEqualTo(saved.getLibelle());
        verify(produitRepository).save(toSave);
    }

    @Test
    void update_existing_returnsUpdated() {
        Produit existing = sampleProduit(4L);
        // set an id via reflection-like approach: repository will return existing with id
        // but Produit has no setId, so we simulate via repository behaviour
        Produit updated = sampleProduit(null);
        updated.setLibelle("Updated libelle");

        when(produitRepository.findById(4L)).thenReturn(Optional.of(existing));
        when(produitRepository.save(any(Produit.class))).thenAnswer(inv -> inv.getArgument(0));

        Produit res = produitService.update(4L, updated);
        assertThat(res).isNotNull();
        assertThat(res.getLibelle()).isEqualTo("Updated libelle");
        verify(produitRepository).findById(4L);
        verify(produitRepository).save(any(Produit.class));
    }

    @Test
    void update_nonExisting_returnsNull() {
        when(produitRepository.findById(55L)).thenReturn(Optional.empty());
        Produit res = produitService.update(55L, sampleProduit(null));
        assertThat(res).isNull();
        verify(produitRepository).findById(55L);
        verify(produitRepository, never()).save(any());
    }

    @Test
    void delete_callsRepository() {
        doNothing().when(produitRepository).deleteById(7L);
        produitService.delete(7L);
        verify(produitRepository).deleteById(7L);
    }
}
