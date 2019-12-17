/**
 * Class that records and retrieve the detail of earthquake.
 * magnitude-double-(0,10)
 * position{latitude,longitude}-double[]-(-180, 180)
 * year-int-(0,currentYear)
 *
 * @author YANLIN GAO
 * @version 07/10/2019
 */

import java.util.Arrays;

public class Earthquake {
    // Stotre the magnitude of earthquake
    private double magnitude;
    // Record position where earthquake take place
    // position [latitude, longitude]
    private double[] position;
    private double latitude;
    private double longitude;
    // Record the year of earthquake
    private int year;

    /**
     * Constructor: get values from parameters; 
     */
    public Earthquake(double magnitude, double latitude, double longitude, int year) {
        this.magnitude = magnitude;
        this.latitude = latitude;
        this.longitude = longitude;
        this.year = year;
        this.position = new double[2];
    }

    /**
     * Get position[2]
     * Tranfer the value of latitude and longitude to position array.
     * [latitude, longitude]
     * @return position(Arrays)
     */
    public double[] getPosition() {
        this.position[0] = latitude;
        this.position[1] = longitude;
        return position;
    }


    /**
     * Get magitude.
     * @return magnitude(double)
     */
    public double getMagnitude() {
        return magnitude;
    }

    /**
     * Get year.
     * @return year(int)
     */
    public int getYear() {
        return year;
    }

    /**
     *  Override toString() Method to show the information of Earthquake;
     *  Restrict year in four digits;
     *  If the length of year < 4, then adding 0 in the front.
     *  Using String.format() method to keep two dicimal places for magnitude, latitude, longitude
     */
    public String toString() {
        String y = Integer.toString(year);
        if (y.length() < 4) {
            for (int i = 0; i < 4 - y.length(); i++) {
                y = "0" + y;
            }
        }
        String strDouble = String.format("%.2f", 2.00023);
        return y + "  " + String.format("%.2f", magnitude) + "  [" + String.format("%.2f", latitude)
                + "," + String.format("%.2f", longitude) + "]";
    }
}
