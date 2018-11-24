
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import java.util.*;

/**
 * Created by Raik Yauheni on 23.11.2018.
 */

public class Test {
}
//        double a = 3, b = 3;
//        double c = 3*Math.sqrt(2);
//        System.out.println( ((a*a+b*b == c*c)));
//        System.out.println(a*a+b*b +  " "  + c*c);
//
////        System.out.println(Double.MAX_VALUE * 0.8 + Double.MAX_VALUE * 0.21 );
////        System.out.println(Double.MAX_VALUE * 0.6 + Double.MAX_VALUE * 0.6 );
////        System.out.println(Double.MAX_VALUE );
//
//        System.out.println((Double.MAX_VALUE/2) + Double.MAX_VALUE/2);
//        System.out.println((Double.MAX_VALUE/2+Double.MIN_VALUE) + Double.MAX_VALUE/2);
//        System.out.println(((Double.MAX_VALUE/2)+1) + Double.MAX_VALUE/2);
//        System.out.println(1e-308 * 10);
//
//
//        System.out.println(Double.MAX_VALUE);
//        System.out.println(Double.MAX_VALUE + 1e291 == Double.MAX_VALUE);
//
//        System.out.println(Double.MAX_VALUE + 1e292 == Double.MAX_VALUE);
//        System.out.println(Double.MAX_VALUE/1.797e291);
//        System.out.println(Double.MAX_VALUE/1.797e292);
//
//        System.out.println(1E17+1E16 > 1E17);
//        System.out.println(1E16+1E17 > 1E2);
//        System.out.println(1E12+1E17 > 1E16);
//        System.out.println(1E17/1E1 );
//



//        @DataProvider(name = "dP_IllegalTriangle")
//        public Object[][] illegalTriangle() {
//            return new Object[][]{
////        return Arrays.asList(new Object[][]
////                {
////                        { new ArrayList<Double>(Arrays.asList(-1.0, 1.0, 1.0)) },
////                        { new ArrayList<Double>(Arrays.asList(1.0, -1.0, 1.0)) },
////                        { new ArrayList<Double>(Arrays.asList(1.0, 1.0, -1.0)) },
////                        { new ArrayList<Double>(Arrays.asList(-1.0, -1.0, -1.0)) },
////                        { new ArrayList<Double>(Arrays.asList( 0.0, 1.0, 1.0)) },
////                        { new ArrayList<Double>(Arrays.asList(1.0, 0.0, 1.0)) },
////                        { new ArrayList<Double>(Arrays.asList(1.0, 1.0, 0.0)) },
////                        { new ArrayList<Double>(Arrays.asList(1.0, 2.0, 3.0)) },
////                        { new ArrayList<Double>(Arrays.asList(2.0, 3.0, 1.0)) },
////                        { new ArrayList<Double>(Arrays.asList(3.0, 1.0, 2.0)) },
////                        { new ArrayList<Double>(Arrays.asList(1.0, 2.0, 4.0)) },
////                        { new ArrayList<Double>(Arrays.asList(2.0, 4.0, 1.0)) },
////                        { new ArrayList<Double>(Arrays.asList(4.0, 2.0, 2.0)) },
//
//                    {new double[]{-1, 1, 1}, false},
//                    {new double[]{1, -1, 1}, false},
//                    {new double[]{-1, 1, -1}, false},
//                    {new double[]{1, -1, -1}, false},
//                    {new double[]{0, 1, 1}, false},
//                    {new double[]{1, 0, 1}, false},
//                    {new double[]{1, 1, 0}, false},
//                    {new double[]{-1, 1, 0}, false},
//                    {new double[]{1, 1, 3}, false},
//                    {new double[]{1, 3, 1}, false},
//                    {new double[]{4, 1, 2}, false},
//            };
//        }
//










//    /** negative test, double's overflow */
//    @DataProvider(name = "dP_DoubleOverFlow")
//    public Iterator<Object[]> doubeOverFlow() {
//        return Arrays.asList(new Object[][]
//                {
//                        { new ArrayList<Double>(Arrays.asList((1.1*Math.sqrt(Double.MAX_VALUE)),
//                                (0.7*Math.sqrt(Double.MAX_VALUE)), (0.6*Math.sqrt(Double.MAX_VALUE)))) },
//                        { new ArrayList<Double>(Arrays.asList((0.7*Math.sqrt(Double.MAX_VALUE)),
//                                (0.6*Math.sqrt(Double.MAX_VALUE)), (1.1*Math.sqrt(Double.MAX_VALUE)))) },
//                        { new ArrayList<Double>(Arrays.asList((0.6*Math.sqrt(Double.MAX_VALUE)),
//                                (1.1*Math.sqrt(Double.MAX_VALUE)), (0.7*Math.sqrt(Double.MAX_VALUE)))) },
//
//                        { new ArrayList<Double>(Arrays.asList((0.61*Math.sqrt(Double.MAX_VALUE)),
//                                (0.61*Math.sqrt(Double.MAX_VALUE)), (0.9*Math.sqrt(Double.MAX_VALUE)))) },
//                        { new ArrayList<Double>(Arrays.asList((0.81*Math.sqrt(Double.MAX_VALUE)),
//                                (0.9*Math.sqrt(Double.MAX_VALUE)), (0.61*Math.sqrt(Double.MAX_VALUE)))) },
//                        { new ArrayList<Double>(Arrays.asList((0.9*Math.sqrt(Double.MAX_VALUE)),
//                                (0.61*Math.sqrt(Double.MAX_VALUE)), (0.81*Math.sqrt(Double.MAX_VALUE)))) },
//
//
//
//
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
//    @org.testng.annotations.Test(dataProvider = "dP_DoubleOverFlow", expectedExceptions = Exception.class)
//    public void testDoubleOverFlow(List<Double> sizes){
//        String errorMessage = "Parameter(s) is(are) too big";
//        Collections.sort(sizes);
//        System.out.println(sizes.get(0));
//        System.out.println(sizes.get(1));
//        System.out.println(sizes.get(2));
//        new Triangle(sizes.get(0),sizes.get(1), sizes.get(2)).detectTriangle();
//        Assert.assertTrue(sizes.get(2)*sizes.get(2) < Double.MAX_VALUE, errorMessage);
//        Assert.assertTrue(sizes.get(1)*sizes.get(1) < Double.MAX_VALUE - sizes.get(0)*sizes.get(0), errorMessage);
//    }


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