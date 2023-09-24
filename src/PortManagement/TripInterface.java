package PortManagement;

import java.time.LocalDateTime;

public interface TripInterface {
    void getTripsBetweenDates(LocalDateTime startDate, LocalDateTime endDate);
    void completeTrip();
    void listAllTripHappeningAt(LocalDateTime inputTime);
    void setDistanceAuto();
    void startNewTrip();
    void setFrom(Port from);
    void setTo(Port to);
    void setContainer(Container container);

}
