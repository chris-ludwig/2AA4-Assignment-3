package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Controller {//handles input and passes information to output

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws ParseException{
        Model model;
        Command command;
        View view = new View();

        logger.info("** Starting Maze Runner");
        try {
            //defining flag
            Options options = new Options();
            options.addOption("i", true, "Maze");
            options.addOption("p", true, "Path");
            options.addOption("h", false, "help");
            options.addOption("u", false, "usage");

            //reading file path
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);

            //deciding which command to use
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

            //execute command, receive data, and pass to output
            command.execute();
            ModelResult mr = model.getData();
            view.update(mr);

        
        } catch(Exception e) {
          logger.error("/!\\ An error has occured /!\\");
        }
        logger.trace("**** Computing path");
        logger.info("** End of MazeRunner");
    }
}
