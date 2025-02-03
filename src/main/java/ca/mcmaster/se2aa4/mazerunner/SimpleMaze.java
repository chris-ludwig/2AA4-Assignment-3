package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class SimpleMaze extends Maze {

        public SimpleMaze(String mazeFile){
            super(mazeFile);
        }
        @Override
        public int[] GetStart()
        {
            //returns opening on the west wall
            for (int i=0; i<maze.length; i++)
            {
                if(maze[i][0] != '#') {
                    int[] j = {i,0};
                    return j;
                }
            }
            return null;
        }
        @Override
        public int[] GetFinish(){
            //returns opening on the east wall
            for (int i=0; i<maze[0].length; i++)
            {
                if(maze[i][maze[i].length-1] != '#') {
                    int[] j = {i,maze[i].length-1};
                    return j;
                }
            }
            return null;
        }
    }
