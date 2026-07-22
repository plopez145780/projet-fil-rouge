package com.semishop.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.semishop.service.CategorieService;
import com.semishop.service.ProduitService;

@ExtendWith(MockitoExtension.class)
class ProduitControllerTest {

    @Mock
    ProduitService produitService;

    @Mock
    CategorieService categorieService;

    @InjectMocks
    ProduitController produitController;

    @Test
    void listProduits_empty_ok() {
        when(produitService.listProduits(org.mockito.ArgumentMatchers.any(), org.mockito.ArgumentMatchers.any(), org.mockito.ArgumentMatchers.any(), org.mockito.ArgumentMatchers.any()))
            .thenReturn(new PageImpl<>(Collections.emptyList(), PageRequest.of(0,20), 0));

        var page = produitController.listProduits(null, null, null, PageRequest.of(0,20));
        assertThat(page).isNotNull();
        assertThat(page.getTotalElements()).isZero();
    }
}
