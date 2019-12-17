import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * The test class EarthquakeTest.
 * Test getMagnitude() and getYear() Methods
 *
 * @author YANLIN GAO
 * @version 15/10/2019
 */
public class EarthquakeTest {
    Earthquake earthquake1;
    double[] position;

    /**
     * Sets up the test fixture.
     * <p>
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        earthquake1 = new Earthquake(7.0, 19.07, -72.24, 2010);
        position = new double[]{19.07, -72.24};
    }

    /**
     * Tears down the test fixture.
     * <p>
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }

    /**
     * Test the getMagnitude() method.
     *
     * @return the magnitude of the earthquake
     */
    @Test
    public void testGetMagnitudeMethod() {
        assertEquals(7.00, earthquake1.getMagnitude(), 0.01);
    }

    /**
     * Test the getYear method.
     *
     * @return the year the earthquake events happened
     */
    @Test
    public void testGetYearMethod() {
        assertEquals(2010, earthquake1.getYear());
    }
}

