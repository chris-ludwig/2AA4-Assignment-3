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

            //reading file path
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);
            String mazeFile = cmd.getOptionValue("i");
            String path = cmd.getOptionValue("p");

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
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.trace("**** Computing path");
        logger.info("** End of MazeRunner");
    }
}
