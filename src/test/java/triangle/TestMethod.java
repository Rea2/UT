package triangle;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Raik Yauheni on 24.11.2018.
 *
 * This is main class for testing class Triangle. It is provided common DataProviders and methods.
 * Testing specific  methods of the class Triangle are performed from specific classes-children.
 */
public class TestMethod {
    @DataProvider(name = "dP_IllegalTriangle")
    public Object[][] illegalTriangle() {
        return new Object[][]{
                {new double[]{-1, 1, 1}, false},
                {new double[]{1, -1, 1}, false},
                {new double[]{-1, 1, -1}, false},
                {new double[]{1, -1, -1}, false},
                {new double[]{0, 1, 1}, false},
                {new double[]{1, 0, 1}, false},
                {new double[]{1, 1, 0}, false},
                {new double[]{-1, 1, 0}, false},
                {new double[]{1, 2, 4}, false},
                {new double[]{4, 1, 2}, false},
                {new double[]{2, 4, 1}, false},
        };
    }

    @DataProvider(name = "dP_lackDoublePreciseness")
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
}
