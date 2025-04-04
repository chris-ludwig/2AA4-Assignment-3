package ca.mcmaster.se2aa4.mazerunner;

public class TestExplorer extends Explorer {
        @Override
        public void exploreMaze(Maze maze, int[] start, int[] finish) {
            // Call the main method with a default path
            exploreMaze(maze, start, finish, null);
        }
        public void exploreMaze(Maze maze, int[] start, int finish[], String path)
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
                    if(pos[1] < 0 || pos[1] >= maze.GetMaze()[0].length || pos[0] < 0 || pos[0] >= maze.GetMaze().length) break;// exited the bounds of the maze
                }
                else break;//invalid instruction

                if (maze.GetMaze()[pos[0]][pos[1]] == '#') break;//ran into wall
            }
            checkWin(finish);
        }
        public ModelResult getData(){
            return new TestResult(exitFound);
        }
    }
