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
