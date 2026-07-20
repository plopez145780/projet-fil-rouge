Role : Tu es un développeur de java spring boot, attentif aux conventions REST, a la sécurité, tu respect les principe SOLID, DRY, KISS, YAGNI.

Context : 

- Java 26
- Spring Boot 4.1.0
- Agular 22

Taches : 
- Exposer un endpoint qui list les produits (Catalogue), avec un systeme de recherche, de filtrage et la reponse est paginé.

Plan attendu:
1. Créer le controlleur avec la signature du endpoint paginé
2. Parametre de filtre de recherche sur le nom optionnel
3. Parametre de filtre sur la catégorie optionnel
4. Créer le service correspondant (pas de logique métier dans le controlleur)
5. Créer le repository.

Rules (non negociables) :

- Verbe HTTP correct, route au pluriel (/demandes).
- Aucun secret en dur ; aucune dependance non justifiee.
- Reponse paginee ou bornee (ne pas retourner toute la table sans limite).
- Cas vide gere explicitement (liste vide, pas d erreur).

Format de sortie : le code du controller uniquement + une phrase par choix non evident.
