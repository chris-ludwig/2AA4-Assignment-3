package ca.mcmaster.se2aa4.mazerunner;

public  class SimpleExplorer extends Explorer{
        private String data;
        private String mazeString;
        @Override
        public void exploreMaze(Maze maze){
            mazeString = maze.GetMazeString();
            pos = maze.GetStart();

            //initialize directions, make avaialable for north and south too
            if(pos[1] == 0) dir = Direction.EAST;
            else dir = Direction.WEST;

            while(!exitFound){
                if(dir.toVector()[0] == 0){//facing east or west
                    //if you can turn right, turn right and move forward
                    if(maze.GetMaze()[pos[0] + dir.toVector()[1]][pos[1]] != '#'){
                        TurnRight(true);
                        MoveForward(true);
                    }//if you can move forward do so
                    else if(maze.GetMaze()[pos[0]][pos[1] + dir.toVector()[1]] != '#'){
                        MoveForward(true);

                    }//turn left and move forward
                    else if(maze.GetMaze()[pos[0]-dir.toVector()[1]][pos[1]] != '#'){
                        TurnLeft(true);
                        MoveForward(true);
                    }
                    else{//deadend, turnaround
                        TurnLeft(true);
                        TurnLeft(true);
                    }
                }
                else{//facing north or south
                    //if you can turn right, turn right and move forward
                    if(maze.GetMaze()[pos[0]][pos[1] - dir.toVector()[0]] != '#'){
                        TurnRight(true);
                        MoveForward(true);
                    }//if you can move forward do so
                    else if(maze.GetMaze()[pos[0] + dir.toVector()[0]][pos[1]] != '#'){
                        MoveForward(true);
                    }//turn left and move forward
                    else if(maze.GetMaze()[pos[0]][pos[1] + dir.toVector()[0]] != '#'){
                        TurnLeft(true);
                        MoveForward(true);
                    }
                    else{//deadend, turn around
                        TurnLeft(true);
                        TurnLeft(true);
                    }
                }
                checkWin(maze.GetFinish());
                if(pos[0] == maze.GetStart()[0] && pos[1] == maze.GetStart()[1]) break;//went in loop, maze is impossible
            }
        }

        public ModelResult getData(){
            return new MazeResult(FactorizePath(path), mazeString);
        }
    }
