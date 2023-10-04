package com.yassineelg;

import com.yassineelg.generators.*;

public class MazeGeneratorFactory {
    /**
     * Crée une instance du générateur de labyrinthe approprié en fonction des
     * paramètres fournis.
     *
     * @param mazeType       Le type de labyrinthe à générer.
     * @param generationType Le type de génération à utiliser.
     * @return Une instance du générateur de labyrinthe approprié.
     * @throws IllegalArgumentException Si les paramètres fournis sont invalides.
     */
    public static MazeGenerator createGenerator(String mazeType, String generationType) {
        switch (mazeType) {
            case "simple":
                switch (generationType) {
                    case "perfect":
                        return new SimplePerfectMazeGenerator();
                    case "imperfect":
                        return new SimpleImperfectMazeGenerator();
                    default:
                        break;
                }
                break;
            case "graph":
                return new GraphBasedMazeGenerator();
            case "optimized":
                return new OptimizedMazeGenerator(generationType);
            default:
                break;
        }
        throw new IllegalArgumentException("Invalid maze type or generation type.");
    }
}