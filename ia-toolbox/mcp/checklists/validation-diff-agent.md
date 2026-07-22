# Checklist - validation d'un diff d'agent

## Avant de lancer l'agent (plan)

- [ ] Objectif etroit et ecrit (une phrase, un perimetre)
- [ ] Travail sur une branche dediee (pas main)
- [ ] Plan explicite valide AVANT toute ecriture de code

## Pendant (act)

- [ ] Réalise des petits incréments( pas plus de 15 fchiers ou 600 lignes modifié)
- [ ] Utilise des commandes lancées connues
- [ ] Pas d'écriture hors chemins autorisés (pas dans les fichiers et dossiers strictement interdit)

## Après (verify)

### 1.périmètre

- [ ] Verifier que tu ecris seulement ce que est demandé / prévu

### 2.dépendances

- [ ] Verifier que les dépendances ajouté son bien utile

### 3.secrets

- [ ] Verifie que tu n'as pas écrit ou modifié des secrets (ligne ou fichier)

### 4.tests

- [ ] Les testes ont été ecrit ?
- [ ] Les tests ont été lancé ?

### 5.relecture

- [ ] Est ce que je peux relire ligne a ligne ?
- [ ] bcp trop de lignes modifiés ?
- [ ] bcp trop de fichiers modifiés ?

## Garde-fous transverses

- [ ] coûts/tokens bornés : limite ton utilisation a 2 000 token
- [ ] secrets hors contexte : n'envoie pas de secret
- [ ] rollback Git possible : permet le retour en arrière
