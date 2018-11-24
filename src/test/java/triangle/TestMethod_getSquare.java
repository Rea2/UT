package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.*;

/**
 * Created by Raik Yauheni on 23.11.2018.
 */
public class TestMethod_getSquare extends TestMethod {

    @DataProvider(name = "dP_Squares")
    public Object[][] create() {
        return new Object[][]{
                {new double[]{0.5, 0.4, 0.3}, 0.06},
                {new double[]{0.4, 0.5, 0.3}, 0.06},
                {new double[]{0.4, 0.5, 0.3}, 0.06},
                {new double[]{3, 4, 5}, 6},
                {new double[]{4, 3, 5}, 6},
                {new double[]{4, 5, 3}, 6},
        };
    }
    @Test(dataProvider = "dP_Squares")
    public  void testCalcSquarePositive(double[] sides , double expecrtedResult) {
        String squareText = String.format(Locale.US,"%.6f",
                new Triangle(sides[0], sides[1], sides[2]).getSquare());
        double actualResult = Double.valueOf(squareText);
        Assert.assertEquals(actualResult , expecrtedResult, "incorrect square's calculation");
    }

    @Test(dataProvider = "dP_IllegalTriangle", expectedExceptions = Exception.class)
    public void testProhibitionDetectTriangleIfItDoesntExist(double[] sides, boolean isResult){
        Triangle triangle = new Triangle(sides[0], sides[1], sides[2]);
        triangle.getSquare();
    }

    /** negative test, prohibiting of using parameters with big
     *  difference between them, because double has limited precision.
     */
    @Test(expectedExceptions=Exception.class,
            dataProvider = "dP_lackDoublePreciseness")
    public  void testTooBigParams (ArrayList<Double> sizes) {
        new Triangle(sizes.get(0),sizes.get(1), sizes.get(2)).getSquare();
    }


//    @DataProvider(name = "dP_DoubleOverFlow")
//    public Iterator<Object[]> doubeOverFlow() {
//        return Arrays.asList(new Object[][]
//                {
//                        { new ArrayList<Double>(Arrays.asList(Math.sqrt(Double.MAX_VALUE),Math.sqrt(Double.MAX_VALUE), 1.0)) },
////                        { new ArrayList<Double>(Arrays.asList(-1.0, 1.0, 1.0)) },
////                        { new ArrayList<Double>(Arrays.asList(-1.0, 1.0, 1.0)) },
////                        { new ArrayList<Double>(Arrays.asList(-1.0, 1.0, 1.0)) },
////                        { new ArrayList<Double>(Arrays.asList(-1.0, 1.0, 1.0)) },
////                        { new ArrayList<Double>(Arrays.asList(-1.0, 1.0, 1.0)) },
////                        { new ArrayList<Double>(Arrays.asList(-1.0, 1.0, 1.0)) },
//
//
//                }).iterator();
//    }
//
//    @Test(dataProvider = "dP_DoubleOverFlow")
//    public void testDoubleOverFlow(List<Double> sizes){
//        String errorMessage = "parameter(s) is(are) too big";
//        Collections.sort(sizes);
//        Assert.assertTrue(sizes.get(2)*sizes.get(2) < Double.MAX_VALUE, errorMessage);
//        Assert.assertTrue(sizes.get(1)*sizes.get(1) < Double.MAX_VALUE - sizes.get(0)*sizes.get(0), errorMessage);
//    }


}
