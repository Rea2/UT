package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Raik Yauheni on 23.11.2018.
 */
public class TestMethod_checkTriangle extends TestMethod {
    /** positive test*/
    @DataProvider(name = "dP_CorrectTriangle")
    public static Object[][] positiveData() {
        return new Object[][]{
                {new double[]{0.3, 0.3, 0.3}, true},
                {new double[]{3, 3, 3}, true},
                {new double[]{3, 4, 3}, true},
                {new double[]{3, 3, 4}, true},
                {new double[]{4, 3, 3}, true},
                {new double[]{3, 3, 4}, true},
                {new double[]{3, 4, 3}, true},
                {new double[]{4, 3, 3}, true},
                {new double[]{4, 5, 6}, true},
                {new double[]{5, 6, 4}, true},
                {new double[]{6, 4, 5}, true},
                {new double[]{Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE}, true},
                {new double[]{Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE}, true},
                {new double[]{1E1, 1E17, 1E17}, true},
                {new double[]{1E17, 1E17, 1E1}, true},
                {new double[]{1E17, 1E1, 1E17}, true},
                {new double[]{1E-1, 1E-1, 1E-17}, true},
                {new double[]{1E-17, 1E-1, 1E-1}, true},
                {new double[]{1E-1, 1E-17, 1E-1}, true},
        };
    }
    @Test(dataProvider = "dP_CorrectTriangle")
    public  void testCheckingParamsPositive(double[] sides , boolean isTriangle) {
        System.out.println(sides[0] + " " + sides[1]+ " " +sides[2]);
        Triangle triangle = new Triangle(sides[0], sides[1], sides[2]);
        Assert.assertEquals(triangle.checkTriangle(), isTriangle, "incorrect checking of the triangle.Positive test");
    }
    /** negative test*/
    @Test(dataProvider = "dP_IllegalTriangle", dataProviderClass = TestMethod.class)
    public  void testCheckingParamsNegative(double[] sides , boolean isTriangle) {
        System.out.println(sides[0] + " " + sides[1]+ " " +sides[2]);
        Triangle triangle = new Triangle(sides[0], sides[1], sides[2]);
        Assert.assertEquals(triangle.checkTriangle(), isTriangle, "incorrect checking of the triangle.Negative test");
    }

    /** negative test, prohibiting of using parameters with big
     *  difference between them, because double has limited precision.
     */
    @Test(expectedExceptions=Exception.class,
            dataProvider = "dP_lackDoublePreciseness")
    public  void testTooBigParams (ArrayList<Double> sizes) {
        new Triangle(sizes.get(0),sizes.get(1), sizes.get(2)).checkTriangle();
    }
}
