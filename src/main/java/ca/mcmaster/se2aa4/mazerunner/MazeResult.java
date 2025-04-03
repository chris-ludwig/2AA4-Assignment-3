package ca.mcmaster.se2aa4.mazerunner;

public class MazeResult implements ModelResult{
    private String path;

    public MazeResult(String path){
        this.path = path;
    }
    @Override
    public String getDisplayString() {
        
        return path;
    }
}
