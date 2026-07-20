# Architecture

- respecte des couches (contrôleur → service → repository) (MVC)
- pas de logique métier dans le contrôleur
- l'obligation d'un plan explicite avant toute modification multi-fichiers
- le refus de toute dépendance non justifiée (une dépendance ajoutée = une raison écrite)