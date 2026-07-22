Contrat d'API (le service écoute sur le port 8081, sans préfixe /api — c'est Traefik qui le retire) :

- GET /produits Liste paginée (page, taille) et filtrée (categorie = slug, q = texte sur libellé/description, grade) 200 — { "content": [...], "page": 0, "taille": 20, "totalElements": 12 }
- GET /produits/{id} Détail d'un produit 200, 404 si inconnu
- POST /produits Crée un produit (refus si sku déjà pris) 201, 409 si conflit
- PUT /produits/{id} Met à jour 200, 404
- DELETE /produits/{id} Supprime 204, 404
- GET /categories Liste des catégories 200
