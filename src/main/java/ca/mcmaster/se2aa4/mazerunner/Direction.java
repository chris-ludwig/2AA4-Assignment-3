package ca.mcmaster.se2aa4.mazerunner;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public int[] toVector(){
        if(this == Direction.NORTH) return new int[] {-1, 0};
        else if(this == Direction.EAST) return new int[] {0, 1};
        else if(this == Direction.SOUTH) return new int[] {1, 0};
        else return new int[] {0, -1};
    }
    public static Direction fromVector(int[] vector){
        if(vector[0] == -1) return Direction.NORTH;
        else if(vector[1] == 1) return Direction.EAST;
        else if(vector[0] == 1) return Direction.SOUTH;
        else return Direction.WEST;
    }
}
