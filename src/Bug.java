import java.util.Stack;

/**
 * An object of this class contains coordinates, and a stack that represents the route that the bug takes.
 */
public class Bug extends Coordinate {
    private Stack<Coordinate> route;

    public Bug(int x, int y){
        super(x, y);
        route = new Stack<>();
        route.add(new Coordinate(x,y)); //adds our current position to route (start point)
    }

    public Stack<Coordinate> getRoute() {
        return route;
    }

    public void setRoute(Stack<Coordinate> route) {
        this.route = route;
    }
}
