package com.yassineelg.utils;

public class MazeUtils {
    /**
     * Vérifie si la case à la position (i, j) est un mur de la grille.
     *
     * @param i      La position verticale de la case.
     * @param j      La position horizontale de la case.
     * @param height La hauteur de la grille.
     * @param width  La largeur de la grille.
     * @return true si la case est un mur, false sinon.
     */
    public static boolean isBorder(int i, int j, int height, int width) {
        return i == 0 || i == height - 1 || j == 0 || j == width - 1;
    }
}