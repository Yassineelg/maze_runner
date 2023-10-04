package com.yassineelg.utils;

public class MazeSolver {

    /**
     * Vérifie s'il existe une sortie valide dans le labyrinthe.
     *
     * @param grid La grille du labyrinthe.
     * @return true si une sortie valide existe, sinon false.
     */
    public static boolean hasValidExit(char[][] grid) {
        int height = grid.length;
        int width = grid[0].length;

        boolean[][] visited = new boolean[height][width];
        int startX = 0;
        int startY = 1;
        int endX = height - 1;
        int endY = width - 2;

        return solveMaze(grid, visited, startX, startY, endX, endY);
    }

    /**
     * Résout le labyrinthe en utilisant une recherche récursive.
     *
     * @param grid    La grille du labyrinthe.
     * @param visited Tableau pour suivre les cellules visitées.
     * @param x       Coordonnée X actuelle.
     * @param y       Coordonnée Y actuelle.
     * @param endX    Coordonnée X de la sortie souhaitée.
     * @param endY    Coordonnée Y de la sortie souhaitée.
     * @return true si une solution est trouvée, sinon false.
     */
    private static boolean solveMaze(char[][] grid, boolean[][] visited, int x, int y, int endX, int endY) {
        int height = grid.length;
        int width = grid[0].length;

        if (x == endX && y == endY) {
            return true;
        }

        visited[x][y] = true;

        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newX < height && newY >= 0 && newY < width
                    && !visited[newX][newY] && grid[newX][newY] == '.') {
                if (solveMaze(grid, visited, newX, newY, endX, endY)) {
                    return true;
                }
            }
        }

        return false;
    }
}