# Projet Fil Rouge

Petite application de **gestion de demandes internes** (support ou évolution).

Une _demande_ représente un besoin soumis par un collaborateur et traité par l'équipe.

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
