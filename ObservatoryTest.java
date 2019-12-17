import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Collection;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * The test class ObservatoryTest.
 *
 * @author  YANLIN GAO
 * @version 15/08/2019
 */
public class ObservatoryTest
{
    Observatory observatory1;
    ArrayList<Earthquake> earthquakes;
    double inputNumber;
    
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        
        earthquakes = new ArrayList();
        earthquakes.add(new Earthquake(7.0, 19.07, -72.24, 2010));
        earthquakes.add(new Earthquake(9.2, -1.4, 115.42, 2004));
        earthquakes.add(new Earthquake(7.9, 39.55, 116.23, 2008));
        observatory1 = new Observatory("Willy Bob", "Antigua and Barbuda",
        2015, 1000, earthquakes);
        
        
    }
    
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    /**
     * Test the getName() Method.
     * which is to return the name of observatory1
     */
    @Test
    public void testGetNameMethod(){
        assertEquals("Willy Bob", observatory1.getName());
    }
    
    /**
     * Test the getYearMethod.
     * which is to return the lauch year observatory1
     */
    @Test
    public void testGetYearMethod(){
        assertEquals(2015, observatory1.getStartYear());
    }
    
    /**
     * Test the largestManitude() Method.
     * which is to return largest earthquake magnitude recorded in observatory1;
     */
    @Test
    public void testLargestMagnitudeMethod(){
        assertEquals(earthquakes.get(1), observatory1.largestMagnitude());
    }
    
    /**
     * Test the averageMagnitude() method.
     * which is to return average of earthquake magnitude recorded in observatory1;
     */
    @Test
    public void testAverageMagnitudeMethod(){
        assertEquals(8.03, observatory1.averageMagnitude(), 0.01);
    }
    
    /**
     * Test the getEarthqukeList() method.
     * which is to return earthquke list that recorded by observatory1.
     */
    @Test
    public void testGetEarthquakeListMethod(){
        assertEquals(earthquakes, observatory1.getEarthquakeList());
    }
    
    /**
     * Test the compareMagnitude() method.
     * which is to return average of earthquake magnitude recorded in observatory1;
     * @param compare to number -1, 0, 7, 7.5, 8, 10.
     */
    @Test
    public void testCompareMagnitudeMethod(){
       assertEquals(earthquakes, observatory1.compareMagnitude(-1));
       assertEquals(earthquakes, observatory1.compareMagnitude(0));
       ArrayList<Earthquake> result = new ArrayList();
       result.add(earthquakes.get(1));
       result.add(earthquakes.get(2));
       assertEquals(result, observatory1.compareMagnitude(7));
       assertEquals(result, observatory1.compareMagnitude(7.5));
       ArrayList<Earthquake> result1 = new ArrayList();
       result1.add(earthquakes.get(1));
       assertEquals(result1,observatory1.compareMagnitude(8));
       ArrayList<Earthquake> result2 = new ArrayList();
       assertEquals(result2,observatory1.compareMagnitude(10));
    }
}
