package com.semishop.repository;

import org.springframework.data.jpa.domain.Specification;

import com.semishop.domain.Produit;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;

public final class ProduitSpecification {

    private ProduitSpecification() {}

    public static Specification<Produit> hasCategorieSlug(String slug) {
        return (root, query, cb) -> {
            if (slug == null || slug.isBlank()) return null;
            Join<Object, Object> cat = root.join("categorie", JoinType.LEFT);
            return cb.equal(cat.get("slug"), slug);
        };
    }

    public static Specification<Produit> hasGrade(String grade) {
        return (root, query, cb) -> {
            if (grade == null || grade.isBlank()) return null;
            return cb.equal(root.get("grade"), grade);
        };
    }

    public static Specification<Produit> textSearch(String q) {
        return (root, query, cb) -> {
            if (q == null || q.isBlank()) return null;
            String like = "%" + q.toLowerCase() + "%";
            return cb.or(
                    cb.like(cb.lower(root.get("libelle")), like),
                    cb.like(cb.lower(root.get("description")), like)
            );
        };
    }
}
