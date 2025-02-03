package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public abstract class Maze {
        private char maze[][];

        public Maze(String mazeFile){
            FileReader reader = new FileReader(mazeFile);
            this.maze = LoadMaze(reader);
        }
        //loads maze from file to 2d array
        private char[][] LoadMaze(FileReader reader){
            return maze;
        }
        
        char[][] GetMaze(){
            return maze;
        }
        //checks if path is valid solution to maze
        boolean IsValidPath(String path){
            return false;
        }

        //returns start and finsh of each maze
        abstract int[] GetStart();

        abstract int[] GetFinish();
    }
