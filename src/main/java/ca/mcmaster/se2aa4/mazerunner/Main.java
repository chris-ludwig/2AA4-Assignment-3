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

            //reading file path
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);
            String mazeFile = cmd.getOptionValue("i");

            logger.trace("**** Reading the maze from file " + mazeFile);
            SimpleMaze maze = new SimpleMaze(mazeFile);
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.trace("**** Computing path");
        logger.info("** End of MazeRunner");
    }
}
