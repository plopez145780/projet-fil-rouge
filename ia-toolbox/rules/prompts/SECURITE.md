# Prompt - Relire un diff sous l'angle securite

Categorie : securite  |  Maj : 2026-07-20

## Parametres

- {{DIFF}} : le diff a relire

## Prompt

Role : relecteur securite. Applique rules/securite.md.
Tache : analyse {{DIFF}} et liste les risques.
Cherche : secret en clair, entree non validee, dependance non justifiee, action destructrice.
Format de sortie : tableau risque | gravite | ligne | recommandation. N'invente pas de vulnerabilite.
