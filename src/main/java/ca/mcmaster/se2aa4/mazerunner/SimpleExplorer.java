package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public  class SimpleExplorer extends Explorer {
        @Override
        public boolean exploreMaze(Maze maze, int[] start, int[] finish){
            return false;
        }
    }
