package qa.taf.sanbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.taf.sandbox.Point;


/**
 * Created by rushman on 5/15/17.
 */
public class PointDistanceTest {
    @Test
    public void testPositiveValue(){
        Point p1 = new Point(1,2);
        Point p2 = new Point(3,7);
        Assert.assertNotNull(p1.distanceTo(p2));
    }

    @Test
    public void testDistanceValue(){
        Point p1 = new Point(4,3);
        Point p2 = new Point(1,3);
        Assert.assertEquals(p1.distanceTo(p2),3.0);

    }
}
