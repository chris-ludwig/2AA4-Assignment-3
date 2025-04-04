package ca.mcmaster.se2aa4.mazerunner;

public class HelpCLI implements Model{
    private ModelResult result;

    public void help(){//output is help string
        result = new HelpResult("""
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
                """  
        );
    }
    public void usage(){//output is usage string
        result = new HelpResult("Usage: java -jar mazerunner.jar -i <maze_file> [-p <path>]");
    }

    public ModelResult getData(){
        return result;
    }
}
