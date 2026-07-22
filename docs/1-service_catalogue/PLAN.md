Plan en 4 incréments
Schema et entités

Créer le module services/catalogue
Définir les entités JPA Categorie et Produit
Ajouter migrations Flyway pour créer les tables categorie et produit
Préparer un seed minimal avec 2 catégories et 4 produits
Vérification : les migrations s’exécutent et les tables existent avec les données d’amorçage
API CRUD catalogue

Exposer GET /produits avec pagination et filtres categorie, q, grade
Exposer GET /produits/{id}
Exposer POST /produits, PUT /produits/{id}, DELETE /produits/{id}
Exposer GET /categories
Vérification : tests d’intégration / manuels assurent le bon comportement des endpoints et limitations de page
Conteneurisation et Traefik

Ajouter Dockerfile pour le service catalogue
Mettre à jour docker-compose.yml avec le service catalogue, PostgreSQL et Traefik
Configurer Traefik pour router catalogue sur :8081
Vérifier : le service catalogue accessible via le réseau Docker et Traefik
Front

Créer une interface simple pour afficher la liste paginée de produits
Ajouter filtres categorie, q, grade
Ajouter navigation vers le détail produit et opérations CRUD basiques
Vérification : le front consomme l’API catalogue et permet l’usage des fonctionnalités
