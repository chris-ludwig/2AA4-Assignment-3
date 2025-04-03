package ca.mcmaster.se2aa4.mazerunner;

public class CommandTestPath implements Command {
    TestExplorer te;
    String path;
    Maze maze;
    String mazeFile;

    public CommandTestPath(TestExplorer te, String path, Maze maze, String mazeFile){
        this.te = te;
        this.path = path;
        this.maze = maze;
        this.mazeFile = mazeFile;
    }

    public void execute(){
        maze.LoadMaze(mazeFile);
        te.exploreMaze(maze, maze.GetStart(), maze.GetFinish(), path);
    }
}
