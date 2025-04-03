package ca.mcmaster.se2aa4.mazerunner;

public class CommandHelp implements Command {
    private HelpCLI hc;

    public CommandHelp(HelpCLI hc){
        this.hc = hc;
    }

    public void execute(){
        hc.help();
    }
}
