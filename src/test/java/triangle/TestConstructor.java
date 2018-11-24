package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Raik Yauheni on 24.11.2018.
 */
public class TestConstructor {
    private String messageTriangle;
    public String EXPECTED_MESSAGE_TRIANGLE = "";
    @DataProvider(name = "dP_Constructor")
    public Iterator<Object[]> testConstructor() {
        return Arrays.asList(new Object[][]                {
                        { new ArrayList<Double>(Arrays.asList(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE)) },
                        { new ArrayList<Double>(Arrays.asList(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)) },
                        { new ArrayList<Double>(Arrays.asList(Double.MIN_VALUE, Double.MIN_VALUE, Double.MAX_VALUE)) },
                        { new ArrayList<Double>(Arrays.asList(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE)) },
                        { new ArrayList<Double>(Arrays.asList(0.0, 0.0, 0.0)) },
                        { new ArrayList<Double>(Arrays.asList(-1.0, -1.0, -1.0)) },
                        { new ArrayList<Double>(Arrays.asList(1.0, 1.0, 1.0)) },
        }).iterator();
    }


    @Test(dataProvider = "dP_Constructor")
    public  void testTooBigParams (ArrayList<Double> sizes) {
        messageTriangle = new Triangle(sizes.get(0), sizes.get(1), sizes.get(2)).getMessage();
        Assert.assertTrue(messageTriangle.equals(EXPECTED_MESSAGE_TRIANGLE));

    }
}