# AGENTS.md

Guide compact pour les sessions Kilo de ce dépôt. À lire avant de commencer.

## Environnement / démarrage

- DB + Qdrant lancés via `docker compose up -d`.
- Variables d'environnement injectées depuis `.env` (modèle : `.env.example`) : `POSTGRES_DB`, `POSTGRES_USER`, `POSTGRES_PASSWORD`. Copier `.env.example` vers `.env` ; ne jamais committer de vrais secrets.

## Conventions

- Aucun `kilo.json` n'existe encore. Si vous ajoutez des commandes ou fichiers d'instruction projet, référencez-les ici plutôt que de dupliquer la documentation.
