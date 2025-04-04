package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Maze {//defines basic functionalities needed for all mazes
        protected char maze[][];
        private static final Logger logger = LogManager.getLogger();

        //loads maze from file to 2d array
        public void LoadMaze(String mazeFile)
        {
            try{
                //resizing array to match the file
                BufferedReader reader = new BufferedReader(new FileReader(mazeFile)); 
                int lines = 0, length = reader.readLine().length();

                while (reader.readLine() != null) lines++;
                maze = new char[lines+1][length];

                reader.close();
                reader = new BufferedReader(new FileReader(mazeFile));

                String line;

                for (int i=0; i<maze.length; i++)
                {
                    line = reader.readLine();
                    for (int j = 0; j < line.length(); j++) {
                        if (line.charAt(j) == '#') {
                            maze[i][j] = '#';
                        } else if (line.charAt(j) == ' ') {
                            maze[i][j] = ' ';
                        } else if (line.charAt(j) == '\n') {//empty line, fill with spaces
                            for(int k = j; k < line.length(); k++){
                                maze[i][k] = ' ';
                            }
                            j=line.length();//break the loop
                        }
                        else{
                            System.out.println("Unexpected Character in Maze File");
                            System.exit(-1);
                        }
                    }
                }
                PrintMaze();//move this to view
                reader.close();
            }catch(IOException e){
                logger.error("Error reading maze file");
            }
        }
        private void PrintMaze(){
            for(int i=0; i<maze.length; i++){
                for (int j=0; j<maze[i].length; j++){
                    System.out.print(maze[i][j]);
                }
                System.out.println("\n");
            }
        }
        
        char[][] GetMaze(){
            return maze;
        }

        //returns start and finsh of each maze
        abstract int[] GetStart();

        abstract int[] GetFinish();
    }
