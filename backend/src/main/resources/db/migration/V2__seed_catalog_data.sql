INSERT INTO categorie (libelle, slug) VALUES
    ('Électronique', 'electronique'),
    ('Maison', 'maison');

INSERT INTO produit (sku, libelle, description, categorie_id, grade, prix_ht, taux_tva, stock, actif, garantie_mois, date_ajout)
SELECT 'ELECTRO-001', 'Smartphone', 'Téléphone intelligent 128 Go', c.id, 'A', 699.99, 0.200, 15, TRUE, 24, CURRENT_TIMESTAMP
FROM categorie c WHERE c.slug = 'electronique';

INSERT INTO produit (sku, libelle, description, categorie_id, grade, prix_ht, taux_tva, stock, actif, garantie_mois, date_ajout)
SELECT 'ELECTRO-002', 'Casque audio', 'Casque sans fil', c.id, 'B', 129.50, 0.200, 8, TRUE, 12, CURRENT_TIMESTAMP
FROM categorie c WHERE c.slug = 'electronique';

INSERT INTO produit (sku, libelle, description, categorie_id, grade, prix_ht, taux_tva, stock, actif, garantie_mois, date_ajout)
SELECT 'MAISON-001', 'Lampe LED', 'Lampe d''éclairage', c.id, 'A', 39.90, 0.200, 20, TRUE, 12, CURRENT_TIMESTAMP
FROM categorie c WHERE c.slug = 'maison';

INSERT INTO produit (sku, libelle, description, categorie_id, grade, prix_ht, taux_tva, stock, actif, garantie_mois, date_ajout)
SELECT 'MAISON-002', 'Tasse en céramique', 'Tasse solide et élégante', c.id, 'C', 12.00, 0.200, 50, TRUE, 6, CURRENT_TIMESTAMP
FROM categorie c WHERE c.slug = 'maison';
