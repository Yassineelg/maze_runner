package com.yassineelg.generators;

public class OptimizedMazeGenerator implements MazeGenerator {
    private final String generationType;

    /**
     * Constructeur de la classe OptimizedMazeGenerator.
     *
     * @param generationType Le type de génération de labyrinthe à utiliser
     *                       ("perfect" ou "imperfect").
     */
    public OptimizedMazeGenerator(String generationType) {
        this.generationType = generationType;
    }

    /**
     * Génère un labyrinthe en utilisant le générateur approprié en fonction du type
     * de génération spécifié.
     *
     * @param grid La grille du labyrinthe à générer.
     * @return La grille du labyrinthe générée.
     */
    @Override
    public char[][] generateMaze(char[][] grid) {
        if (generationType.equals("perfect")) {
            // Utilise le générateur de labyrinthe parfait
            return new SimplePerfectMazeGenerator().generateMaze(grid);
        } else if (generationType.equals("imperfect")) {
            // Utilise le générateur de labyrinthe imparfait
            return new SimpleImperfectMazeGenerator().generateMaze(grid);
        }
        // Retourne la grille telle quelle si le type de génération n'est pas reconnu
        return grid;
    }
}