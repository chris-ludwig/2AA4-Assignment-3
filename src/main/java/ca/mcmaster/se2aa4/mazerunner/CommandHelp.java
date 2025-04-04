package ca.mcmaster.se2aa4.mazerunner;

public class CommandHelp implements Command {//command request for help string
    private HelpCLI hc;

    public CommandHelp(HelpCLI hc){
        this.hc = hc;
    }

    public void execute(){
        hc.help();
    }
}
