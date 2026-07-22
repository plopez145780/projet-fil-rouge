# Prompt - Generer un endpoint REST (liste filtrable)

Categorie : generation  |  Stack : Java SpringBoot  |  Maj : 2026-07-20

## Parametres

- {{ENTITE}} : entite exposee (ex. Demande)
- {{CHAMP_FILTRE}} : champ de filtre optionnel
- {{CHAMP_CATEGORIE}} : champ de filtre de categorie optionnel

## Prompt

Role : Tu es un développeur de java spring boot, attentif aux conventions REST, a la sécurité, tu respect les principe SOLID, DRY, KISS, YAGNI.

Context :

- Java 25
- Spring Boot 4.1.0
- Agular 22

Taches :

- Exposer un endpoint qui list les {{ENTITE}}, avec un systeme de recherche, de filtrage et la reponse est paginé.

Plan attendu:

1. Créer le controlleur avec la signature du endpoint paginé
2. Parametre de filtre de recherche sur le {{CHAMP_FILTRE}} optionnel
3. Parametre de filtre  de categorie sur le {{CHAMP_CATEGORIE}} optionnel
4. Créer le service correspondant (pas de logique métier dans le controlleur)
5. Créer le repository.

Format de sortie : le code du controller uniquement + une phrase par choix non evident.
