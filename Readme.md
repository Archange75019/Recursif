# Modification Récursive de Fichiers

Ce projet contient des scripts en Python et Java pour parcourir récursivement un répertoire, modifier le contenu des fichiers et renommer les fichiers selon certaines règles.

## Script Python

Le script Python parcourt récursivement un répertoire, lit le contenu de chaque fichier, remplace la chaîne "tata" par "toto" et ajoute "coucou" à la fin du contenu.

```python
import os

dossier = 'dossier'  # Chemin du répertoire à explorer

# Fonction récursive pour parcourir les répertoires
def parcourir_et_modifier(repertoire):
    for racine, dossiers, fichiers in os.walk(repertoire):
        for fichier in fichiers:
            chemin_complet = os.path.join(racine, fichier)
            print(f"Fichier : {fichier}")

            # Lire le contenu du fichier
            with open(chemin_complet, 'r', encoding='utf-8') as file:
                contenu = file.read()

            # Modifier le contenu
            nouveau_contenu = contenu.replace('tata', 'toto') + '\ncoucou'

            # Écrire le nouveau contenu dans le fichier
            with open(chemin_complet, 'w', encoding='utf-8') as file:
                file.write(nouveau_contenu)

            print(f"Modifié : {fichier}")

        for dossier in dossiers:
            print(f"Dossier : {dossier}")

# Appel de la fonction pour commencer le parcours
parcourir_et_modifier(dossier)

```

### Execution

```
python index.py
```

## Script Java
Le script Java parcourt récursivement un répertoire, lit le contenu de chaque fichier, remplace la chaîne "toto" par "tutu" et ajoute "coucou" à la fin du contenu.

### Execution
Compilez le fichier avec la commande suivante :
```
javac RenommerFichiers.java
```
Exécutez la classe compilée avec la commande suivante:
```
java RenommerFichiers
```
