package ca.mcmaster.se2aa4.mazerunner;

public class HelpResult implements ModelResult {//displays result from HelpCLI
    private String data;

    public HelpResult(String data){
        this.data = data;
    }

    public String getDisplayString(){
        return data;
    }
}
