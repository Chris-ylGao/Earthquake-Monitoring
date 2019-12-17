import java.util.Scanner;
import java.lang.*;
import java.util.*;

/**
 * Create a user menu which can add detail of earthquake and observatory
 * and monitor statistic(earthquke with largest magnitude, observatory with largest average magnitude,
 * the list of earthquake with magnitude greater than given number)
 *
 * @author YANLIN GAO
 * @version 09/10/2019
 */
public class MonitoringIO {
    //An ArralyList to record details of earthquake that clients input
    private static ArrayList<Earthquake> inputEarthquake;
    //An ArralyList to record details of observatory that clients input
    private static ArrayList<Observatory> inputObservatory;
    //Creat a new class to store test data;
    protected static LoadData testData;
    // i is use to record index of ArrayList
    private static int i;

    public MonitoringIO() {
        inputEarthquake = new ArrayList();
        inputObservatory = new ArrayList<Observatory>();
        // Loading the test data
        testData = new LoadData();
        inputObservatory = testData.start();
        i = 0;
    }

    /**
     * Create a menu so that user can choose features by entering number.
     * 1.Enter observatory data;
     * 2.Enter earthquake data;
     * 3.Monitor earthquake;
     * 4.exit;
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MonitoringIO moniterIO = new MonitoringIO();
        // end indicates the end of of program;
        // If end is true, then exit;
        // if end is false, using while loop returns user to the menu afer executing one of the features.
        boolean end = false;
        while (end == false) {
            System.out.println("############MENU############");
            System.out.println("##1.Enter observatory data##");
            System.out.println("##2.Enter earthquake data ##");
            System.out.println("##3.Monitor earthquakes   ##");
            System.out.println("##4.Exit                  ##");
            System.out.println("############################");
            System.out.println("\n");
            System.out.println("Please select one of the above options:");
            String choice = input.nextLine();
            // Using switch case to execute different methods
            switch (choice) {
                case "1":
                    System.out.println("#####Input the detail of Observatory#####");
                    addObservatory();
                    System.out.println("########################################");
                    System.out.println("\n");
                    break;
                case "2":
                    System.out.println("#####Input the detail of earthquake#####");
                    addEarthquake();
                    System.out.println("########################################");
                    System.out.println("\n");
                    break;
                case "3":
                    monitor();
                    System.out.println("########################################");
                    System.out.println("\n");
                    break;
                case "4":
                    System.out.println("#####Exit the Earthquake Monitoring#####");
                    System.exit(0);
                    end = true;
                    break;
                default:
                    // If client input something else than "1,2,3,4", then this warnning message displays.
                    System.out.println("Input Error!Please select number '1,2,3,4'");
            }
        }
    }

    /**
     * Method to instruct user to input details of earthquake.
     * throw IllegalArgumentException if input is out of scale
     *
     * @return newEarthquake(Earthquake)
     */
    public static Earthquake inputEarthquake() {
        Scanner in = new Scanner(System.in);
        // Get magnitude of earthquake;
        System.out.println("Please input magnitude");
        double magnitude = 0;
        String s = "";
        //Restrict the input magnitude;
        //if clients input a string other than a number
        //or if they inputs magnitude out of scale [1,10]
        //then specified warning information would display.
        //the while loop keeps client inputting until they input in right foramt;
        while (true) {
            try {
                s = in.nextLine();
                magnitude = Double.parseDouble(s);
                if (magnitude < 1 || magnitude > 10) {
                    throw new IllegalArgumentException("Magnitude wrong");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("'" + s + "' is a bad input, please input the magnitude of earthquke");
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println(magnitude + " is a wrong input.");
                System.out.println("Magnitude must within [1, 10].");
                System.out.println("Please check the magnitude and enter again");
                continue;
            }
        }
        // Get position earthquake happened;
        System.out.println("Please input the position coordinate(latitude, longitude)");
        Scanner in1 = new Scanner(System.in);
        String positions = "";
        String[] position = new String[2];
        double latitude = 0;
        double longitude = 0;
        // Restric the input position coordinate;
        // if the clients input in wronbg format
        // or if they input latitude or longitude out of sale
        // then specified warning information display.
        // clients would keep inputting until thay input correctly;
        while (true) {
            try {
                positions = in1.nextLine();
                // Split String connected by ',' and stored them separatly in array named position;
                if (positions.contains(",") == false) {
                    throw new IllegalArgumentException("Position format wrong");
                } else {
                    position = positions.split(",");
                    latitude = Double.parseDouble(position[0]);
                    longitude = Double.parseDouble(position[1]);
                }
                if (latitude < -180 || latitude > 180 || longitude < -180 || longitude > 180) {
                    throw new ArithmeticException("Position wrong");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(positions + " is wrong input");
                System.out.println("position coordinate must be input by (latitude, longitude)");
                System.out.println("Pleace check the position coordinate and enter again.");
                continue;
            } catch (ArithmeticException e) {
                System.out.println(Arrays.toString(position) + " is wrong input");
                System.out.println("Both latitude and logitude should be in the scale [-180, 180].");
                System.out.println("Pleace check the coordinate enter again.");
                continue;
            }
        }
        // Get year the earthquake happened; 
        // Year should be a number, and shoulud be between the year the observatory construction and current year;
        // if clients input something wrong, then specifed warning woubld display.
        System.out.println("Please input the year of the event");
        Calendar now = Calendar.getInstance();
        int nowYear = now.get(Calendar.YEAR);
        int year = 0;
        while (true) {
            try {
                Scanner in2 = new Scanner(System.in);
                year = in2.nextInt();
                if (year > nowYear || year < inputObservatory.get(i).getStartYear()) {
                    throw new IllegalArgumentException("Year wrong");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(year + " is a incorrect input.");
                System.out.println("Observatory " + inputObservatory.get(i).getName() + " was construted in "
                        + inputObservatory.get(i).getStartYear() + ".");
                System.out.println("So year should be in the scale of [" + inputObservatory.get(i).getStartYear()
                        + ", " + nowYear + "].");
                System.out.println("Pleace check the year.");
                continue;
            } catch (Exception e) {
                System.out.println("Wrong input, please check and enter again.");
                continue;
            }
        }
        Earthquake newEarthquake = new Earthquake(magnitude, latitude, longitude, year);
        return newEarthquake;
    }

    /**
     * Add earthquake event to a observatory that has already recorded in the list.
     */
    public static void addEarthquake() {
        Scanner in = new Scanner(System.in);
        // Input the observatory that observaed this earthquake;
        System.out.println("Please input the name of observatory that you want to add earthquake record.");
        String search = in.nextLine();
        boolean end = false;
        Earthquake newE = new Earthquake(0, 0, 0, 0);
        try {
            // Check whether the observatory exsist or not;
            // If so,  adding the detail of earthquake;
            // If not, print the warning and retun to menu.
            while (i < inputObservatory.size()) {
                if (inputObservatory.get(i).getName().equals(search)) {
                    newE = inputEarthquake();
                    break;
                } else {
                    i += 1;
                }
            }
            if (i == inputObservatory.size()) {
                System.out.println("The observatory \"" + search + "\" doesn't in the list.");
                System.out.println("Please record the observatory first.");
                throw new IllegalArgumentException("Observatory not exsist");
            }
            // Check if the earthquke has already been recorded
            // If so, print the warning message
            // If not, record the new eatthquke event
            int j = 0;
            boolean find = false;
            while (j < inputObservatory.size()) {
                int m = 0;
                while (m < inputObservatory.get(j).getEarthquakeList().size()) {
                    if (newE.toString().equals(inputObservatory.get(j).getEarthquakeList().get(m).toString())) {
                        System.out.println("Earthquake \"" + newE.toString() + "\" has already recorded by Observatory "
                                + inputObservatory.get(j).getName() + ".");
                        System.out.println("Please check the detail!");
                        throw new IllegalArgumentException("Earthquake has alreakdy exisisted");
                    } else {
                        m += 1;
                    }
                }
                if (m == inputObservatory.get(j).getEarthquakeList().size()) {
                    m = 0;
                    j += 1;
                }
            }
            if (find == false) {
                inputObservatory.get(i).addEarthquakeRecord(newE);
                System.out.println("Congradulation!You've input the details of an earthquake event successfully!");
            }
        } catch (IllegalArgumentException e) {
            // catch IllegalArgumentException
        } finally {
        }
    }

    /**
     * Method to instruct user to input detail of observatory
     * and add this record to inputObservatory ArrayList
     */
    public static void addObservatory() {
        Scanner in = new Scanner(System.in);
        // Get the name of observatory
        System.out.println("Please input observatory's name");
        String name = in.nextLine();
        String country = "";
        int startYear = 0;
        double area = 0;
        ArrayList<Earthquake> addEarthquakes = new ArrayList<Earthquake>();
        int i = 0;
        //Determine whether the observatoey has already exisited in the list;
        //If so, display warning information and return to main menu;
        try {
            while (i < inputObservatory.size()) {
                if (inputObservatory.get(i).getName().equals(name)) {
                    System.out.println("The Observatory '" + name + "' has already exsisted.");
                    System.out.println("Please add the earthquake event directly.");
                    throw new IllegalArgumentException("observatory exists");
                } else {
                    i += 1;
                }
            }

            // Get the country that observatory located;
            System.out.println("Please input the country the observatory located");
            country = in.nextLine();
            //Get the construted year of observatory;
            // Year should be a number and shouldn't greater than curerent year.
            // Clients keeps inputting until they input somrthing right.
            while (true) {
                try {
                    System.out.println("Please input the start year of observatory");
                    Scanner in1 = new Scanner(System.in);
                    startYear = in1.nextInt();
                    Calendar now = Calendar.getInstance();
                    int nowYear = now.get(Calendar.YEAR);
                    if (startYear > nowYear || startYear <= 0) {
                        throw new IllegalArgumentException("Year wrong");
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Wrong input! The start year of observatory shoubld be a number.");
                    System.out.println("Please check and enter again.");
                    continue;
                }
            }
            // Get the covered area of observatory;
            //
            while (true) {
                try {
                    Scanner in2 = new Scanner(System.in);
                    System.out.println("Please input the area covered by the observatory(Unit: km^2)");
                    area = in2.nextDouble();
                    break;
                } catch (Exception e) {
                    System.out.println("Wrong input, please check and enter again");
                    continue;
                }
            }
            String select = "";

            boolean endSelect = false;
            while (endSelect == false) {
                System.out.println("Woulid you like to add the detail of events recorded at the observatory? Y/N");
                Scanner selectIn = new Scanner(System.in);
                select = selectIn.nextLine();
                if (select.equals("Y")) {
                    addEarthquakes.add(inputEarthquake());
                } else if (select.equals("N")) {
                    endSelect = true;
                }
            }// end while loop if choosing 'N'
            inputObservatory.add(new Observatory(name, country, startYear, area, addEarthquakes));
            System.out.println("You've input the information of " +
                    inputObservatory.get(inputObservatory.size() - 1).getName() + " successfully!");
        } catch (IllegalArgumentException e) {
        } finally {
        }
    }

    /**
     * Method to monitor static:
     * the largest average earthquake ever recorded and the name of the observatory
     * the largest that has recorded ever;
     * the list of earthquake with magnitude greater than given number
     */
    public static void monitor() {
        Scanner in = new Scanner(System.in);
        Monitoring monitor = new Monitoring(inputObservatory);
        System.out.println("Please input the numeber you want to be compared");
        double givenNumber = in.nextDouble();
        //Get the largest average earthquake magnitude and the name of observatory;
        String[] maxAverage = monitor.getObservatories().split(",");
        String name = maxAverage[0];
        double maxAverageMagnitude = Double.parseDouble(maxAverage[1]);
        System.out.println(">> The largest average earthquake magnitude is " + maxAverageMagnitude + ", which is recorded by " + name + ".");
        //Print the largest earthquake ever;
        Earthquake maxMagnitudeEarthquake = monitor.maxMagnitudeEarthquake();
        System.out.println(">> The largest earthquake ever is Earthquake happened in " + Arrays.toString(maxMagnitudeEarthquake.getPosition())
                + " with magnitude " + maxMagnitudeEarthquake.getMagnitude() + ", " + maxMagnitudeEarthquake.getYear() + ".");
        //print all earthquakes with mangnitude greater than a given number;
        monitor.compareMagnitude(givenNumber);
        if (monitor.compareMagnitude(givenNumber).size() == 0) {
            System.out.println(">> No earthquake recorded with magnitude greater than " + givenNumber);
        } else {
            System.out.println(">> Earthquake with magnitude greater than " + givenNumber + ":");
            System.out.println("Year" + "  " + "Magnitude" + "  " + "Position");
            // print all earthquakes with magnitude greater than given number
            for (Earthquake e : monitor.compareMagnitude(givenNumber)) {
                System.out.println(e.toString());
            }
        }
    }

}
