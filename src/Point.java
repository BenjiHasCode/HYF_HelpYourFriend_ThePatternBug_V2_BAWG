public class Point {
    boolean hasHorizontal;
    boolean hasVertical;

    public Point(){
        hasHorizontal = false;
        hasVertical = false;
    }

    /*public Point(boolean hasHorizontal, boolean hasVertical){
        this.hasHorizontal = hasHorizontal;
        this.hasVertical = hasVertical;
    }*/

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
