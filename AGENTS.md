# AGENTS.md

Guide compact pour les sessions Kilo de ce dépôt. À lire avant de commencer.

## Nature du dépôt

Projet de **gestion de demandes internes** (demandes de support ou d'évolution).

## Stack (versions épinglées — politique de sécurité impose les dernières versions)

- Back-End : **Java 26 / Spring Boot 4.1.0**
- Front-End : **Angular 22**
- Base de données : **PostgreSQL 18** (Docker)
- Base vectorielle : **Qdrant 1.18.2** (RAG, utilisé seulement à partir du M05 — pas dans le MVP)

## Architecture (non évidente d'après les noms de fichiers)

- Le front (Angular) parle UNIQUEMENT à un **MS d'exposition** (BFF/API Gateway). Jamais directement aux services métier.
- Services métier : **MS Demande** (métier) et **MS Référentiel** (users/statuts/référentiels). Chacun possède son propre schéma de base de données.
- Communications inter-services : REST/JSON synchrones. Pas de bus de messages dans le MVP.
- Qdrant présent dans docker-compose mais inutilisé jusqu'au M05 — ne pas le câbler dans le travail MVP.

## Périmètre MVP (ne pas dépasser sans demander)

Uniquement ces 4 fonctionnalités (US-01..04) : créer une demande, lister, changer de statut, assigner.
Énumération des statuts : `NOUVELLE | EN_COURS | RESOLUE | FERMEE`.
HORS PÉRIMÈTRE : tableaux de bord SLA, workflows d'approbation multi-étapes, notifications. Voir `docs/FEATURE.md`.

## Environnement / démarrage

- DB + Qdrant lancés via `docker compose up -d`.
- Variables d'environnement injectées depuis `.env` (modèle : `.env.example`) : `POSTGRES_DB`, `POSTGRES_USER`, `POSTGRES_PASSWORD`. Copier `.env.example` vers `.env` ; ne jamais committer de vrais secrets.

## Personas → rôles (pour le travail fonctionnel/test)

- Demandeur : Adrien Vossough
- Assigné : Guive Voss, Luigi M.
- Assignable : Romain V.

## Conventions

- Les termes métier en français sont intentionnels : `demande`, `demandeur`, `assignee`, `statut`. Conserver les noms de champs du modèle dans `docs/FEATURE.md`.
- Aucun `kilo.json` n'existe encore. Si vous ajoutez des commandes ou fichiers d'instruction projet, référencez-les ici plutôt que de dupliquer la documentation.
