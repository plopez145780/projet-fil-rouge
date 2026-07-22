
# Context - decision

Contexte : depot semishop, compose v0 demarre (Traefik :80, PostgreSQL 16 avec la base
referentiel_db, user semishop).

Stack : Java 25 / Spring Boot 3.4.1 / Maven

Objectif : service catalogue dans services/catalogue/ — referentiel produits
reconditionnes. Tables categorie et produit (grade A/B/C, prix_ht, stock, sku unique).
API REST sur :8081 : GET /produits pagine et filtre (categorie, q, grade, page, taille),
GET /produits/{id}, POST, PUT, DELETE, GET /categories.

Contraintes : migrations Flyway (pas de ddl-auto create), seed minimal (2 categories,
4 produits), taille de page bornee cote serveur, identifiants de base lus depuis
l'environnement, respecter ia-toolbox/rules/, aucune dependance non justifiee.

Ne code rien encore : propose d'abord un PLAN en 4 increments verifiables
(1 schema+entites, 2 API CRUD, 3 conteneur+Traefik, 4 front), un commit par increment.
