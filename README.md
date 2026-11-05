# Mini-Projet Génie Logiciel : Calculatrice RPN (MVC)

Ce projet est réalisé dans le cadre du cours de **Génie Logiciel** (M1 - IMT Mines Alès). 
Il s'agit d'une calculatrice à **Notation Polonaise Inverse (RPN)** implémentée en **Java** et **JavaFX** en suivant le patron d'architecture **Modèle-Vue-Contrôleur (MVC)**.

---

## Architecture du Projet

Le code source est organisé dans le répertoire `src/` selon les paquetages MVC suivants :

* `modèle/` : Contient la logique métier, l'accumulateur et la gestion de la pile de mémoire (`CalculatorModel`).
* `contrôleur/` : Gère l'interaction entre la Vue et le Modèle (`CalculatorControler`).
* `vue/` : Gère l'interface graphique utilisateur développée en JavaFX (`CalculatorGUI`).
* `application/` : Contient le point d'entrée et le lanceur de l'application JavaFX (`MainFX`).

---

## Comment Exécuter le Projet

### Prérequis
* **JDK** (Java Development Kit 17 ou supérieur)
* **JavaFX SDK** (compatible avec votre version de Java)
* **Eclipse IDE** (avec support JavaFX)

### Instructions de Lancement sous Eclipse

1. **Cloner le dépôt :**
   ```bash
   git clone <https://github.com/Lyhour7777/JavaCalculette.git>
   ```
   
2. **Importer le projet dans Eclipse :**

* Aller dans `File > Import... > General > Existing Projects into Workspace`.

* Sélectionner le dossier cloné et valider.

3. **Configurer les arguments VM JavaFX :**

* Faires un clic droit sur `application/MainFX.java > Run As > Run Configurations....`

* Sélectionner l'onglet Arguments.

* Dans la case VM arguments, ajouter le chemin vers votre dossier `lib` JavaFX local :
```bash
--module-path "<CHEMIN_VERS_VOTRE_JAVAFX_SDK>\lib" --add-modules javafx.controls,javafx.fxml
```
* Appliquer et cliquer sur *Run*.

## Fonctionnalités Principales (RPN)
Accumulateur & Pile (Stack) : Saisie dynamique des nombres et empilement.

Opérations Arithmétiques : Addition (+), Soustraction (-), Multiplication (*), Division (/).

Gestion de Pile :

Push : Empile la valeur de l'accumulateur.

Pop : Récupère le sommet de la pile dans l'accumulateur.

Drop : Supprime l'élément au sommet de la pile.

<> (Swap) : Échange la valeur de l'accumulateur avec le sommet de la pile.

+/- : Inverse le signe du nombre courant.
## Auteurs
Projet réalisé par l'équipe d'étudiants (M1 2IA /SEM Yuthearylyhour, Chaimae)