package qa.taf.sanbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.taf.sandbox.Primes;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rushman on 6/10/17.
 */
public class PrimeTests {

    @Test(enabled = false)
    public void testPrimes(){
        Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
    }

    @Test(enabled = false)
    public void testNonPrimes(){
        Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
    }

    @Test(enabled = false)
    public void testPrimeLong(){
        long n = Integer.MAX_VALUE;
        Assert.assertTrue(Primes.isPrime(n));
    }
    @Test
    public void testTime (){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        String x = dateFormat.format(date);
        String y = "2016";
        Assert.assertTrue(x.contains(y));
    }
}
