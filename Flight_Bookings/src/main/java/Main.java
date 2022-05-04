import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {

        Airport emptyAirport = new Airport();

        Scanner in = new Scanner(System.in);
        System.out.println("Take flight with Take Flight airways!");
        System.out.println("Option 1: Add a new flight");
        System.out.println("Option 2: Display all available flights");
        System.out.println("Option 3: Add a new passenger");
        System.out.println("Option 4: Book a passenger onto an existing flight");
        System.out.println("Option 5: Cancel an existing flight");
        System.out.println("Please choose an option:");
        int option = in.nextInt();
        System.out.println("You chose option " + option);

        switch (option) {
            case 1:
                System.out.println("Please select a destination for the flight:");
                Stream.of(Destination.values()).forEach(System.out::println);
                Destination flightDest = Destination.valueOf(in.next().toUpperCase());
                System.out.println("Please provide an ID number: ");
                int flightID = in.nextInt();
                emptyAirport.addFlight(flightDest, flightID);
                break;


        }

        System.out.println(emptyAirport.getAllFlights().toString());

    }

}
