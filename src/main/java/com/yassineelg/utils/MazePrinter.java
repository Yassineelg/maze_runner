package com.yassineelg.utils;

public class MazePrinter {
    /**
     * Affiche la grille du labyrinthe.
     *
     * @param grid La grille du labyrinthe.
     */
    public static void print(char[][] grid) {
        for (char[] row : grid) {
            System.out.println(new String(row));
        }
    }
}