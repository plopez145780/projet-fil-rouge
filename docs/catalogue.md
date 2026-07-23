# Service Catalogue

## Modele de donnees

### Table `categorie`

| Champ          | Type           | Contrainte                            |
|----------------|----------------|---------------------------------------|
| id             | bigint         | PK, auto-incremente                   |
| libelle        | varchar(100)   | NOT NULL                              |
| slug           | varchar(100)   | NOT NULL, UNIQUE                      |
| parent_id      | bigint         | FK -> categorie(id), NULLABLE         |



### Table `produit`

| Champ           | Type              | Contrainte                               |
|-----------------|-------------------|------------------------------------------|
| id              | bigint            | PK, auto-incremente                      |
| sku             | varchar(100)      | NOT NULL, UNIQUE                         |
| libelle         | varchar(150)      | NOT NULL                                 |
| description     | varchar(500)      | NULLABLE                                 |
| categorie_id    | bigint            | NOT NULL, FK -> categorie(id)            |
| grade           | char(1)           | NOT NULL                                 |
| prix_ht         | numeric(10,2)     | NOT NULL                                 |
| taux_tva        | numeric(4,3)      | NOT NULL                                 |
| stock           | integer           | NOT NULL                                 |
| actif           | boolean           | NOT NULL                                 |
| garantie_mois   | integer           | NOT NULL                                 |
| date_ajout      | timestamp         | NOT NULL, auto-validee a la creation     |

### Relations

- `categorie` -> `produit` : OneToMany (1..n)
- `categorie` -> `categorie` : Self-referencing ManyToOne (parent)

## Contrat d'API

Base : `http://localhost:8081` (derriere Traefik : `http://localhost/api`)

| Methode | Path             | Query Params                  | Body | Reponse                            | Succes | Erreur  |
|---------|------------------|-------------------------------|------|-------------------------------------|--------|---------|
| GET     | /categories      | -                             | -    | List<CategorieResponse>             | 200    | -       |
| GET     | /produits        | categorie, q, grade, pageable | -    | Page<ProduitResponse>               | 200    | -       |
| GET     | /produits/{id}   | -                             | -    | ProduitResponse                     | 200    | 404     |
| POST    | /produits        | -                             | ProduitRequest | ProduitResponse               | 201    | 400     |
| PUT     | /produits/{id}   | -                             | ProduitRequest | ProduitResponse               | 200    | 404, 400|
| DELETE  | /produits/{id}   | -                             | -    | -                                   | 204    | 404     |

### DTOs

**CategorieResponse**
```json
{
  "id": 1,
  "libelle": "Electronique",
  "slug": "electronique"
}
```

**ProduitRequest**
```json
{
  "sku": "PROD-001",
  "libelle": "Laptop",
  "description": "15 pouces",
  "categorieId": 1,
  "grade": "A",
  "prixHt": 999.99,
  "tauxTva": 0.20,
  "stock": 50,
  "actif": true,
  "garantieMois": 24
}
```

**ProduitResponse**
```json
{
  "id": 1,
  "sku": "PROD-001",
  "libelle": "Laptop",
  "description": "15 pouces",
  "categorie": {
    "id": 1,
    "libelle": "Electronique",
    "slug": "electronique"
  },
  "grade": "A",
  "prixHt": 999.99,
  "tauxTva": 0.20,
  "stock": 50,
  "actif": true,
  "garantieMois": 24,
  "dateAjout": "2026-01-15T10:00:00"
}
```

## Procedure de lancement

### Pre-requis

- Docker et Docker Compose installes
- Java 21 et Maven (pour lancer le backend en dev)
- Node.js et Angular CLI (pour lancer le frontend)

### Base de donnees, Qdrant et Traefik

```bash
docker compose up -d
```

Services exposes :
- PostgreSQL : `localhost:5432`
- Qdrant : `localhost:6333` (REST) / `localhost:6334` (gRPC)
- Traefik : `localhost:80` (API), `localhost:8080` (dashboard)

### Backend (Java / Spring Boot)

```bash
cd backend
mvn spring-boot:run
```

Le backend demarre sur le port `8081`. Aucune configuration supplementaire n'est necessaire si `docker compose up -d` est lance (les variables DB sont injectees par Compose).

### Frontend (Angular)

```bash
cd frontend
npm install
ng serve
```

Le frontend demarre sur `http://localhost:4200`. Les appels API passent par Traefik via `/api/produits`.

### Verification

- Backend : `curl http://localhost:8081/categories`
- Via Traefik : `curl http://localhost/api/produits`
- Frontend : `http://localhost:4200/catalogue`
