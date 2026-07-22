# Exercice : brouillon

[PLAN]
Objectif : exposer GET /produits/{id}/disponibilite sur le service catalogue
(stock, prix HT, taux TVA, actif) pour le futur service commandes.
Etapes prevues :

  1. Creer le DTO DisponibiliteDto (produitId, stock, prixHt, tauxTva, actif)
  2. Ajouter la methode disponibilite(id) dans ProduitService (404 si produit inconnu)
  3. Ajouter la route GET /produits/{id}/disponibilite dans ProduitController
  4. Ajouter un test : produit connu -> 200, produit inconnu -> 404
  5. Lancer ./gradlew test

[ACT]
Creation de src/main/java/.../dto/DisponibiliteDto.java (+9 lignes)
Modification de src/main/java/.../service/ProduitService.java (+7 lignes)
Modification de src/main/java/.../web/ProduitController.java (+6 lignes)
Creation de src/test/java/.../web/ProduitControllerDisponibiliteTest.java (+38 lignes)

[VERIFY]
Commande : ./gradlew test   ->   BUILD SUCCESSFUL, 24 tests completed, 0 failed
Diff total : 4 fichiers, +60 -0 ; conforme au plan, aucun autre fichier touche


---



[PLAN]

[ACT]
Modification de src/main/java/.../service/ProduitService.java (+11 lignes)
Modification de src/main/java/.../web/ProduitController.java (+5 lignes)
Ajout de la dependance "spring-boot-starter-availability:3.4.1" dans build.gradle -> POURQUOI ?
Modification de src/main/resources/application.yaml (+3 lignes)
[VERIFY]
Build OK.


|Contrôle |Question |Verdict sur la trace |Action|


3. secrets
Question : Y a t'il ecrit ou modifier des secrets (ligne ou fichier) ?
Verdict : KO - On ne sais pas ce qu'il a écrit dans le application.yaml
Action : Verifier le /les fichiers

4. tests
Question : A t'il fait des tests de non regression + des nouveaux ? Sont ils passés a Ok ?
Verdict : KO - il n'y a pas de tests
Action : Redemander a l'IA de s'executé en faisant des tests

1. relecture ligne à ligne
Question : Est ce que je peux relire ligne a ligne ? (bcp trop de lignes modifiés ?)(bcp trop de fichiers modifiés ?)
Verdict : KO - On n'a pas des information dabns le log/chat.
Action : Aller verifier manuellement avec git diff.



------

NOTE pour moi : 
Quel est la difference entre ces exercice et les rules ???