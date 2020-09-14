/**Contains booleans to determine if they have a horizontal and/or vertical line
 * Vertical lines are assumed to be on the left side of the point
 */
public class Point {
    boolean hasHorizontal;
    boolean hasVertical;

    public Point(){
        hasHorizontal = false;
        hasVertical = false;
    }

    public String toString(){
        if (!hasHorizontal && !hasVertical)
            return "   ";
        else if(hasHorizontal && hasVertical)
            return "|__";
        else if (hasVertical)
            return "|  ";
        else
            return "___";
    }
}
