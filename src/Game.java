public class Game {
    /**
     * This methods starts the "game". It initializes all that is necessary and calculates results when the "game" is done.
     */
    public static void start() {
        //note: bug starts in entrance square meaning it doesn't need to already enter maze
        //because of this, steps will always be - 1, than if it had to enter it.
        //that said, one could make it enter
        int steps = 0;

        Maze maze = Maze.getInstance();
        Bug bug = MazeInterpreter.findEntrance();
        Coordinate goal = MazeInterpreter.findExit();

        //Draw maze
        System.out.println(maze.printMaze(bug));
        //start timer
        long timeStart = System.currentTimeMillis();

        while(!(bug.getY() == goal.getY() && bug.getX() == goal.getX())){
            Movement.move(bug);
            steps++;
            System.out.println(maze.printMaze(bug));
        }

        long timeEnd = System.currentTimeMillis();
        System.out.println("It took: " + steps + " steps, and: " + (timeEnd - timeStart) + " milliseconds");
    }
}
