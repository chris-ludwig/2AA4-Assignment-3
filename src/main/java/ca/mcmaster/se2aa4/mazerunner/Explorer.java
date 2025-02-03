package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public abstract class Explorer {
    protected char[] path;//where moves will be stored
    protected int[] pos = {0,0};//explorer position
    protected int[] dir;//west = [0, -1], north = [-1,0], east = [0,1], south = [1,0]
    private int moveNum = 0;//number of moves
    
    protected boolean checkWin(int[] destination){
        return pos[0] == destination[0] && pos[1] == destination[1];
    }
    public char[] getPath(){
        return path;
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
            path[moveNum] = 'R';
            moveNum++;
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
            path[moveNum] = 'L';
            moveNum++;
        }
    }
    protected void MoveForward(boolean tracking){
        pos[0] += dir[0];
        pos[1] += dir[1];

        if(tracking){
            path[moveNum] = 'F';
            moveNum++;
        }
    }

    //condense path down into factorized form
    protected String FactorizePath(String path){
        String factorizedPath = "";
        char recent = ' ';
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
                else factorizedPath += recent;
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
    protected String UnfactorizePath(String path){//turn 3L into R and 3R into L maybe
        return "uhuh";
    }

    public abstract boolean exploreMaze(Maze maze, int[] start, int[] finish);
}
