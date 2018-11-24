package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.*;

/**
 * Created by Raik Yauheni on 23.11.2018.
 */
public class TestMethod_detectTriangle extends TestMethod {

    @DataProvider(name = "dP_CorrectTriangle")
    public static Object[][] positiveData() {
        return new Object[][]{
        /**
         *  {{a,b,c} d} a, b, c - sizes of triangles, d- expecting result;
         *  17 tests
         * Equilateral triangle    */
                {new double[]{0.3, 0.3, 0.3}, 3},
                {new double[]{3, 3, 3}, 3},
        /** Isosceles triangle    */
                {new double[]{3, 4, 3}, 2},
                {new double[]{3, 3, 4}, 2},
                {new double[]{4, 3, 3}, 2},
        /** Rectangle triangle    */
                {new double[]{3, 4, 5}, 8},
                {new double[]{4, 5, 3}, 8},
                {new double[]{5, 3, 4}, 8},
        /** Rectangle & isosceles  triangle    */
                {new double[]{3, 3, Math.sqrt(2)*3}, 10},
                {new double[]{3, Math.sqrt(2)*3, 3}, 10},
                {new double[]{ Math.sqrt(2)*3,3,3}, 10},
        /** Ordinary  triangle integer   */
                {new double[]{4, 5, 6}, 4},
                {new double[]{5, 6, 4}, 4},
                {new double[]{6, 4, 5}, 4},
        /** Ordinary  triangle double   */
                {new double[]{0,5, 0.6, 0.4}, 4},
                {new double[]{0,6, 0.4, 0.5}, 4},
                {new double[]{0,4, 0.5, 0.6}, 4},
        };
    }
    @Test (dataProvider = "dP_CorrectTriangle")
    public void testDetectingType(double[] sides , int result){
        Assert.assertEquals(new Triangle(sides[0], sides[1], sides[2]).detectTriangle(), result,
                "Incorrect detecting triangle");
    }

    @Test(dataProvider = "dP_IllegalTriangle", expectedExceptions = Exception.class)
    public void testProhibitionDetectTriangleIfItDoesntExist(double[] sides, boolean results){
        Triangle triangle = new Triangle(sides[0], sides[1], sides[2]);
        triangle.detectTriangle();
    }
    /** negative test, prohibiting of using parameters with big
     *  difference between them, because double has limited precision.
     */
    @Test(expectedExceptions=Exception.class,
            dataProvider = "dP_lackDoublePreciseness")
    public  void testTooBigParams (ArrayList<Double> sizes) {
        new Triangle(sizes.get(0),sizes.get(1), sizes.get(2)).detectTriangle();
    }
}


