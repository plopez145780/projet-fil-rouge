package com.semishop.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.semishop.domain.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>, JpaSpecificationExecutor<Produit> {

    @Query("SELECT DISTINCT p FROM Produit p LEFT JOIN FETCH p.categorie WHERE p.id IN (SELECT p2.id FROM Produit p2)")
    Page<Produit> findAllWithCategorie(Pageable pageable);

    @EntityGraph(attributePaths = "categorie")
    Page<Produit> findAll(Specification<Produit> spec, Pageable pageable);

    @EntityGraph(attributePaths = "categorie")
    Optional<Produit> findById(Long id);
}
