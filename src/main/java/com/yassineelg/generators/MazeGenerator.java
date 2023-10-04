package com.yassineelg.generators;

/**
 * Une interface pour générer des labyrinthes.
 */
public interface MazeGenerator {

    /**
     * Génère un labyrinthe à partir d'une grille donnée.
     *
     * @param grid La grille sur laquelle générer le labyrinthe.
     * @return La grille du labyrinthe généré.
     */
    public char[][] generateMaze(char[][] grid);
}