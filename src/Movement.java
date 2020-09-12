public class Movement {
    public static void move(Bug bug, Maze maze) {
            //walk right
            if (bug.getY() + 1 < maze.points.length && !maze.points[bug.getX()][bug.getY()+1].hasVertical && bug.getRoute().peek().getY() != bug.getY() + 1) {
                bug.getRoute().add(new Bug(bug.getX(), bug.getY()));
                bug.setY(bug.getY() + 1);
            }
            //walk up
            else if (bug.getX() + 1 < maze.points.length && !maze.points[bug.getX()+1][bug.getY()].hasHorizontal && bug.getRoute().peek().getX() != bug.getX() + 1) {
                bug.getRoute().add(new Bug(bug.getX(), bug.getY()));
                bug.setX(bug.getX()+1);
            }
            //walk left
            else if (bug.getY() - 1 >= 0 && !maze.points[bug.getX()][bug.getY()].hasVertical && bug.getRoute().peek().getY() != bug.getY() - 1) {
                bug.getRoute().add(new Bug(bug.getX(), bug.getY()));
                bug.setY(bug.getY()-1);
            }
            //walk down
            else if (bug.getX() - 1 >= 0 && !maze.points[bug.getX()][bug.getY()].hasHorizontal && bug.getRoute().peek().getX() != bug.getX() -1) {
                bug.getRoute().add(new Bug(bug.getX(), bug.getY()));
                bug.setX(bug.getX()-1);
            }
            //walk back
            else{
                int x = bug.getX();
                int y = bug.getY();
                Bug tempBug = bug.getRoute().peek();
                bug.setX(tempBug.getX());
                bug.setY(tempBug.getY());
                bug.getRoute().add(new Bug(x, y));
            }
    }
}