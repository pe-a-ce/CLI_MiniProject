import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {

    @Test
    void addPassengerToFlight() {
//        Given
        Airport testAirport = new Airport();

//        When

//        Then

    }

    @Test
    void addFlight__Test() {
//        Given
        Airport testAirport = new Airport();

//        When
        testAirport.addFlight(Destination.LONDON, 42);

//        Then
        assertEquals(42, testAirport.getAllFlights().get(0).getFlightId());
        assertEquals(Destination.LONDON, testAirport.getAllFlights().get(0).getDestination());

    }
}