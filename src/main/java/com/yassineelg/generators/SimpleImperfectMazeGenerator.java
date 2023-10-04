package com.yassineelg.generators;

import java.util.Random;

public class SimpleImperfectMazeGenerator implements MazeGenerator {

    /**
     * Génère un labyrinthe imparfait à partir d'une grille donnée.
     *
     * @param grid La grille du labyrinthe à générer.
     * @return La grille du labyrinthe générée.
     */
    @Override
    public char[][] generateMaze(char[][] grid) {
        int height = grid.length;
        int width = grid[0].length;

        // Remplit initialement la grille de murs ('#')
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = '#';
            }
        }

        Random random = new Random();

        // Parcours les cellules impaires de la grille
        for (int i = 1; i < height - 1; i += 2) {
            for (int j = 1; j < width - 1; j += 2) {
                grid[i][j] = '.';

                // Détermine aléatoirement si une cellule voisine doit être ouverte
                if (random.nextBoolean()) {
                    if (i - 1 >= 1) {
                        grid[i - 1][j] = '.';
                    }
                    if (i + 1 < height - 1) {
                        grid[i + 1][j] = '.';
                    }
                    if (i + 2 < height - 1 && height % 2 == 0) {
                        grid[i + 2][j] = '.';
                    }
                } else {
                    if (j - 1 >= 1) {
                        grid[i][j - 1] = '.';
                    }
                    if (j + 1 < width - 1) {
                        grid[i][j + 1] = '.';
                    }
                    if (j + 2 < width - 1 && width % 2 == 0) {
                        grid[i][j + 2] = '.';
                    }
                }
                if (width % 2 == 0) {
                    j += 1;
                }
            }
            if (height % 2 == 0) {
                i += 1;
            }
        }

        // Ajoute des entrées et sorties au labyrinthe
        grid[0][1] = '.';
        grid[height - 1][width - 2] = '.';

        return grid;
    }
}