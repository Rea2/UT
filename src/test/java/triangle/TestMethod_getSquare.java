package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.*;
/**
 * Created by Raik Yauheni on 23.11.2018.
 */
public class TestMethod_getSquare {
    @DataProvider(name = "dP_Squares")
    public Object[][] create() {
        return new Object[][]{
                {new double[]{0.5, 0.4, 0.3}, 0.06},
                {new double[]{0.4, 0.5, 0.3}, 0.06},
                {new double[]{0.4, 0.5, 0.3}, 0.06},
                {new double[]{3.0, 4.0, 5.0}, 6.0},
                {new double[]{4.0, 3.0, 5.0}, 6.0},
                {new double[]{4.0, 5, 3.0}, 6.0},
                {new double[]{3, 4, 5}, 6},
                {new double[]{4, 3, 5}, 6},
                {new double[]{4, 5, 3}, 6},
                {new double[]{3E76, 4E76, 5E76}, 6E152},
                {new double[]{4E76, 3E76, 5E76}, 6E152},
                {new double[]{4E76, 5E76, 3E76}, 6E152},
        };
    }
    /** positive test*/
    @Test(dataProvider = "dP_Squares", groups = "smoke")
    public  void testCalcSquarePositive(double[] sides , double expecrtedResult) {
        double actualResult =   new Triangle(sides[0], sides[1], sides[2]).getSquare();
        Assert.assertEquals(actualResult , expecrtedResult, "incorrect square's calculation");
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
     * - detection triangle is performed for incorrect parameters
     */
    @Test(dataProvider = "dP_IllegalTriangle", expectedExceptions = Exception.class, groups = "smoke")
    public void testProhibitionGetSquareIllegalTriangle(ArrayList<Double> sizes){
        new Triangle(sizes.get(0),sizes.get(1), sizes.get(2)).getSquare();
    }

    @DataProvider(name = "dP_lackDoublePrecision")
    public Iterator<Object[]> lackDoublePreciseness() {
        return Arrays.asList(new Object[][]
                {
                        { new ArrayList<Double>(Arrays.asList(1E1, 1E18, 1E18)) },
                        { new ArrayList<Double>(Arrays.asList(1E18, 1E18, 1E1)) },
                        { new ArrayList<Double>(Arrays.asList(1E18, 1E1, 1E18)) },
                        { new ArrayList<Double>(Arrays.asList(1E58, 1E75, 1E75)) },
                        { new ArrayList<Double>(Arrays.asList(1E75, 1E58, 1E75)) },
                        { new ArrayList<Double>(Arrays.asList(1E75, 1E75, 1E58)) },
                }).iterator();
    }
    /** negative test. Exception is expected, if:
     *   -  difference between two sizes of triangle is more than 1E17, because double has limited precision
     */
    @Test(dataProvider = "dP_lackDoublePrecision",expectedExceptions=Exception.class)
    public  void testTooBigParams (ArrayList<Double> sizes) {
        new Triangle(sizes.get(0),sizes.get(1), sizes.get(2)).getSquare();
    }

    @DataProvider(name = "dP_doubleOverflow")
    public Iterator<Object[]> doubleOverflow() {
        return Arrays.asList(new Object[][]
                {
                        { new ArrayList<Double>(Arrays.asList(3E77, 4E77, 5E77)) },
                        { new ArrayList<Double>(Arrays.asList(4E77, 5E77, 3E77)) },
                        { new ArrayList<Double>(Arrays.asList(5E77, 3E77, 4E77)) },
                }).iterator();
    }

    /** negative test (double overflow). Exception is expected, if:
     *   p(p-a)(p-b)(p-c) >= Double.MaxValue();
     */
    @Test(dataProvider = "dP_doubleOverflow",expectedExceptions=Exception.class)
    public  void testDoubleOverflow (ArrayList<Double> sizes) {
        new Triangle(sizes.get(0),sizes.get(1), sizes.get(2)).getSquare();
    }

}
