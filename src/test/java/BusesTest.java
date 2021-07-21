import org.junit.Assert;
import org.junit.Test;

public class BusesTest {

    @Test
    public void checkRouteCreated(){

        Assert.assertTrue("File exists",(new Route().busStops.length>0));
    }
}
