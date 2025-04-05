package ca.mcmaster.se2aa4.mazerunner;

public class MazeResult implements ModelResult{//Result from solving a maze
    private String path;
    private String mazeString;

    public MazeResult(String path, String mazeString){
        this.mazeString = mazeString;
        this.path = path;
    }
    @Override
    public String getDisplayString() {
        return mazeString + path;
    }
}
