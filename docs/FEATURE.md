# MPV 1

Date de début : 2026/07/17
Livraison estimé pour : 2026/07/29

## Périmètre

Au terme de ce MVP, l'application web permet d'avoir un Catalogue, panier, commande, paiement simulé, back-office de gestion

Ce MVP comprends 5 grandes fonctionnalités.

- Consulter le catalogue (recherche, filtres, pagination)
- Ajouter/modifier des lignes au panier
- Valider une commande avec paiement simule (CB ou virement)
- Suivre le statut de sa commande (validee -> payee -> preparee -> expediee -> livree)
- Back-office : gerer les produits et faire evoluer le statut des commandes

## Hors perimetre MVP :

- Recommandations personnalisees et moteur de recherche avance
- Avis clients, wishlist, codes promo / remises automatiques
- Integration d'un vrai prestataire de paiement (PSP)
- Gestion transporteur reelle et tracking colis externe
- SSO externe, messagerie Kafka/RabbitMQ, event sourcing
