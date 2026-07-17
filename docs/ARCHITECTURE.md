# Architecture

Question ouverte : ce decoupage se justifie-t-il ?

## Vue d'ensemble

```text
┌──────────────┐
│  Angular 22  │  (Front-End)
│  (navigateur)│
└──────┬───────┘
       │  HTTPS / JSON (REST)
       ▼
┌──────────────────────────┐
│  API Gateway / MS        │  Couche d'exposition d'API
│  d'exposition            │  - routing, authn, CORS, validation
└──────┬───────────┬───────┘
       │           │
       ▼           ▼
┌────────────────┐  ┌────────────────────┐
│  MS Demande    │  │  MS Référentiel    │
│  (métier)      │  │  (users, statuts,  │
│  - CRUD demande│  │   références)      │
│  - statut      │  │                     │
│  - assignation │  │                     │
└──────┬─────────┘  └─────────┬──────────┘
       │                      │
       ▼                      ▼
┌──────────────────────────────────────┐
│              PostgreSQL 18           │
│  (schémas/schemas distincts ou BDD   │
│   séparées par service)              │
└──────────────────────────────────────┘
```

## Composants

| Composant              | Rôle                                                                 |
| ---------------------- | -------------------------------------------------------------------- |
| **Front-End (Angular)**| Interface utilisateur : création, liste, changement de statut, assignation |
| **MS d'exposition API**| Point d'entrée unique (BFF/API Gateway) : routage, sécurité, agrégation |
| **MS Demande**         | Service métier des demandes ; possède sa propre table `demande`        |
| **MS Référentiel**     | Données de référence : utilisateurs, statuts, énumérations, rôles      |
| **PostgreSQL**         | Persistance partagée (une base, schémas séparés par service)           |

## Flux typiques

1. **Créer une demande** : Angular → MS exposition → MS Demande → PostgreSQL
2. **Lister les demandes** : Angular → MS exposition → MS Demande (joint éventuellement MS Référentiel pour libellés utilisateur/statut)
3. **Changer de statut** : Angular → MS exposition → MS Demande
4. **Assigner** : Angular → MS exposition → MS Demande ; le MS Référentiel fournit la liste des assignables

## Conventions

- Le front ne parle qu'au **MS d'exposition** (jamais directement aux services métier).
- Chaque microservice possède sa propre couche de persistance (schéma dédié dans PostgreSQL).
- Communications inter-services en REST/JSON ; un registre de services (ex. Eureka) et une config centralisée (Spring Cloud Config) peuvent être ajoutés plus tard si besoin.

