# Tic-Tac-Toe en JavaFX

Ce projet est une application de jeu de Tic-Tac-Toe développée en JavaFX. Les joueurs peuvent jouer contre un autre joueur ou contre un bot avec différents niveaux de difficulté.

## Fonctionnalités

- **Interface utilisateur** : Interface interactive avec JavaFX.
- **Modes de jeu** :
  - Joueur contre joueur
  - Joueur contre bot (facile et expert)
- **Suivi des scores** : Affiche les scores des joueurs et l'état actuel de la partie.
- **Fonctionnalités supplémentaires** :
  - Retour à l'écran d'accueil
  - Redémarrage de la partie

## Prérequis

- Java 11 ou plus récent
- JavaFX SDK

## Installation

1. Clonez le repository :
    ```sh
    git clone https://github.com/ewenman5137/TicTacToe
    cd tictactoe-javafx
    ```

2. Configurez votre IDE pour utiliser le SDK JavaFX. Référez-vous à la [documentation officielle](https://openjfx.io/openjfx-docs/) pour les instructions spécifiques à votre IDE.

## Exécution

Pour exécuter l'application, utilisez votre IDE ou la ligne de commande :

```sh
# Compilation
javac --module-path /path/to/javafx-sdk-11/lib --add-modules javafx.controls,javafx.fxml -d out src/com/example/tictactoe/*.java

# Exécution
java --module-path /path/to/javafx-sdk-11/lib --add-modules javafx.controls,javafx.fxml -cp out com.example.tictactoe.Main
