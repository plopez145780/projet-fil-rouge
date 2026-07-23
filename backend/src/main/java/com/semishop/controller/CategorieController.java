package com.semishop.controller;

import com.semishop.domain.Categorie;
import com.semishop.dto.CategorieResponse;
import com.semishop.service.CategorieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategorieController {

    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping
    public List<CategorieResponse> list() {
        return categorieService.listAll();
    }
}
