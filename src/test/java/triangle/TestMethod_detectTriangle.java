package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.*;

/**
 * Created by Raik Yauheni on 23.11.2018.
 */
public class TestMethod_detectTriangle {

    @DataProvider(name = "dP_CorrectTriangle")
    public static Object[][] positiveData() {
        return new Object[][]{
        /** Equilateral triangle    */
                {new double[]{0.3, 0.3, 0.3}, 3},
                {new double[]{3, 3, 3}, 3},
                {new double[]{1E153, 1E153, 1E153}, 3},
        /** Isosceles triangle    */
                {new double[]{3, 4, 3}, 2},
                {new double[]{3, 3, 4}, 2},
                {new double[]{4, 3, 3}, 2},
        /** Rectangle triangle    */
                {new double[]{3, 4, 5}, 8},
                {new double[]{4, 5, 3}, 8},
                {new double[]{5, 3, 4}, 8},
        /** Rectangle & isosceles  triangle    */
                {new double[]{3.0, 3.0, (Math.sqrt(2)*3)}, 10},
                {new double[]{3.0, (Math.sqrt(2)*3.0), 3.0}, 10},
                {new double[]{ (Math.sqrt(2)*3.0),3.0,3.0}, 10},
        /** Ordinary  triangle integer   */
                {new double[]{4, 5, 6}, 4},
                {new double[]{5, 6, 4}, 4},
                {new double[]{6, 4, 5}, 4},
        /** Ordinary  triangle double   */
                {new double[]{0.5, 0.6, 0.4}, 4},
                {new double[]{0.6, 0.4, 0.5}, 4},
                {new double[]{0.4, 0.5, 0.6}, 4},
        };
    }
    /** positive test*/
    @Test (dataProvider = "dP_CorrectTriangle", groups="smoke")
    public void testDetectingType(double[] sides , int result){
        Assert.assertEquals(new Triangle(sides[0], sides[1], sides[2]).detectTriangle(), result,
                "Incorrect detecting triangle");
    }

    @DataProvider(name = "dP_IllegalTriangle")
    public Iterator<Object[]> dataIllegalTriangle() {
        return Arrays.asList(new Object[][]                {
                        /** negative parameter */
                        { new ArrayList<Double>(Arrays.asList(-1.0, 1.0, 1.0)) },
                        { new ArrayList<Double>(Arrays.asList(1.0, -1.0, 1.0)) },
                        { new ArrayList<Double>(Arrays.asList(1.0, 1.0, -1.0)) },
                        { new ArrayList<Double>(Arrays.asList(1.0, -1.0, -1.0)) },
                        /** side equals zero */
                        { new ArrayList<Double>(Arrays.asList(0.0, 1.1, 1.2)) },
                        { new ArrayList<Double>(Arrays.asList(1.2, 0.0, 1.1)) },
                        { new ArrayList<Double>(Arrays.asList(1.1, 1.2, 0.0)) },
                        { new ArrayList<Double>(Arrays.asList(0.0, 0.0, 0.0)) },
                        /** sides equal zero and negative number */
                        { new ArrayList<Double>(Arrays.asList(-1.0, 1.0, 0.0)) },
                        { new ArrayList<Double>(Arrays.asList(-1.1, -1.2, -1.3)) },
                        /** the sum of the two sides is less than the third one */
                        { new ArrayList<Double>(Arrays.asList(1.0, 2.0, 4.0)) },
                        { new ArrayList<Double>(Arrays.asList(2.0, 4.0, 1.0)) },
                        { new ArrayList<Double>(Arrays.asList(4.0, 1.0, 2.0)) },
                      }).iterator();
    }
    /** negative test. Exception is expected, if:
     * - detection triangle is performed  for incorrect parameters
     */
    @Test(dataProvider = "dP_IllegalTriangle", expectedExceptions = Exception.class,
          groups="smoke")
    public void testProhibitionDetectIllegalTriangle(ArrayList<Double> sizes){
        new Triangle(sizes.get(0),sizes.get(1), sizes.get(2)).detectTriangle();
    }

    @DataProvider(name = "dP_lackDoublePrecision")
    public Iterator<Object[]> lackDoublePreciseness() {
        return Arrays.asList(new Object[][]
                {
                        { new ArrayList<Double>(Arrays.asList(1E1, 1E18, 1E18)) },
                        { new ArrayList<Double>(Arrays.asList(1E18, 1E18, 1E1)) },
                        { new ArrayList<Double>(Arrays.asList(1E18, 1E1, 1E18)) },
                        { new ArrayList<Double>(Arrays.asList(1E100, 1E117, 1E117)) },
                        { new ArrayList<Double>(Arrays.asList(1E117, 1E100, 1E117)) },
                        { new ArrayList<Double>(Arrays.asList(1E117, 1E117, 1E100)) },
                }).iterator();
    }
    /** negative test. Exception is expected, if:
     *   -  difference between two sizes of triangle is more than 1E17, because double has limited precision
     */
    @Test(expectedExceptions=Exception.class,
            dataProvider = "dP_lackDoublePrecision")
    public  void testTooBigParams (ArrayList<Double> sizes) {
        new Triangle(sizes.get(0),sizes.get(1), sizes.get(2)).detectTriangle();
    }

    @DataProvider(name = "dP_doubleOverflow")
    public Iterator<Object[]> doubleOverflow() {
        return Arrays.asList(new Object[][]
                {
                        /**      c * c >= Double.MaxValue()   */
                        { new ArrayList<Double>(Arrays.asList(1.01*Math.sqrt(Double.MAX_VALUE),
                                0.51*Math.sqrt(Double.MAX_VALUE),0.51*Math.sqrt(Double.MAX_VALUE) )) },
                        { new ArrayList<Double>(Arrays.asList(0.51*Math.sqrt(Double.MAX_VALUE),
                                0.51*Math.sqrt(Double.MAX_VALUE),1.01*Math.sqrt(Double.MAX_VALUE) )) },
                        { new ArrayList<Double>(Arrays.asList(0.51*Math.sqrt(Double.MAX_VALUE),
                                1.01*Math.sqrt(Double.MAX_VALUE),0.51*Math.sqrt(Double.MAX_VALUE) )) },

                        /**      a*a +b*b >= Double.MaxValue()   */
                        { new ArrayList<Double>(Arrays.asList(Math.sqrt(0.51*Double.MAX_VALUE),
                                Math.sqrt(0.51*Double.MAX_VALUE), Math.sqrt(0.52*Double.MAX_VALUE) )) },
                        { new ArrayList<Double>(Arrays.asList(Math.sqrt(0.51*Double.MAX_VALUE),
                                Math.sqrt(0.52*Double.MAX_VALUE), Math.sqrt(0.51*Double.MAX_VALUE) )) },
                        { new ArrayList<Double>(Arrays.asList(Math.sqrt(0.52*Double.MAX_VALUE),
                                Math.sqrt(0.51*Double.MAX_VALUE), Math.sqrt(0.51*Double.MAX_VALUE) )) },
                }).iterator();
    }
    /** negative test (double overflow). Exception is expected, if:
     *  -  c * c >= Double.MaxValue();
     *   - a*a +b*b >= Double.MaxValue();
     *    where c - the longest size of the triangle, a, b - other sizes of the triangle
     */
    @Test(dataProvider = "dP_doubleOverflow",expectedExceptions=Exception.class)
    public  void testDoubleOverflow (ArrayList<Double> sizes) {
        new Triangle(sizes.get(0),sizes.get(1), sizes.get(2)).detectTriangle();
    }

}


