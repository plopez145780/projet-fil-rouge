
# MPV 1

Date de début : 2026/07/17
Livraison estimé pour : 2026/07/18

## Périmètre

Au terme de ce MVP, l'application web permettant aux collaborateurs de soumettre, suivre et traiter des demandes internes de support ou d'évolution.
Il couvre le cycle de vie essentiel d'une demande : création, liste, changement de statut (NOUVELLE → EN_COURS → RESOLUE → FERMEE) et assignation à un membre de l'équipe.

Ce MVP comprends 4 grandes fonctionnalités.

### Personas et rôles

| Persona          | Rôle       | Description                          |
| ---------------- | ---------- | ------------------------------------ |
| Adrien Vossough  | Demandeur  | Soumet et suit ses demandes          |
| Guive Voss       | Assigné    | Traite et fait avancer les demandes  |
| Luigi M.         | Assigné    | Répartit la charge de travail        |
| Romain V.        | Assignable | Membre de l'équipe qui reçoit des demandes |

### US-01 — Créer une demande

> En tant que **demandeur (Adrien Vossough)**, je veux **créer une demande** (titre, description, demandeur) afin de **soumettre un besoin de support ou d'évolution et le tracer officiellement**.

### US-02 — Lister les demandes

> En tant que **demandeur (Adrien Vossough)**, je veux **lister les demandes** afin de **consulter l'état de mes demandes et celles de l'équipe en un coup d'œil**.

### US-03 — Changer de statut

> En tant qu'**assigné (Guive Voss)**, je veux **changer le statut d'une demande** (NOUVELLE → EN_COURS → RESOLUE → FERMEE) afin de **faire avancer le suivi et informer le demandeur de la progression**.

### US-04 — Assigner une demande

> En tant qu'**assigné (Luigi M.)**, je veux **assigner une demande à un membre de l'équipe** (ex. Romain V.) afin de **répartir la charge de travail et responsabiliser un intervenant**.

### Modèle de donnée — Demande

- `id`            (identifiant)
- `titre`         (court)
- `description`   (texte)
- `statut`        (NOUVELLE | EN_COURS | RESOLUE | FERMEE)
- `demandeur`     (ex. adrien.vossough)
- `assignee`      (ex. guive.voss)
- `date_creation`

## HORS périmètre

Features ambitieuses non intégrées au MVP :

**F1 — Tableau de bord analytique & SLA**
> En tant que **responsable d'équipe (Luigi M.)**, je veux **un dashboard avec indicateurs (délai moyen de résolution, taux de demandes en retard, charge par assigné) et alertes SLA** afin de **piloter la performance du support et anticiper les dépassements**.

**F2 — Flux d'approbation multi-étapes & notifications**
> En tant que **demandeur (Adrien Vossough)**, je veux **un workflow d'approbation configurable (validation hiérarchique, commentaires, notifications email/in-app) sur les demandes d'évolution** afin de **garantir la conformité et tenir les parties prenantes informées sans suivi manuel**.
