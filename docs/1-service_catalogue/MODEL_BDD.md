# Modèle de données

base : referentiel_db

Table Colonnes Contraintes

Table : categorie
Colonne : id, libelle, slug, parent_id
Contraintes : slug unique ; parent_id référence categorie(id), nullabl

Table : produit
Coonnes : id, sku, libelle, description, categorie_id, grade, prix_ht, taux_tva, stock, actif, garantie_mois, date_ajout
Contraintes : sku unique ; grade dans (A,B,C) ; prix_ht >= 0 ; stock >= 0, défaut 0 ; taux_tva défaut 0.200 ; actif défaut vrai ; garantie_mois défaut 12
