package ca.mcmaster.se2aa4.mazerunner;

public abstract class Explorer implements Model{
    protected String path = "";//where moves will be stored
    protected int[] pos = {0,0};//explorer position
    protected int[] dir;//west = [0, -1], north = [-1,0], east = [0,1], south = [1,0]
    protected boolean exitFound;
    
    protected void checkWin(int[] destination){
        exitFound = pos[0] == destination[0] && pos[1] == destination[1];
    }

    //define movement of explorer
    protected void TurnRight(boolean tracking){
        if(dir[0] == 0){
            dir[0] = dir[1];
            dir[1] = 0;
        }
        else{
            dir[1] = -dir[0];
            dir[0] = 0;
        }

        if(tracking){
            path += 'R';
        }
    }
    protected void TurnLeft(boolean tracking){
        if(dir[1] == 0){
            dir[1] = dir[0];
            dir[0] = 0;
        }
        else{
            dir[0] = -dir[1];
            dir[1] = 0;
        }

        if(tracking){
            path += 'L';
        }
    }
    protected void MoveForward(boolean tracking){
        pos[0] += dir[0];
        pos[1] += dir[1];

        if(tracking){
            path += 'F';
        }
    }

    //condense path down into factorized form
    protected String FactorizePath(String path){
        String factorizedPath = "";
        char recent = '\0';
        int counter = 1;
        //iterate thru path
        for (int i=0; i<path.length(); i++)
        {
            //counts repeated instructions
            if (path.charAt(i) == recent){
                counter++;
            }
            else{
                //adding factorized instruction to the rest of path
                if(counter > 1) factorizedPath = factorizedPath + counter + recent;
                else if(recent != '\0') factorizedPath += recent;
                //resetting counter and recent
                counter = 1;
                recent = path.charAt(i);
            }
        }
        //add final characters
        if(counter > 1) factorizedPath = factorizedPath + counter + recent;
        else factorizedPath += recent;

        return factorizedPath;
    }
    //take factorized path and expand into instructions
    protected String UnfactorizePath(String path){
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < path.length()) {
            char currentChar = path.charAt(i);

            if (currentChar >= '2' && currentChar <= '9') { 
                // If the character is a digit between 2-9, get the next character and repeat it
                if (i + 1 < path.length()) { 
                    char toRepeat = path.charAt(i + 1);
                    int repeatCount = Character.getNumericValue(currentChar);

                    // Append the character 'repeatCount' times
                    result.append(String.valueOf(toRepeat).repeat(repeatCount));

                    i += 2; // Move past the number and the character
                } else {
                    //invalid input
                    throw new IllegalArgumentException("Invalid input format: number at end of string");
                }
            } else {
                //if character just add it normally
                result.append(currentChar);
                i++;
            }
        }

        return result.toString();
    }

    protected void setPos(int[] pos, int[] dir){//needed for testing
        this.pos = pos;
        this.dir = dir;
    }
    

    public abstract void exploreMaze(Maze maze);
}
