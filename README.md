# Projet Fil Rouge

SemiShop est une boutique en ligne de matériel informatique reconditionné : ordinateurs portables, smartphones, écrans et périphériques. Chaque produit est proposé avec un grade de reconditionnement (A « comme neuf », B « bon état », C « état correct »), une garantie et un prix inférieur au neuf. La proposition de valeur tient en une phrase : offrir du matériel reconditionné fiable, tracé et garanti, moins cher et plus durable.

# Enjeux

Le marché du reconditionné informatique est porté par deux dynamiques convergentes : la pression sur le pouvoir d'achat, qui rend le neuf moins accessible, et la montée des attentes environnementales, qui valorise l'allongement de la durée de vie des équipements. La confiance reste le principal frein à l'achat : l'acheteur veut savoir dans quel état réel se trouve le produit, quelle garantie il obtient et à qui il s'adresse en cas de problème. SemiShop répond précisément à ce frein par la traçabilité du grade, l'affichage systématique de la garantie et un tunnel d'achat lisible.

## Démarrage

L'environnement de base de données se lance via Docker Compose :

```bash
docker compose up -d
```

Variables d'environnement (`POSTGRES_DB`, `POSTGRES_USER`, `POSTGRES_PASSWORD`) injectées depuis un fichier `.env`.

## Documentation

- [docs/STACK.md](docs/STACK.md) — choix et rationale de la stack
- [docs/FEATURE.md](docs/FEATURE.md) — User Stories & modèle de données
- [docs/ARCHITECTURE.md](docs/ARCHITECTURE.md) — architecture microservices


Les rules : 