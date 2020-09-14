/**This class contains an array of points and a static reference to an object of the class.
 * Singleton. A bug can only physically traverse one maze at a time.
 */
public class Maze {
    Point[][] points;
    static Maze maze;


    private Maze (){
        points = MazeInterpreter.textToMaze();
    }

    /**
     * @return instance of maze. If one exists then return, else it creates a new maze and returns the new instance.
     */
    public static Maze getInstance(){
        if(maze == null)
            return new Maze();
        else
            return maze;
    }

    /**
     * Draws maze containing bug
     * @param bug needs bug to know its position, and where to draw it
     * @return String representation of maze
     * Because console input is written from top to bottom, this method starts drawing from the last index instead of index 0 of the array
     */
    public String printMaze(Bug bug){
        String maze = "";
        for (int i = points.length - 1; i >= 0; i--){
            for (int j = 0; j < points[0].length; j++){
                if (!points[i][j].hasHorizontal && !points[i][j].hasVertical && bug.getX() == i && bug.getY() == j)
                    maze += " o ";
                else if(points[i][j].hasHorizontal && points[i][j].hasVertical && bug.getX() == i && bug.getY() == j)
                    maze += "|o_";
                else if (points[i][j].hasVertical && bug.getX() == i && bug.getY() == j)
                    maze += "|o ";
                else if (points[i][j].hasHorizontal && bug.getX() == i && bug.getY() == j)
                    maze += "_o_";
                else
                    maze += points[i][j].toString();
            }
            maze += "\n";
        }
        return maze;
    }
}
