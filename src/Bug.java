import java.util.Stack;

public class Bug {
    private int x;
    private int y;
    private Stack<Bug> route;

    public Bug(int x, int y){
        this.x = x;
        this.y = y;
        route = new Stack<>();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Stack<Bug> getRoute() {
        return route;
    }

    public void setRoute(Stack<Bug> route) {
        this.route = route;
    }
}
