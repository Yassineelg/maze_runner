<div align="center">
  <img src="https://media.giphy.com/media/1EmBoG0IL50VIJLWTs/giphy.gif" alt="Maze Runner GIF" width="100%" height="250">
  <h1>Maze Runner</h1>
  <p>Your Java Labyrinth Generator Project</p>

[![GitHub License](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/MIT)
[![Java Version](https://img.shields.io/badge/java-21+-orange.svg)](https://www.oracle.com/java/technologies/javase-downloads.html)
[![Maven Version](https://img.shields.io/badge/maven-3.9.4+-green.svg)](https://maven.apache.org/download.cgi)

</div>

![Maze Runner Demo](demo.gif)

## 📜 Table of Contents

- [🚀 Introduction](#-introduction)
- [✨ Features](#-features)
- [🛠️ Getting Started](#%EF%B8%8F-getting-started)
  - [📋 Prerequisites](#-prerequisites)
  - [🔧 Installation](#-installation)
- [🔥 Usage](#-usage)
  - [🌌 Generating a Maze](#-generating-a-maze)
  - [🎨 Customization](#-customization)
  - [🔗 Example Mazes](#-example-mazes)
- [🌀 Types of Mazes](#-types-of-mazes)
- [⚡ Optimized Generation](#-optimized-generation)
- [📺 Project Demonstration](#-project-demonstration)
- [🤝 Contributing](#-contributing)
- [📝 License](#-license)

## 🚀 Introduction

Maze Runner is your ultimate Java solution for labyrinth generation. Create perfect and imperfect mazes with optimized algorithms, all from the command line. Whether you're a maze enthusiast or a developer seeking labyrinth challenges, Maze Runner has you covered.

## ✨ Features

- **Effortless Maze Generation**: Generate perfect and imperfect mazes with ease.
- **Optimized Algorithms**: Utilize optimized algorithms for lightning-fast maze creation.
- **User-Friendly CLI**: Interact with the command-line interface for seamless operation.
- **Error Handling**: Comprehensive error handling and informative user feedback.
- **Customizable Mazes**: Create labyrinths of various sizes and types.

## 🛠️ Getting Started

### 📋 Prerequisites

- **Java 21 or Higher**: [Download Java](https://www.oracle.com/java/technologies/javase-downloads.html)
- **Maven 3.9.4 or Higher**: [Download Maven](https://maven.apache.org/download.cgi)
- **Git (Optional)**: [Download Git](https://git-scm.com/downloads)

### 🔧 Installation

1. Clone the Maze Runner repository (or download and unzip it):

   ```shell
   git clone https://github.com/yassineelg/maze_runner.git
   ```

2. Navigate to the project directory:

   ```shell
   cd maze_runner
   ```

3. Compile and package the project using Maven:

   ```shell
   mvn package
   ```

## 🔥 Usage

### 🌌 Generating a Maze

Generate a maze by specifying its dimensions (width and height) and the type of maze (perfect or imperfect).

```shell
java -jar MazeRunner.jar <width> <height> <type> <options>
```

### 🎨 Customization

- Explore different maze types: "perfect" or "imperfect."
- Experiment with various sizes for unique challenges.
- Optimize generation for quicker results using the "optimized" option.

### 🔗 Example Mazes

Here are examples of different types of mazes you can generate:

#### 🌟 Perfect Maze

```shell
java -jar MazeRunner.jar 10 10 perfect
```

```
#.#############
#.............#
#############.#
#############.#
#....##.......#
#.#####.#######
#.#####.#######
#.......##....#
#.###########.#
#.###########.#
#.##.......##.#
#.#####.##.##.#
#.#####.##.##.#
#.......##....#
#############.#
```

#### 🌟 Imperfect Maze

```shell
java -jar MazeRunner.jar 10 10 imperfect
```

```
#.#############
#....##.......#
####.##.#####.#
####.##.#####.#
#.##.##....##.#
#.##.#####.##.#
#.##.#####.##.#
#.##..........#
#.##.########.#
#.##.########.#
#.##.......##.#
#.##.#####.##.#
#.##.#####.##.#
#.......##....#
#############.#
```

#### 🌟 Graph-Based Maze

```shell
java -jar MazeRunner.jar 10 10 perfect graph
```

```
[WORK IN PROGRESS]
```

## 🌀 Types of Mazes

- **Perfect Maze**: Contains no loops or closed paths, providing a challenging puzzle.
- **Imperfect Maze**: May have loops and dead ends, making it more intricate.
- **Graph-Based Maze**: Generated using a graph-based approach for a different labyrinth experience.

## ⚡ Optimized Generation

For the fastest maze generation, consider using the optimized option. This reduces generation time significantly while delivering high-quality mazes.

```shell
java -jar MazeRunner.jar 20 20 perfect optimized
```

## 📺 Project Demonstration

Explore Maze Runner in action! Watch our project demonstration video to see how it works and discover its features:

[![Maze Runner Demo Video](demo_video_thumbnail.png)](https://www.example.com/demo_video)

## 🤝 Contributing

We welcome contributions to Maze Runner! Feel free to open issues, suggest enhancements, or submit pull requests. Please review our [Contributing Guidelines](CONTRIBUTING.md) for more information.

## 📝 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

Now you're all set to embark on your maze-generating journey with Maze Runner! If you have any questions or encounter issues, don't hesitate to reach out to us. Happy coding!
