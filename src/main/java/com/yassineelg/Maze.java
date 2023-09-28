package com.yassineelg;

import com.yassineelg.generators.MazeGenerator;
import com.yassineelg.utils.*;

public class Maze {
    private final int width;
    private final int height;
    private final String mazeType;
    private final String generationType;
    private char[][] grid;

    /**
     * Constructeur de la classe Maze.
     *
     * @param width          La largeur du labyrinthe.
     * @param height         La hauteur du labyrinthe.
     * @param mazeType       Le type de labyrinthe à générer.
     * @param generationType La méthode de génération à utiliser.
     */
    public Maze(int width, int height, String mazeType, String generationType) {
        this.width = width * 3;
        this.height = height * 3;
        this.mazeType = mazeType;
        this.generationType = generationType;
        this.grid = new char[height * 3][width * 3];
        initializeMaze();
    }

    /**
     * Initialise la grille du labyrinthe avec des murs et des espaces vides.
     */
    private void initializeMaze() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // Utilise la méthode isBorder() de la classe MazeUtils pour initialiser la
                // grille avec des murs et des espaces vides.
                grid[i][j] = MazeUtils.isBorder(i, j, height, width) ? '#' : '.';
            }
        }
        // Ouvre une entrée et une sortie dans le labyrinthe.
        grid[0][1] = '.';
        grid[height - 1][width - 2] = '.';
    }

    /**
     * Génère le labyrinthe en utilisant le générateur de labyrinthe approprié.
     */
    public void generate() {
        MazeGenerator generator = MazeGeneratorFactory.createGenerator(mazeType, generationType);
        generator.generateMaze(grid);
    }

    /**
     * Affiche la grille du labyrinthe.
     */
    public void print() {
        // Utilise la méthode print() de la classe MazePrinter pour afficher la grille
        // du labyrinthe.
        MazePrinter.print(grid);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getMazeType() {
        return mazeType;
    }

    public String getGenerationType() {
        return generationType;
    }

    public char[][] getGrid() {
        return grid;
    }
}