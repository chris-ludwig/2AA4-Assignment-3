package ca.mcmaster.se2aa4.mazerunner;

public class View {
    private String output;

    public void update(String output){
        this.output = output;

        System.out.println(this.output);
    }
}
