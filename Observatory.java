import java.util.ArrayList;
import java.util.Arrays;
import java.text.DecimalFormat;
/**
 * Record and retrieve the detail of observatory.
 * observatoryName, startYear, area, a list of earthquake
 * @author YANLIN GAO
 * @version 07/10/2019
 */
   public class Observatory
   {
    // Record the name of observatory;
    private String observatoryName;
    // Record the country where it located
    private String country;
    // Record the year the observations started;
    private int startYear;
    // Record the are coverd by the observatory(km^2)
    private double area;
    // Record the list of earthquake events that it has recorded.
    private ArrayList<Earthquake> earthquakes;
    
   /**
    * Constructor for objects of class Observatory
    */
    public Observatory(String name, String country, int year, double area,
    ArrayList<Earthquake> earthquakes)
    {
        this.observatoryName = name;
        this.startYear = year;
        this.country = country;
        this.area = area;
        this.earthquakes = earthquakes;
    }
   
   /**
    * Get name of observatory.
    * @return observatoryName(String)
    */
   public String getName()
   { 
    return observatoryName;
   }

   /**
    * Get construct year of observatory.
    * @return statrYear(int);
    */
   public int getStartYear()
   { 
    return startYear;
   }
   
   /**
    * Get the list of earthquke information recorded by this observatory
    * @return earthquakes(ArrayList)
    */
   public ArrayList getEarthquakeList(){
       return earthquakes;
    }
   /**
    *  Add an earthquke event to this observatory
    *  @param newEarthquake(Earthquake)
    */
   public void addEarthquakeRecord(Earthquake newEarthquake){
       earthquakes.add(newEarthquake);
   }
   
   /**
    * Get the earthquake with largestest magnitude recorded by the observatory.
    * @return maxMagnitudeEarthquake(Earthquke)
    */
   public Earthquake largestMagnitude()
   { 
     Earthquake maxMagnitudeEarthquake = new Earthquake(0, 0, 0, 0);
     // for each loop to pick up the earthquake with largest magnitude;
     for (Earthquake e : earthquakes) {
         if (e.getMagnitude() > maxMagnitudeEarthquake.getMagnitude()) {
             maxMagnitudeEarthquake = e;
         }
     }
     return maxMagnitudeEarthquake;
   }
   
   /**
    * The average of earthquake magnitude recorded by the observatory.
    * @return averageMagnitude(double, with two decimal places)  
    */
   public double averageMagnitude()
   { 
    double sumMagnitude = 0;
    double averageMagnitude = 0;
     //for each loop to sum up the maginitude
     for (Earthquake earthquake : earthquakes){
         sumMagnitude += earthquake.getMagnitude();
     }
    // calculate the average of magnitude
    //earthquake.size() to return the amount of earthquke recorded in list
    DecimalFormat df = new DecimalFormat("#.00");
    averageMagnitude = sumMagnitude / earthquakes.size();
    // keep the averageMagnitude in two decimal
    averageMagnitude = Double.parseDouble(df.format(averageMagnitude));
    return averageMagnitude;
   }
   
   /**
    * A list of all earthquakes recorded at the observatory with a magnitude greater than a given number.
    * year, maginitude, position[latitude, longitude],
    * @return resultEarthquake(ArrayList)
    */
   public ArrayList compareMagnitude(double comparedMagnitude)
   { 
       Earthquake earthquake;
       ArrayList<Earthquake> resultEarthquake = new ArrayList();
     for (int i = 0; i < earthquakes.size(); i++){
         earthquake = earthquakes.get(i);
         if (earthquake.getMagnitude() > comparedMagnitude){
             resultEarthquake.add(earthquakes.get(i));
            }
    }
    return resultEarthquake;
   }
}

