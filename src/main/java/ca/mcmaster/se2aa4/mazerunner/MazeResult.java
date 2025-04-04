package ca.mcmaster.se2aa4.mazerunner;

public class MazeResult implements ModelResult{//Result from solving a maze
    private String path;

    public MazeResult(String path){
        this.path = path;
    }
    @Override
    public String getDisplayString() {//add option for no maze printing
        return path;
    }
}
