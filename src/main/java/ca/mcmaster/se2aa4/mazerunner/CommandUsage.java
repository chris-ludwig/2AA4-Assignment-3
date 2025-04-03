package ca.mcmaster.se2aa4.mazerunner;

public class CommandUsage implements Command {
    private HelpCLI hc;

    public CommandUsage(HelpCLI hc){
        this.hc = hc;
    }

    public void execute(){
        hc.usage();
    }
}

