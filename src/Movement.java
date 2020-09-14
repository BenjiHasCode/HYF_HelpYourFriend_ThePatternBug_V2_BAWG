//High Cohesion. Denne kunne sagtens være i Bug klassen, men personligt mente jeg at
//bug ville få for mange ansvar. Derfor lavede jeg metoden/ansvaret her for at bevare High Cohesion

public class Movement {
    /**
     * Moves the bug (changing it's coordinates), while checking if the moves are possible.
     * Ensures the bug doesn't move through walls
     * @param bug an instance that contains x and y coordinatese
     */
    public static void move(Bug bug) {
         Maze maze = Maze.getInstance();
        //walk right
        if (bug.getY() + 1 < maze.points.length && !maze.points[bug.getX()][bug.getY()+1].hasVertical && bug.getRoute().peek().getY() != bug.getY() + 1) {
            bug.getRoute().add(new Coordinate(bug.getX(), bug.getY()));
            bug.setY(bug.getY() + 1);
        }
        //walk up
        else if (bug.getX() + 1 < maze.points.length && !maze.points[bug.getX()+1][bug.getY()].hasHorizontal && bug.getRoute().peek().getX() != bug.getX() + 1) {
            bug.getRoute().add(new Coordinate(bug.getX(), bug.getY()));
            bug.setX(bug.getX()+1);
        }
        //walk left
        else if (bug.getY() - 1 >= 0 && !maze.points[bug.getX()][bug.getY()].hasVertical && bug.getRoute().peek().getY() != bug.getY() - 1) {
            bug.getRoute().add(new Coordinate(bug.getX(), bug.getY()));
            bug.setY(bug.getY()-1);
        }
        //walk down
        else if (bug.getX() - 1 >= 0 && !maze.points[bug.getX()][bug.getY()].hasHorizontal && bug.getRoute().peek().getX() != bug.getX() -1) {
            bug.getRoute().add(new Coordinate(bug.getX(), bug.getY()));
            bug.setX(bug.getX()-1);
        }
        //walk back
        else{
            Coordinate coordinate = new Coordinate(bug.getX(), bug.getY());
            //we peek at route and make our bug go back
            bug.setX(bug.getRoute().peek().getX());
            bug.setY(bug.getRoute().peek().getY());
            //we add the bugs previous coordinates to route
            bug.getRoute().add(coordinate);
        }
    }
}