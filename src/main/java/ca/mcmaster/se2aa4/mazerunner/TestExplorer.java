package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class TestExplorer extends Explorer {
        @Override
        public boolean exploreMaze(Maze maze, int[] start, int[] finish) {
            // Call the main method with a default path
            return exploreMaze(maze, start, finish, null);
        }
        public boolean exploreMaze(Maze maze, int[] start, int finish[], String path)
        {
            //initialize instructions and explorer
            path = UnfactorizePath(path);
            pos = start;
            int[] east = {0,1}, west = {0,-1}, north = {-1, 0}, south = {1,0};

            //initialize directions
            if(pos[1] == 0) dir = east;
            else if (pos[1] == maze.GetMaze()[0].length-1) dir = west;
            else if (pos[0] == 0) dir = south;
            else dir = north;

            //iterate through instructions and execute
            for (int i=0; i<path.length(); i++){
                if (path.charAt(i) == 'R') TurnRight(false);
                else if(path.charAt(i) == 'L') TurnLeft(false);
                else if(path.charAt(i) == 'F'){
                    MoveForward(false);
                    if(pos[1] < 0 || pos[1] >= maze.GetMaze()[0].length) return false;// exited the bounds of the maze(add checking for north and south)
                }
                else return false;//invalid instruction

                if (maze.GetMaze()[pos[0]][pos[1]] == '#') return false;//ran into wall
            }
            return checkWin(finish);
        }
    }
