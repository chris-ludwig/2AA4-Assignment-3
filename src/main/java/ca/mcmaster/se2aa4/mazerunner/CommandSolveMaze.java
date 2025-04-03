package ca.mcmaster.se2aa4.mazerunner;

public class CommandSolveMaze implements Command {
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
        explorer.exploreMaze(maze, maze.GetStart(), maze.GetFinish());
    }
}
