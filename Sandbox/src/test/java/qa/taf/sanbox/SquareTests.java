package qa.taf.sanbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.taf.sandbox.Square;

/**
 * Created by rushman on 5/15/17.
 */
public class SquareTests {
    @Test
    public void testArea(){
        Square s = new Square(5);
        Assert.assertEquals(s.area(),25.0);
    }

}