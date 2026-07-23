package com.semishop.service;

import com.semishop.domain.Categorie;
import com.semishop.dto.CategorieResponse;
import com.semishop.repository.CategorieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CategorieService {

    private final CategorieRepository categorieRepository;

    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public List<CategorieResponse> listAll() {
        return categorieRepository.findAll().stream()
                .map(c -> {
                    CategorieResponse r = new CategorieResponse();
                    r.setId(c.getId());
                    r.setLibelle(c.getLibelle());
                    r.setSlug(c.getSlug());
                    return r;
                })
                .toList();
    }
}
