import java.util.ArrayList;
import java.util.Arrays;
/**
 * Load test data;
 * The details of earthquakes and the information of observatories;
 *
 * @author YANLIN GAO 
 * @version 22/10/2019
 */
public class LoadData
{
    Observatory observatory1;
    Observatory observatory2;
    Observatory observatory3;
    ArrayList<Observatory> observatories;
    
    
    ArrayList<Earthquake> earthquakes1;
    ArrayList<Earthquake> earthquakes2;
    ArrayList<Earthquake> earthquakes3;

    /**
     * Constructor for objects of class LoadData
     */
    public LoadData()
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
        
    }
    public ArrayList<Observatory> start(){
        return observatories;
        }
}
