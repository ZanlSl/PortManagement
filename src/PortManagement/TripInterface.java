package PortManagement;

import java.time.LocalDateTime;

public interface TripInterface {
    void getTripsBetweenDates(LocalDateTime startDate, LocalDateTime endDate);
    void completeTrip();
    void listAllTripHappeningAt(LocalDateTime inputTime);
}
