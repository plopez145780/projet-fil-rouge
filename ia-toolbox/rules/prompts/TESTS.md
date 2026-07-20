# Prompt - Generer les tests unitaires d'un service

Categorie : tests  |  Stack : Spring Boot / .NET  |  Maj : 2026-07-09

## Parametres

- {{SERVICE}} : classe de service a tester (ex. DemandeService)
- {{METHODE}} : methode ciblee (ex. listerParStatut)

## Prompt

Role : developpeur attentif aux tests metier.
Contexte : respecte rules/tests.md (tests metier, cas limites, pas de test tautologique).
Tache : ecris les tests unitaires de {{METHODE}} dans {{SERVICE}}.
Couvre : cas nominal, cas vide, statut inexistant, entree invalide.
Format de sortie : classe de test complete + une phrase justifiant chaque cas limite.

## Sortie attendue (forme)

Une classe de test avec >= 4 cas, assertions sur le comportement metier (pas seulement "non null").
