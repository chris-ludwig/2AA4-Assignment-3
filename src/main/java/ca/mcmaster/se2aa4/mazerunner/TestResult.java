package ca.mcmaster.se2aa4.mazerunner;

public class TestResult implements ModelResult {
    private boolean exitFound;
    public TestResult(boolean exitFound){
        this.exitFound = exitFound;
    }

    @Override
    public String getDisplayString() {
        if(exitFound){
            return "correct";
        }
        else{
            return "incorrect";
        }
    }
}
