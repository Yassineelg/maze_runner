package com.yassineelg.generators;

import java.util.Random;

public class GraphBasedMazeGenerator implements MazeGenerator {
    @Override
    public char[][] generateMaze(char[][] grid) {
        int width = grid[0].length;
        int height = grid.length;

        Random random = new Random();

        // Choisit une cellule de départ aléatoire
        int startRow = random.nextInt(height);
        int startCol = random.nextInt(width);

        grid[startRow][startCol] = '.';

        int[][] potentialWalls = {
                { startRow - 1, startCol, -1, 0 },
                { startRow + 1, startCol, 1, 0 },
                { startRow, startCol - 1, 0, -1 },
                { startRow, startCol + 1, 0, 1 }
        };

        while (potentialWalls.length > 0) {
            // Sélectionne un mur potentiel de manière aléatoire
            int randomIndex = random.nextInt(potentialWalls.length);
            int[] wall = potentialWalls[randomIndex];

            int wallRow = wall[0];
            int wallCol = wall[1];
            int directionRow = wall[2];
            int directionCol = wall[3];

            if (isValidCell(wallRow, wallCol, height, width)) {
                if (grid[wallRow][wallCol] == '#') {
                    // Ouvre le mur sélectionné
                    grid[wallRow][wallCol] = '.';
                    grid[wallRow - directionRow][wallCol - directionCol] = '.';
                    potentialWalls = addPotentialWalls(wallRow, wallCol, potentialWalls);
                }
            }

            // Retire le mur sélectionné de la liste des murs potentiels
            potentialWalls = removeWallFromArray(randomIndex, potentialWalls);
        }

        return grid;
    }

    /**
     * Vérifie si une cellule est valide dans la grille.
     *
     * @param row    L'indice de ligne de la cellule à vérifier.
     * @param col    L'indice de colonne de la cellule à vérifier.
     * @param height La hauteur de la grille.
     * @param width  La largeur de la grille.
     * @return true si la cellule est valide, sinon false.
     */
    private boolean isValidCell(int row, int col, int height, int width) {
        return row >= 0 && row < height && col >= 0 && col < width;
    }

    /**
     * Ajoute de nouveaux murs potentiels autour d'une cellule donnée.
     *
     * @param row   L'indice de ligne de la cellule.
     * @param col   L'indice de colonne de la cellule.
     * @param walls Le tableau de murs potentiels actuel.
     * @return Le tableau de murs potentiels mis à jour.
     */
    private int[][] addPotentialWalls(int row, int col, int[][] walls) {
        int[][] newWalls = new int[walls.length + 4][4];
        System.arraycopy(walls, 0, newWalls, 0, walls.length);

        newWalls[walls.length] = new int[] { row - 1, col, -1, 0 };
        newWalls[walls.length + 1] = new int[] { row + 1, col, 1, 0 };
        newWalls[walls.length + 2] = new int[] { row, col - 1, 0, -1 };
        newWalls[walls.length + 3] = new int[] { row, col + 1, 0, 1 };

        return newWalls;
    }

    /**
     * Retire un mur de la liste des murs potentiels.
     *
     * @param index L'indice du mur à retirer.
     * @param walls Le tableau de murs potentiels actuel.
     * @return Le tableau de murs potentiels mis à jour.
     */
    private int[][] removeWallFromArray(int index, int[][] walls) {
        int[][] newWalls = new int[walls.length - 1][4];

        for (int i = 0, j = 0; i < walls.length; i++) {
            if (i != index) {
                newWalls[j] = walls[i];
                j++;
            }
        }

        return newWalls;
    }
}