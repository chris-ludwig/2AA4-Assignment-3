package ca.mcmaster.se2aa4.mazerunner;

public class TestResult implements ModelResult {//results from testing a path
    private boolean exitFound;
    private String mazeString;
    public TestResult(boolean exitFound, String mazeString){
        this.exitFound = exitFound;
        this.mazeString = mazeString;
    }

    @Override
    public String getDisplayString() {
        if(exitFound){
            return mazeString + "correct";
        }
        else{
            return mazeString + "incorrect";
        }
    }
}
