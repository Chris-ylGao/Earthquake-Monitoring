import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hold the information about all observatories.
 *
 * @author YANLIN GAO
 * @version 08/10/2019
 */
public class Monitoring {
    // An ArrayList that stores all information of observatories
    private ArrayList<Observatory> observatories;


    public Monitoring(ArrayList<Observatory> inputObservatories) {
        this.observatories = inputObservatories;
    }

    /**
     * Calclute the average earthquake magnitude of each observatory and compare them;
     * Return the name and average earthquake magnitude of observatory with largest average magnitude;
     *
     * @return name(String), magnitude(double, has two demical places)
     */
    public String getObservatories() {
        String name = "";
        double maxAverageMagnitude = 0;
        for (Observatory observatory : observatories) {
            if (observatory.averageMagnitude() > maxAverageMagnitude) {
                name = observatory.getName();
                maxAverageMagnitude = observatory.averageMagnitude();
            }
        }
        return name + "," + Double.toString(maxAverageMagnitude);
    }

    /**
     * Get the earthquake with largest magnitude ever recorded.
     *
     * @return maxMagnitudeEarthquake(Earthquke)
     */
    public Earthquake maxMagnitudeEarthquake() {
        Earthquake maxMagnitudeEarthquake = new Earthquake(0, 0, 0, 0);
        for (Observatory observatory : observatories) {
            if (maxMagnitudeEarthquake.getMagnitude() < observatory.largestMagnitude().getMagnitude()) {
                maxMagnitudeEarthquake = observatory.largestMagnitude();
            }
        }
        return maxMagnitudeEarthquake;
    }

    /**
     * Print a list of earthquakes' details recorded at the observatory with magnitude greater than a given number.
     */
    public ArrayList<Earthquake> compareMagnitude(double number) {
        ArrayList<Earthquake> result = new ArrayList();
        for (Observatory observatory : observatories) {
            ArrayList<Earthquake> tems = new ArrayList();
            tems = observatory.compareMagnitude(number);
            for (Earthquake tem : tems) {
                result.add(tem);
            }
        }
        return result;
    }


}
