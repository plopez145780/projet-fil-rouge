package com.semishop.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.semishop.domain.Produit;
import com.semishop.repository.ProduitRepository;
import com.semishop.repository.ProduitSpecification;

@Service
@Transactional
public class ProduitService {

    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public Page<Produit> listProduits(String categorieSlug, String q, String grade, Pageable pageable) {
        Specification<Produit> spec = Specification.where(ProduitSpecification.hasCategorieSlug(categorieSlug))
                .and(ProduitSpecification.textSearch(q))
                .and(ProduitSpecification.hasGrade(grade));
        return produitRepository.findAll(spec, pageable);
    }

    public Optional<Produit> findById(Long id) {
        return produitRepository.findById(id);
    }

    public Produit create(Produit p) {
        return produitRepository.save(p);
    }

    public Produit update(Long id, Produit updated) {
        Optional<Produit> existing = produitRepository.findById(id);
        if (existing.isEmpty()) return null;
        Produit p = existing.get();
        p.setSku(updated.getSku());
        p.setLibelle(updated.getLibelle());
        p.setDescription(updated.getDescription());
        p.setCategorie(updated.getCategorie());
        p.setGrade(updated.getGrade());
        p.setPrixHt(updated.getPrixHt());
        p.setTauxTva(updated.getTauxTva());
        p.setStock(updated.getStock());
        p.setActif(updated.getActif());
        p.setGarantieMois(updated.getGarantieMois());
        return produitRepository.save(p);
    }

    public void delete(Long id) {
        produitRepository.deleteById(id);
    }
}
