package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Controller {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws ParseException{
        Model model;
        Command command;
        View view = new View();

        logger.info("** Starting Maze Runner");
        //try {
            //defining flag
            Options options = new Options();
            options.addOption("i", true, "Maze");
            options.addOption("p", true, "Path");
            options.addOption("h", false, "help");
            options.addOption("u", false, "usage");

            //reading file path
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);

            if(cmd.hasOption("i")){//involves maze
                String mazeFile = cmd.getOptionValue("i");
                Maze maze = new SimpleMaze();

                if(cmd.hasOption("p")){//test a path
                    model = new TestExplorer();
                    String path = cmd.getOptionValue("p");
                    
                    command = new CommandTestPath((TestExplorer) model, path, maze, mazeFile);
                }
                else{//solve a maze
                    model = new SimpleExplorer();

                    command = new CommandSolveMaze((Explorer) model, maze, mazeFile);
                }
            }
            else if(cmd.hasOption("u")){//usage
                HelpCLI hc = new HelpCLI();
                model = hc;
                command = new CommandUsage(hc);
            }
            else {//incorrect input or help
                HelpCLI hc = new HelpCLI();
                model = hc;

                command = new CommandHelp(hc);
            }


            command.execute();
            ModelResult mr = model.getData();
            view.update(mr);

           
           /*  logger.trace("**** Reading the maze from file " + mazeFile);
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
            }*/
        //} catch(Exception e) {
          //  logger.error("/!\\ An error has occured /!\\");
        //}
        logger.trace("**** Computing path");
        logger.info("** End of MazeRunner");
    }
}
