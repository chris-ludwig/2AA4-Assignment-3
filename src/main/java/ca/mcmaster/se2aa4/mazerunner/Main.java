package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        try {
            //defining flag
            Options options = new Options();
            options.addOption("i", true, "Maze");
            options.addOption("p", true, "Path");
            options.addOption("h", false, "help");

            //reading file path
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);
            String mazeFile = cmd.getOptionValue("i");
            String path = cmd.getOptionValue("p");

            if (cmd.hasOption("h")){
                String usageMessage = """
                Usage: java -jar mazerunner.jar -i <maze_file> [-p <path>]
                
                Description:
                This program explores a maze and generates a sequence of instructions to navigate from an entry point to an exit.
                It can also verify a given path if the '-p' flag is provided.

                Options:
                -i <maze_file>   Specifies the input maze file. (Required)
                -p <path>        Specifies a path to verify against the maze. (Optional)
                -h               Displays this help message.

                Maze Format:
                - The maze is stored in a text file.
                - Walls are represented by '#' and passages by spaces (' ').
                - The maze is surrounded by walls, except for entry/exit points on the East and West borders.

                Path Instructions:
                - 'F' means move forward.
                - 'R' means turn right (without moving).
                - 'L' means turn left (without moving).
                - A number means the following character is repeated that many times

                Examples:
                1. Compute a path for a given maze:
                    java -jar mazerunner.jar -i examples/maze1.txt

                2. Verify if a given path is valid:
                    java -jar mazerunner.jar -i examples/maze1.txt -p FFLFR2F
                """;

                System.out.println(usageMessage);
                System.exit(0);
            }

            logger.trace("**** Reading the maze from file " + mazeFile);
            SimpleMaze maze = new SimpleMaze(mazeFile);
            if (path != null){
                TestExplorer testExplorer = new TestExplorer();
                //testing if path works from either entrance
                if(testExplorer.exploreMaze(maze, maze.GetStart(), maze.GetFinish(), path) || testExplorer.exploreMaze(maze, maze.GetFinish(), maze.GetStart(), path)){
                    System.out.println(path + " is a valid path to reach the end of the maze.");
                }
                else{
                    System.out.println(path + " is not a valid path to reach the end of the maze.");
                }
            }
            else{
                SimpleExplorer simpleExplorer = new SimpleExplorer();
                if(!simpleExplorer.exploreMaze(maze, maze.GetStart(), maze.GetFinish())) System.out.println("The maze is impossible");
            }
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.trace("**** Computing path");
        logger.info("** End of MazeRunner");
    }
}
