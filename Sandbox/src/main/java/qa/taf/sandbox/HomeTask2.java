package qa.taf.sandbox;
import qa.taf.sandbox.Point;

/**
 * Created by rushman on 5/15/17.
 */
public class HomeTask2 {
    public static void main(String[]args){
        Point p1 = new Point(1,2);
        Point p2 = new Point(3,7);
     System.out.println("Distance between p1 and p2 is " + distance(p1,p2) + " Function inside Main class"); // Function

        System.out.println("Distance between p1 and p2 is "+ p1.distanceTo(p2)+" instance method of Point class (used 'this' in Point class)");
        System.out.println("Distance between p1 and p2 is "+ Point.distance(p1,p2)+" Static call Method of Point class ");
    }
    public static  double distance(Point p1, Point p2){
        return Math.sqrt(Math.pow((p1.x - p2.x),2) + Math.pow((p1.y - p2.y),2));
    }
}
