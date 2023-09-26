package PortManagement;

import java.time.LocalDate;

public interface TripInterface {
//    void getTripsBetweenDates(LocalDate startDate, LocalDate endDate);
    void completeTrip();
//    void listAllTripHappeningAt(LocalDate inputTime);
    void setDistanceAuto();
    void startNewTrip();
    void setFrom(Port from);
    void setTo(Port to);
    void setContainer(Container container);

}
