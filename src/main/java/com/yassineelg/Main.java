package com.yassineelg;

/**
 * Point d'entrée de l'application Maze Runner.
 * Génère un labyrinthe aléatoire en fonction des arguments fournis.
 */
public class Main {
    private static final int MIN_DIMENSION = 5;
    private static final String ERROR_ARGUMENTS = "Erreur : Veuillez fournir 4 arguments";
    private static final String ERROR_DIMENSIONS = "Erreur : Veuillez fournir une largeur et une hauteur valides supérieurs à 5";
    private static final String ERROR_INVALID_TYPES = "Erreur : Veuillez fournir un type de labyrinthe et une méthode de génération valides.";
    private static final String ERROR_UNEXPECTED = "Erreur inattendue lors de la génération du labyrinthe. Veuillez réessayer.";

    /**
     * Point d'entrée de l'application.
     *
     * @param args Les arguments fournis par l'utilisateur.
     */
    public static void main(String[] args) {
        if (args.length != 4) {
            printErrorMessage(ERROR_ARGUMENTS);
            return;
        }

        int mazeWidth, mazeHeight;
        String mazeType, generationType;

        try {
            mazeWidth = Integer.parseInt(args[0]);
            mazeHeight = Integer.parseInt(args[1]);
            generationType = args[2];
            mazeType = args[3];
        } catch (NumberFormatException e) {
            printErrorMessage(ERROR_DIMENSIONS);
            return;
        }

        if (mazeWidth < MIN_DIMENSION || mazeHeight < MIN_DIMENSION) {
            printErrorMessage(ERROR_DIMENSIONS);
            return;
        }

        if (!isValidMazeType(mazeType) || !isValidGenerationType(generationType)) {
            printErrorMessage(ERROR_INVALID_TYPES);
            return;
        }

        try {
            Maze maze = new Maze(mazeHeight, mazeWidth, mazeType, generationType);

            maze.generate();
            maze.print();
        } catch (Exception e) {
            printErrorMessage(ERROR_UNEXPECTED);
        }
    }

    /**
     * Vérifie si le type de génération est valide.
     *
     * @param type Le type de génération à vérifier.
     * @return true si le type de génération est valide, false sinon.
     */
    private static boolean isValidGenerationType(String type) {
        return type.matches("^(perfect|imperfect)$");
    }

    /**
     * Vérifie si le type de labyrinthe est valide.
     *
     * @param type Le type de labyrinthe à vérifier.
     * @return true si le type de labyrinthe est valide, false sinon.
     */
    private static boolean isValidMazeType(String type) {
        return type.matches("^(simple|graph|optimized)$");
    }

    /**
     * Affiche un message d'erreur et un guide d'utilisation pour l'utilisateur.
     *
     * @param message Le message d'erreur à afficher.
     */
    private static void printErrorMessage(String message) {
        System.err.println(message);
        System.err.println(
                "Utilisation : java -jar MazeRunner.jar [largeur] [hauteur] [perfect/imperfect] [simple/graph/optimized]");
    }
}