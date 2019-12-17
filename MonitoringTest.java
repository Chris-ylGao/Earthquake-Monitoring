import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MonitoringTest.
 *
 * @author  YANLIN GAO
 * @version 16/10/2019
 */
public class MonitoringTest
{
    Observatory observatory1;
    Observatory observatory2;
    Observatory observatory3;
    ArrayList<Observatory> observatories;
    
    
    ArrayList<Earthquake> earthquakes1;
    ArrayList<Earthquake> earthquakes2;
    ArrayList<Earthquake> earthquakes3;
    
    Monitoring monitor;
    /**
     * Default constructor for test class MonitoringTest
     */
    public MonitoringTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        earthquakes1 = new ArrayList();
        earthquakes2 = new ArrayList();
        earthquakes3 = new ArrayList();
        
        earthquakes1.add(new Earthquake(7.0, 19.07, -72.24, 2010));
        earthquakes1.add(new Earthquake(9.2, -1.4, 115.42, 2004));
        earthquakes1.add(new Earthquake(7.9, 39.55, 116.23, 2008));
        observatory1 = new Observatory("Willy Bob", "Antigua and Barbuda",
        2015, 1000, earthquakes1);//average magnitude = 8.03;
        
        earthquakes2.add(new Earthquake(7.6, 33.41, 73.03, 2005)); 
        earthquakes2.add(new Earthquake(6.6, 35.41, 51.25, 2003)); 
        earthquakes2.add(new Earthquake(9.1, 35.41, 139.46, 2001));
        observatory2 = new Observatory("Gun Hill", "Barbados", 2010, 1500, earthquakes2);
        //average magnitude = 7.77;
        
        earthquakes3.add(new Earthquake(7.7, 28.36, 77.72, 2001));
        earthquakes3.add(new Earthquake(7.8, 28.10, 84.15, 2015));
        earthquakes3.add(new Earthquake(6.4, 28.10, 84.15, 2018));
        observatory3= new Observatory("Isla Barro Colorado", "Panama", 2012, 1200, earthquakes3);
        //average magnitude = 7.27;
        
        observatories = new ArrayList();
        observatories.add(observatory1);
        observatories.add(observatory2);
        observatories.add(observatory3);
        
        monitor = new Monitoring(observatories);
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
     * test getObservatories Method
     * which is to return the name and average magnitude of observatories with largest 
     * average magnitude.
     */
    @Test
    public void testGetObservatoriesMethod(){
    String expectedResult = "Willy Bob,8.03";
    assertEquals(expectedResult, monitor.getObservatories());
    }
    
    /**
     *  test maxMagnitudeEarthquake method;
     *  which is to return the the laegest earthquake.
     */
    @Test
    public void testMaxMagnitudeEarthquakeMethod(){
      assertEquals(earthquakes1.get(1), monitor.maxMagnitudeEarthquake());  
    }
    
    /**
     * test compareMagnitude() method
     * which is to retrun the list of earthquake whose magnitude greater than
     * input number.
     */
    @Test
    public void testCompareMagnitudeMethod(){
        double[] inputNumber = {6, 6.5, 7, 10};
          for (double num : inputNumber){
            ArrayList<Earthquake> expectedEarthquake = new ArrayList();
            for (Observatory observatory : observatories){
                ArrayList<Earthquake> temp = new ArrayList();
                temp = observatory.compareMagnitude(num);
                for (Earthquake t : temp){
                    expectedEarthquake.add(t);
                }
            }
            assertEquals(expectedEarthquake, monitor.compareMagnitude(num));
          }
          
        }
    }
