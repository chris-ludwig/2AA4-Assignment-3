package ca.mcmaster.se2aa4.mazerunner;

public class CommandSolveMaze implements Command {//command to solve a maze
    Maze maze;
    Explorer explorer;
    String mazeFile;
    
    public CommandSolveMaze(Explorer explorer, Maze maze, String mazeFile){
        this.mazeFile = mazeFile;
        this.maze = maze;
        this.explorer = explorer;
    }

    public void execute(){
        maze.LoadMaze(mazeFile);
        explorer.exploreMaze(maze);
    }
}
