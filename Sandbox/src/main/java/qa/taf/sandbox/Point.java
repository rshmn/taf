package qa.taf.sandbox;

/**
 * Created by rushman on 5/15/17.
 */
public class Point {
    public double x;
    public double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double distanceTo(Point newpoint){
        return Math.sqrt(Math.pow((this.x - newpoint.x),2) + Math.pow((this.y - newpoint.y),2));
    }

    public static double  distance(Point onepoint, Point otherpoint) {
        return Math.sqrt(Math.pow((onepoint.x - otherpoint.x),2) + Math.pow((onepoint.y - otherpoint.y),2));
    }
}
