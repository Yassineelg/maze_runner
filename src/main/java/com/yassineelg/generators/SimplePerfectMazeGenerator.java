package com.yassineelg.generators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class SimplePerfectMazeGenerator implements MazeGenerator {
    private static final char WALL = '#';
    private static final char PATH = '.';
    private static final int[][] DIRECTIONS = { { 0, 2 }, { 2, 0 }, { 0, -2 }, { -2, 0 } };

    /**
     * Génère un labyrinthe parfait à partir d'une grille donnée.
     *
     * @param grid La grille du labyrinthe à générer.
     * @return La grille du labyrinthe générée.
     */
    @Override
    public char[][] generateMaze(char[][] grid) {
        int height = grid.length;
        int width = grid[0].length;

        Random random = new Random();

        // Générer une position de départ aléatoire dans une cellule impaire
        int startX = 1 + random.nextInt(width / 2 - 1) * 2;
        int startY = 1 + random.nextInt(height / 2 - 1) * 2;
        grid[startY][startX] = PATH;

        buildMaze(grid, startX, startY);

        // Ajouter des entrées et sorties au labyrinthe
        grid[0][1] = PATH;
        grid[height - 1][width - 2] = PATH;

        return grid;
    }

    /**
     * Construit le labyrinthe en utilisant l'algorithme de génération de labyrinthe
     * parfait.
     *
     * @param grid La grille du labyrinthe en cours de construction.
     * @param x    La coordonnée X de la cellule actuelle.
     * @param y    La coordonnée Y de la cellule actuelle.
     */
    private static void buildMaze(char[][] grid, int x, int y) {
        ArrayList<int[]> directions = new ArrayList<>(Arrays.asList(DIRECTIONS));
        Collections.shuffle(directions, new Random());

        for (int[] direction : directions) {
            int dx = direction[0];
            int dy = direction[1];
            int nx = x + dx;
            int ny = y + dy;

            if (nx >= 0 && nx < grid[0].length && ny >= 0 && ny < grid.length) {
                if (grid[ny][nx] == WALL) {
                    // Supprimer le mur entre la cellule courante et la cellule voisine
                    grid[y + dy / 2][x + dx / 2] = PATH;
                    grid[ny][nx] = PATH;

                    // Récursion pour continuer à générer le labyrinthe
                    buildMaze(grid, nx, ny);
                }
            }
        }
    }
}