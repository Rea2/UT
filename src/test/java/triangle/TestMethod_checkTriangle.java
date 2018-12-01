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
public class TestMethod_checkTriangle {
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
            {new double[]{1E1, 1E17, 1E17}, true},
            {new double[]{1E17, 1E17, 1E1}, true},
            {new double[]{1E17, 1E1, 1E17}, true},
            {new double[]{1E-1, 1E-1, 1E-17}, true},
            {new double[]{1E-17, 1E-1, 1E-1}, true},
            {new double[]{1E-1, 1E-17, 1E-1}, true},
            {new double[]{8E291, 8E307, 8E307}, true},
            {new double[]{8E307, 8E291, 8E307}, true},
            {new double[]{8E307, 8E307, 8E291}, true}
        };
    }
    /** positive test*/
    @Test(dataProvider = "dP_CorrectTriangle", groups="smoke")
    public  void testCheckingParamsPositive(double[] sides , boolean isTriangle) {
        Triangle triangle = new Triangle(sides[0], sides[1], sides[2]);
        Assert.assertEquals(triangle.checkTriangle(), isTriangle, "incorrect checking of the triangle.Positive test");
    }
    /** negative test. Exception is expected?, if:
     *   -  at least one size of triangle isn't positive number, the test throws exception
     *   -  the sum of the two sides is less than the third one
     */
    @DataProvider(name = "dP_IllegalTriangle")
    public Object[][] illegalTriangle() {
        return new Object[][]{
            /** negative parameter */
            {new double[]{-1, 1, 1}, false},
            {new double[]{1, -1, 1}, false},
            {new double[]{-1, 1, -1}, false},
            {new double[]{1, -1, -1}, false},
            /** one of sides equals zero */
            {new double[]{0, 1, 1}, false},
            {new double[]{1, 0, 1}, false},
            {new double[]{1, 1, 0}, false},
            {new double[]{-1, 1, 0}, false},
            /** the sum of the two sides is less than the third one */
            {new double[]{1, 2, 4}, false},
            {new double[]{4, 1, 2}, false},
            {new double[]{2, 4, 1}, false},
        };
    }
    @Test(dataProvider = "dP_IllegalTriangle", groups="smoke")
    public  void testCheckingParamsNegative(double[] sides , boolean isTriangle) {
        Triangle triangle = new Triangle(sides[0], sides[1], sides[2]);
        Assert.assertEquals(triangle.checkTriangle(), isTriangle, "incorrect checking of the triangle.Negative test");
    }
    /** negative test. Exception is expected, if:
     *   -  difference between two sizes of triangle is more than 1E18, because double has limited precision
     */
    @DataProvider(name = "dP_lackDoublePrecision")
    public Iterator<Object[]> lackDoublePreciseness() {
        return Arrays.asList(new Object[][]
            {
                { new ArrayList<Double>(Arrays.asList(1E1, 1E18, 1E18)) },
                { new ArrayList<Double>(Arrays.asList(1E18, 1E18, 1E1)) },
                { new ArrayList<Double>(Arrays.asList(1E18, 1E1, 1E18)) },
                { new ArrayList<Double>(Arrays.asList(1E1, 1E1, 1E18)) },
                { new ArrayList<Double>(Arrays.asList(1E18, 1E1, 1E1)) },
                { new ArrayList<Double>(Arrays.asList(1E1, 1E18, 1E11)) },
            }).iterator();
    }
    /** negative test. Exception is expected, if:
     *   -  difference between two sizes of triangle is more than 1E17, because double has limited precision
     */
    @Test(dataProvider = "dP_lackDoublePrecision", expectedExceptions=Exception.class )
    public  void testTooBigParams (ArrayList<Double> sizes) {
        new Triangle(sizes.get(0),sizes.get(1), sizes.get(2)).checkTriangle();
    }

    @DataProvider(name = "dP_doubleOverflow")
    public Iterator<Object[]> doubleOverflow() {
        return Arrays.asList(new Object[][]
            {
                    { new ArrayList<Double>(Arrays.asList(0.55*Double.MAX_VALUE,  0.62*Double.MAX_VALUE, 0.7*Double.MAX_VALUE)) },
                    { new ArrayList<Double>(Arrays.asList(0.7*Double.MAX_VALUE,  0.55*Double.MAX_VALUE, 0.6*Double.MAX_VALUE)) },
                    { new ArrayList<Double>(Arrays.asList(0.6*Double.MAX_VALUE,  0.7*Double.MAX_VALUE, 0.55*Double.MAX_VALUE)) },
            }).iterator();
    }

    /** negative test (double overflow). Exception is expected, if:
     *   -  sum of two size is more or than Double.MaxValue();
     */
    @Test(dataProvider = "dP_doubleOverflow",expectedExceptions=Exception.class)
        public  void testDoubleOverflow (ArrayList<Double> sizes) {
            new Triangle(sizes.get(0),sizes.get(1), sizes.get(2)).checkTriangle();
    }



}
