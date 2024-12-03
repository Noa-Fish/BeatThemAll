# BeatThemAll

  

## Description

  

**BeatThemAll** est un jeu de combat dans lequel des personnages (Héros et Ennemis) interagissent sur des étapes représentées sous forme de cartes. Les personnages peuvent attaquer, utiliser des capacités spéciales et se déplacer entre les cases du jeu. Le but est de vaincre tous les ennemis à chaque étape tout en utilisant différentes stratégies grâce aux attaques spéciales disponibles.

  

---

  

## Fonctionnalités

  

-  **Personnages** : Deux types de personnages sont implémentés — `Hero` et `Ennemi`.

-  **Attaques** : Les personnages peuvent attaquer en fonction de leur force et de la défense de la cible.

-  **Capacités spéciales** : Chaque héros dispose d'une capacité spéciale qu'il peut utiliser pendant le jeu.

-  **Cartes et Étapes** : Le jeu est structuré en cartes composées de différentes étapes. Chaque étape contient des cases où les personnages peuvent se déplacer.

-  **Affichage ASCII** : Le jeu affiche les étapes et les positions des personnages à l'aide d'un format ASCII.

  

---

  

## Installation

  

### Prérequis

  

1.  **Java** : Assurez-vous d'avoir Java 8 ou une version supérieure installé sur votre machine.

2.  **Maven** : Vous devez avoir [Apache Maven](https://maven.apache.org/) installé. Vous pouvez vérifier cela en exécutant la commande suivante dans votre terminal :

```bash

mvn -version

```  

### Étapes d'installation

  

1.  **Clonez le dépôt** ou téléchargez le fichier ZIP contenant le projet :

```bash

git clone https://votre-url-de-depot.git

```

  

2.  **Naviguez dans le répertoire du projet** :

```bash

cd BeatThemAll

```

  

3.  **Compilez le projet avec Maven** :

Utilisez la commande suivante pour télécharger les dépendances et compiler le projet :

```bash

mvn clean install

```

  

4.  **Exécutez le projet** :

Une fois la compilation terminée, vous pouvez exécuter le projet avec la commande Maven suivante :

```bash

mvn exec:java

```

  

Assurez-vous que la classe principale (`Main`) est configurée dans le fichier `pom.xml` pour que cette commande fonctionne correctement. Si ce n'est pas le cas, vous pouvez aussi exécuter la classe principale manuellement en utilisant :

  

```bash

mvn exec:java -Dexec.mainClass="com.beatthemall.Main"

```
Watel Noa & Tazani Nousseïba 

