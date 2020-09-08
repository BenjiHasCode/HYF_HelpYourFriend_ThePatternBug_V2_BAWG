public class Maze {
    Point[][] points;

    public Maze (){
        points = MazeInterpreter.textToMaze();
    }

    public String toString(){
        String maze = "";
        for (int i = points.length - 1; i >= 0; i--){
            for (int j = 0; j < points[0].length; j++){
                maze += points[i][j].toString();
            }
            maze += "\n";
        }
       /* for (int i = 0; i < points.length; i++){
            for (int j = 0; j < points[0].length; j++){
                maze += points[i][j].toString();
            }
            maze += "\n";
        }*/
        return maze;
    }
}
