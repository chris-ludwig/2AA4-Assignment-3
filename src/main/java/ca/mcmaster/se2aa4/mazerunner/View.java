package ca.mcmaster.se2aa4.mazerunner;

public class View {//displays output
    private String output;

    public void update(ModelResult result){
        this.output = result.getDisplayString();

        System.out.println(this.output);
    }
}
