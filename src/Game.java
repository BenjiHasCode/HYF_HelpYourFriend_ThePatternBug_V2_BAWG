import java.time.Duration;
import java.time.Instant;

public class Game {
    public static void start() {
        int steps = 1; //TODO VAR SAT TIL 0, MEN VAR EN UNDER HVAD DEN BURDE. CHECK UP!
        long time;

        Maze maze = new Maze();
        Bug bug = MazeInterpreter.findEntrance(maze);
        bug.getRoute().add(new Bug(bug.getX(), bug.getY()));
        Bug goal = MazeInterpreter.findExit(maze);

        System.out.println(maze.printMaze(bug));
        time = System.currentTimeMillis();

        boolean flag = true;

        while(flag){
            Movement.move(bug, maze);
            steps++; //TODO Step virker til at være en mindre end den burde! D:
            System.out.println(maze.printMaze(bug));

            if ((bug.getY() == goal.getY() && bug.getX() == goal.getX())){
                flag = false;
            }
        }
        long timeEnd = System.currentTimeMillis();

        System.out.println("It took: " + steps + " steps, and: " + (timeEnd - time) + " milliseconds");
    }
}
