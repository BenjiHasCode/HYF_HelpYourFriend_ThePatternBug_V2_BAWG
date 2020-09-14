import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * This Class is Pure fabrication. A class was needed to interpret data and convert it into usable data for our maze.
 * The class can make a maze based on the data format that ASBC provided, and can find entrance/exit to said maze.
 */
public class MazeInterpreter {
    /**
     * reads data and converts horizontal and vertical data to data usable by maze object.
     * @return A two-dimensional array of Points representing a maze.
     */
    public static Point[][] textToMaze(){
        try{
            Scanner input = new Scanner(new File("maze.txt"));
            int rows = Integer.parseInt(input.nextLine());
            int[][] horizontal = new int[rows][];
            //we scan the horizontal lines and add them to our array
            for(int i = 0; i < rows; i++){
                int[] temp = StringToIntArray.convert(input.nextLine().split(", "));
                //first place contains row number, thus we start copying from index 1
                System.arraycopy(temp, 1, horizontal[i] = new int[temp.length-1], 0, temp.length - 1);
            }

            //we scan vertical
            rows = Integer.parseInt(input.nextLine());
            int[][] vertical = new int[rows][];
            for(int i = 0; i < rows; i++){
                int[] temp = StringToIntArray.convert(input.nextLine().split(", "));
                System.arraycopy(temp, 1, vertical[i] = new  int[temp.length-1], 0, temp.length - 1);
            }

            //new point array
            Point[][] points = new Point[horizontal.length][vertical.length];
            //initialize all points
            for(int i = 0; i < points.length; i++){
                for(int j = 0; j < points[0].length; j++){
                    points[i][j] = new Point();
                }
            }
            //set horizontal lines
            for(int i = 0; i < horizontal.length; i++){
                for(int j = 0; j < horizontal[i].length; j++){
                    if(horizontal[i][j] == 1)
                        points[i][j].hasHorizontal = true;
                }
            }
            //set vertical lines
            for(int i = 0; i < vertical.length; i++){
                for(int j = 0; j < vertical[i].length; j++){
                    if(vertical[i][j] == 1)
                        points[j][i].hasVertical = true;
                }
            }
            return points;
        }catch(FileNotFoundException e){
            System.out.println("File Not Found!");
            return null;
        }
    }

    /**
     * Finds the entrance to our maze
     * @return bug containing the position of entrance.
     */
    public static Bug findEntrance(){
        Maze maze = Maze.getInstance();
        for(int y = 0; y < maze.points[0].length; y++){
            if(!maze.points[0][y].hasHorizontal){
                return new Bug (0, y);
            }
        }
        return null;
    }

    /**
     * Finds exit to maze (assuming the exit to be on the top of the maze)
     * @return Coordinate object containing the exits coordinates.
     */
    public static Coordinate findExit(){
        Maze maze = Maze.getInstance();
        for (int i = maze.points.length - 1; i >= 0; i--){
            for (int j = 0; j < maze.points[0].length; j++) {
                if (!maze.points[i][j].hasHorizontal)
                    return new Coordinate(i, j);
            }
        }
        return null;
    }
}