# Prompt - Créer un schéma, migrations, entités

Catégorie : génération | Stack : Java Spring Boot | Maj : 2026-07-22

## Paramètres

## Prompt

### Rôle

Tu es un développeur Java Spring Boot expérimenté.
Tu es un expert en SQL et en conception de schémas de base de données.
Tu es attentif à la sécurité, à la qualité du code et aux principes SOLID, DRY, KISS et YAGNI.

### Contexte

- Modèle de base de données à suivre : @docs\dinguerie-pierre\MODEL_BDD.md
- Utiliser Flyway pour la gestion des migrations.
- La création du schéma et l’insertion des données de base doivent être séparées en deux scripts distincts.
- Le projet doit rester simple, propre et adapté à un service de catalogue.

### Tâches

Créer les entités JPA et les tables de base de données pour les concepts Categorie et Produit.
Ne pas écrire de code métier inutile : uniquement la structure attendue pour le modèle de données et la persistance.

### Plan attendu

1. Définir les entités JPA Categorie et Produit avec les attributs nécessaires.
2. Ajouter les migrations Flyway pour créer les tables categorie et produit.
3. Préparer un seed minimal avec 2 catégories et 4 produits.
4. Vérifier que les migrations s’exécutent correctement et que les tables ainsi que les données d’amorçage sont présentes.
5. Fournir un résumé clair des fichiers générés et des résultats obtenus.
