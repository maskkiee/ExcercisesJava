package Excercises.TASK8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Flight {
    private String flightNumber;
    private String departureAirport;
    private String arrivalAirport;
    private ZonedDateTime departureTime;
    private ZonedDateTime arrivalTime;

    public ZonedDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(ZonedDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepatureAirport() {
        return departureAirport;
    }

    public void setDepatureAirport(String depatureAirport) {
        this.departureAirport = depatureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public ZonedDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(ZonedDateTime departureTime) {
        this.departureTime = departureTime;
    }

    private static final Map<String, ZoneId> IATA_MAP = new HashMap<>();

    static {
        IATA_MAP.put("WAW", ZoneId.of("Europe/Warsaw"));
        IATA_MAP.put("JFK", ZoneId.of("America/New_York"));
        IATA_MAP.put("NRT", ZoneId.of("Asia/Tokyo"));
        IATA_MAP.put("LAX", ZoneId.of("America/Los_Angeles"));
        IATA_MAP.put("CCU", ZoneId.of("Asia/Kolkata"));
        IATA_MAP.put("SIN", ZoneId.of("Asia/Singapore"));
        IATA_MAP.put("LHR", ZoneId.of("Europe/London"));
    }

    public static ZoneId getZoneId(String iata) {
        ZoneId zone = IATA_MAP.get(iata);
        if (zone == null) {
            throw new DateTimeException("Unknown IATA code: " + iata);
        }
        return zone;
    }

    public Duration calculateFlightDuration() {
        return Duration.between(departureTime.toInstant(), arrivalTime.toInstant());
    }

    private ZonedDateTime validate(LocalDateTime local, ZoneId zone) {
        ZonedDateTime zdt = ZonedDateTime.of(local, zone);
        if (!zdt.toLocalDateTime().equals(local)) {
            throw new DateTimeException("Local time " + local + " does not exist in " +
                    zone + " due to DST spring-forward transition");
        }
        return zdt;
    }

    public Flight(String flightNumber, String departureAirport, String arrivalAirport,
                  LocalDateTime departureLocal, LocalDateTime arrivalLocal) {
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;

        ZoneId depZone = getZoneId(departureAirport);
        ZoneId arrZone = getZoneId(arrivalAirport);

        this.departureTime = ZonedDateTime.of(departureLocal, depZone);
        this.arrivalTime = validate(arrivalLocal, arrZone);

        if (this.arrivalTime.toInstant().isBefore(this.departureTime.toInstant())) {
            throw new IllegalArgumentException("Departure time is before arrival time");
        }


    }

    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public String toString() {
        return flightNumber + ": " + departureAirport + " (" + departureTime.format(FMT) + ") -> " +
                arrivalAirport + " (" + arrivalTime.format(FMT) + ")";
    }

}