import java.time.Duration;
import java.time.Instant;

public class Game {
    public static void start() throws InterruptedException {
        int steps = 0;
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
            steps++;
            System.out.println(maze.printMaze(bug));

            if ((bug.getY() == goal.getY() && bug.getX() == goal.getX())){
                flag = false;
            }
           // Thread.sleep(1000);
        }
        long timeEnd = System.currentTimeMillis();

        System.out.println("It took: " + steps + " steps, and: " + (timeEnd - time) + " milliseconds");
    }
}
