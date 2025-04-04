package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ExampleTest {
    public static void main(String[] args){

    }
    
    @Test
    public void sampleTest(){
        HelpCLI hc = new HelpCLI();
        SimpleMaze maze = new SimpleMaze();
        SimpleExplorer se = new SimpleExplorer();
        TestExplorer te = new TestExplorer();
        View view = new View();
        Command c;

      /*
       * Testing Explorer and Maze
       */ 

        //test load maze
        maze.LoadMaze("examples/straight.maz.txt");
        System.out.println(maze.GetMaze());
        assertTrue(Arrays.deepToString(maze.GetMaze()).equals(Arrays.deepToString(new char[][] {
            {'#', '#', '#', '#', '#'},
            {'#', '#', '#', '#', '#'},
            {' ', ' ', ' ', ' ', ' '},
            {'#', '#', '#', '#', '#'},
            {'#', '#', '#', '#', '#'}})));
        
        //test get start and get finish
        assertTrue(Arrays.equals(maze.GetStart(), new int[] {2, 0}));
        assertTrue(Arrays.equals(maze.GetFinish(), new int[] {2, 4}));

        //testing movements
        se.setPos(new int[] {0, 0}, new int[] {0, 1});
        se.MoveForward(true);
        se.TurnRight(true);
        se.MoveForward(true);
        se.MoveForward(true);
        se.MoveForward(true);
        se.TurnLeft(true);
        se.MoveForward(true);
        se.TurnLeft(true);
        se.MoveForward(true);
        se.checkWin(new int[] {2,2});
        assertTrue(se.exitFound);
        assertTrue(se.getData().getDisplayString().equals("FR3FLFLF"));



      /*
       * Testing commands and results
       */ 

        //test solving a maze
        c = new CommandSolveMaze(se, maze, "examples/straight.maz.txt");
        c.execute();
        assertTrue(se.getData().getDisplayString().equals("4F"));

        //test path testing
        c = new CommandTestPath(te, "path", maze, "examples/straight.maz.txt");
        c.execute();
        assertTrue(te.getData().getDisplayString().equals("correct"));
        c = new CommandTestPath(te, "LLF", maze, "examples/straight.maz.txt");
        c.execute();
        assertTrue(te.getData().getDisplayString().equals("incorrect"));
        c = new CommandTestPath(te, "LF", maze, "examples/straight.maz.txt");
        c.execute();
        assertTrue(te.getData().getDisplayString().equals("incorrect"));
        c = new CommandTestPath(te, "FFFFLLF", maze, "examples/straight.maz.txt");
        c.execute();
        assertTrue(te.getData().getDisplayString().equals("incorrect"));

        

        //test usage string
        c = new CommandUsage(hc);
        c.execute();
        assertTrue(hc.getData().getDisplayString().equals("Usage: java -jar mazerunner.jar -i <maze_file> [-p <path>]"));

        //test help string
        c = new CommandHelp(hc);
        c.execute();
        assertTrue(hc.getData().getDisplayString().equals("""
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
                """));
    }
}
