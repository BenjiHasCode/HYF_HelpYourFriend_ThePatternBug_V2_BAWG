//singleton?? vi vil kun have én maze

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
        return maze;
    }

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
                else {
                    maze += points[i][j].toString();
                }
            }
            maze += "\n";
        }
        return maze;
    }
}
