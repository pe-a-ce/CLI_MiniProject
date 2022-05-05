import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {

        Airport ukAirport = new Airport();
        List<Passenger> emptyPassengers = new ArrayList<>();

        //        Just as a placeholder to prove case 2 is functional.
        ukAirport.addFlight(Destination.BARCELONA, 1);
        ukAirport.addFlight(Destination.MIAMI, 2);
        ukAirport.addFlight(Destination.PARIS, 3);
//        End of placeholder.

        Scanner in = new Scanner(System.in);
        System.out.println("Take flight with Take Flight airways!");
        System.out.println("Option 1: Add a new flight");
        System.out.println("Option 2: Display all available flights");
        System.out.println("Option 3: Add a new passenger");
        System.out.println("Option 4: Book a passenger onto an existing flight");
        System.out.println("Option 5: Cancel an existing flight");
        System.out.println("Please choose an option: ");
        int option = in.nextInt();
        System.out.println("You chose option " + option);

        switch (option) {
            case 1:

                System.out.println("Please select a destination for the flight:");
                Stream.of(Destination.values()).forEach(System.out::println);
                Destination flightDest = Destination.valueOf(in.next().toUpperCase());

                System.out.println("Please provide an ID number: ");
                int flightID = in.nextInt();
                ukAirport.addFlight(flightDest, flightID);
                break;

            case 2:
                TestUtil.FLIGHTS
                        .forEach(flight -> System.out.println(flight.getDestination()
                                + ", Flight number "
                                + flight.getFlightId()));
                break;
//                After we complete all the test cases, can add some logic in so when a plane has 10 passengers,
//                it is 'Full' and is not 'Available' anyone.

            case 3:
                //but which flight are we adding them to? Provide a flight ID?
                System.out.println("Please provide a first name: ");
                String firstName = in.next().toLowerCase();
                System.out.println("Please provide a last name: ");
                String lastName = in.next().toLowerCase();
                System.out.println("Please provide an email address: ");
                String email = in.next();
                System.out.println("Finally, please provide your passport number: ");
                int passportID = in.nextInt();
                Passenger newPassenger = new Passenger(firstName, lastName, email, passportID);
                emptyPassengers.add(newPassenger);
                System.out.println("Passenger " + firstName + " " + lastName + " has been added.");
                break;
            case 4:
                //Provide passenger id
                System.out.println("Please provide a passport number: ");
                int passengerId = in.nextInt();
                //Find correct passenger
                Passenger passengerToAdd = emptyPassengers.stream().filter(p -> p.getPassportID() == passengerId).toList().get(0);

                //Provide flight ID
                System.out.println("Please provide the flight ID to book on to: ");
                int flightId = in.nextInt();
                //Find correct flight
                Flight flightToAdd = ukAirport.getAllFlights().stream().filter(f -> f.getFlightId() == flightId).toList().get(0);

                //Add passenger to flight
                flightToAdd.addPassenger(passengerToAdd);


            case 5:

                while (loop) {
                    try{
                        System.out.println("Please select the flight you wish to cancel");
                        int flightNumber = in.nextInt();
                        System.out.println("You have selected " + flightNumber + ". Is this correct? y/n ");

                        ukAirport.removeFlight();
                        System.out.println("The flight " + flightNumber + " has been deleted. Thank you");

                    }


                }



        }

    }
