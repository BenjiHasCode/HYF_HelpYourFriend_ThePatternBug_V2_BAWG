import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MazeInterpreter {
    public static Point[][] textToMaze(){
        try{
            Scanner input = new Scanner(new File("maze.txt"));
            //we scan horizontal
            int rows = Integer.parseInt(input.nextLine());
            int[][] horizontal = new int[rows][];
            for(int i = 0; i < rows; i++){
                int[] temp = stringToIntArray(input.nextLine().split(", "));
                System.arraycopy(temp, 1, horizontal[i] = new int[temp.length-1], 0, temp.length - 1);
                //                horizontal[i] = stringToIntArray(input.nextLine().split(", "));
            }

            //we scan vertical
            rows = Integer.parseInt(input.nextLine());
            int[][] vertical = new int[rows][];
            for(int i = 0; i < rows; i++){
                int[] temp = stringToIntArray(input.nextLine().split(", "));
                System.arraycopy(temp, 1, vertical[i] = new  int[temp.length-1], 0, temp.length - 1);
//                vertical[i] = stringToIntArray(input.nextLine().split(", "));
            }
            //TODO
            System.out.println(Arrays.deepToString(horizontal));
            System.out.println(Arrays.deepToString(vertical));

            //new point array
            Point[][] points = new Point[horizontal.length][vertical.length];

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
            System.out.println(Arrays.deepToString(points));
            System.out.println(points[0].length);
            System.out.println(points.length);

            System.out.println(vertical.length);
            System.out.println(vertical[0].length);
            //set vertical lines
            /*for(int i = 0; i < points.length; i++){
                for(int j = 0; j < points[0].length; j++){
                    if(vertical[i][j] == 1)
                        points[j][i].hasVertical = true;
                }
            }*/

            return points;
        }catch(FileNotFoundException e){
            System.out.println(e);
            return null;
        }

    }

    public static int[] stringToIntArray(String[] textArray){
        int[] intArray = new int[textArray.length];
        for(int i = 0; i < textArray.length; i++){
            intArray[i] = Integer.parseInt(textArray[i]);
        }
        return intArray;
    }
}
