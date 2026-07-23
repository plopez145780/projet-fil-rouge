# Page front - CatalogPage

## Role

Tu es un developpeur angular expérimenté.

### Contexte

- Angular 22
- Reste simple pour l'interface

## Contrainte

- Utilisation de Traefik
- Traefik : le front appelle /api/produits
- pas de client HTTP ni de librairie UI pour ce périmètre
- Route de la page "/catalogue"

## Taches

Créer une page CatalogPage, qui liste les produits via Traefik, puis valider dans le navigateur.

## Plan

- Crée un grille des produits : libellé, grade, prix, stock
- Crée un message d'erreur si l'API est injoignable
- Crée un message « aucun produit » si la liste est vide
- A la fin : valide dans le navigateur
