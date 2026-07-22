package com.semishop.controller;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.semishop.domain.Categorie;
import com.semishop.domain.Produit;
import com.semishop.dto.CategorieResponse;
import com.semishop.dto.ProduitRequest;
import com.semishop.dto.ProduitResponse;
import com.semishop.service.CategorieService;
import com.semishop.service.ProduitService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    private final ProduitService produitService;
    private final CategorieService categorieService;

    public ProduitController(ProduitService produitService, CategorieService categorieService) {
        this.produitService = produitService;
        this.categorieService = categorieService;
    }

    @GetMapping
    public Page<ProduitResponse> listProduits(@RequestParam(required = false) String categorie,
            @RequestParam(required = false) String q, @RequestParam(required = false) String grade, Pageable pageable) {
        Page<Produit> page = produitService.listProduits(categorie, q, grade, pageable);
        return page.map(this::toResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProduitResponse> getProduit(@PathVariable Long id) {
        Optional<Produit> p = produitService.findById(id);
        return p.map(prod -> ResponseEntity.ok(toResponse(prod))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProduitResponse> create(@Valid @RequestBody ProduitRequest req) {
        Produit p = fromRequest(req);
        Produit saved = produitService.create(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProduitResponse> update(@PathVariable Long id, @Valid @RequestBody ProduitRequest req) {
        Produit updated = fromRequest(req);
        Produit saved = produitService.update(id, updated);
        if (saved == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(toResponse(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produitService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private ProduitResponse toResponse(Produit p) {
        ProduitResponse r = new ProduitResponse();
        r.setId(p.getId());
        r.setSku(p.getSku());
        r.setLibelle(p.getLibelle());
        r.setDescription(p.getDescription());
        Categorie c = p.getCategorie();
        if (c != null) {
            CategorieResponse categorieDto = new CategorieResponse();
            categorieDto.setId(c.getId());
            categorieDto.setLibelle(c.getLibelle());
            categorieDto.setSlug(c.getSlug());
            r.setCategorie(categorieDto);
        }
        r.setGrade(p.getGrade());
        r.setPrixHt(p.getPrixHt());
        r.setTauxTva(p.getTauxTva());
        r.setStock(p.getStock());
        r.setActif(p.getActif());
        r.setGarantieMois(p.getGarantieMois());
        r.setDateAjout(p.getDateAjout());
        return r;
    }

    private Produit fromRequest(ProduitRequest req) {
        Produit p = new Produit();
        p.setSku(req.getSku());
        p.setLibelle(req.getLibelle());
        p.setDescription(req.getDescription());
        if (req.getCategorieId() != null) {
            Categorie c = new Categorie();
            c.setId(req.getCategorieId());
            p.setCategorie(c);
        }
        p.setGrade(req.getGrade());
        p.setPrixHt(req.getPrixHt());
        p.setTauxTva(req.getTauxTva());
        p.setStock(req.getStock());
        p.setActif(req.getActif());
        p.setGarantieMois(req.getGarantieMois());
        return p;
    }
}
