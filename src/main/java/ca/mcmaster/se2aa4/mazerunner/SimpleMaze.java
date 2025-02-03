package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class SimpleMaze extends Maze {
        private char maze[][];

        public SimpleMaze(String mazeFile){
            super(mazeFile);
        }
        @Override
        public int[] GetStart(){
            int a[] = {1};
            return a;
        }
        @Override
        public int[] GetFinish(){
            int a[] = {1};
            return a;
        }
    }
