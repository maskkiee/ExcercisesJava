package Excercises.TASK8;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {
    static void main() {
        zadanie1();
        zadanie2();
        zadanie3();
        zadanie4();
        zadanie5();
        zadanie6();
        zadanie7();
        zadanie8();
        zadanie9();
        zadanie10();
        zadanie11();
    }

    /*1. **Ta sama strefa**

     * Wylot: `2025-01-15 10:00:00 (Europe/Warsaw)`
     * Przylot: `2025-01-15 12:30:00 (Europe/Warsaw)`
     * **Oczekiwane:** `2h 30m`*/
    static void zadanie1() {
        System.out.println("Zadanie 1:");
        Flight flight = new Flight("LO123", "WAW", "WAW",
                LocalDateTime.of(2025, 1, 15, 10, 0, 0),
                LocalDateTime.of(2025, 1, 15, 12, 30, 0));
        Duration duration = flight.calculateFlightDuration();
        System.out.println(flight);
        System.out.println("Duration: " + formatDuration(duration));
        System.out.println();
    }

    /*2. **Na inny dzień (ta sama strefa)**

     * Wylot: `2025-01-15 23:00:00 (Europe/Warsaw)`
     * Przylot: `2025-01-16 01:30:00 (Europe/Warsaw)`
     * **Oczekiwane:** `2h 30m`*/
    static void zadanie2() {
        System.out.println("Zadanie 2:");
        Flight flight = new Flight("LO456", "WAW", "WAW",
                LocalDateTime.of(2025, 1, 15, 23, 0, 0),
                LocalDateTime.of(2025, 1, 16, 1, 30, 0));
        Duration duration = flight.calculateFlightDuration();
        System.out.println(flight);
        System.out.println("Duration: " + formatDuration(duration));
        System.out.println();
    }

    /*3. **Międzystrefowy (WAW → NYC)**

     * Wylot: `2025-01-15 10:00:00 (Europe/Warsaw)`
     * Przylot: `2025-01-15 14:00:00 (America/New_York)`
     * **Oczekiwane:** `10h`
     *Wyjaśnienie: 09:00Z → 19:00Z.**/
    static void zadanie3() {
        System.out.println("Zadanie 3:");
        Flight flight = new Flight("LO201", "WAW", "JFK",
                LocalDateTime.of(2025, 1, 15, 10, 0, 0),
                LocalDateTime.of(2025, 1, 15, 14, 0, 0));
        Duration duration = flight.calculateFlightDuration();
        System.out.println(flight);
        System.out.println("Duration: " + formatDuration(duration));
        System.out.println();
    }

    /*4. **Zmiana na czas letni (spring‑forward)**

     * Wylot: `2025-03-30 01:00:00 (Europe/Warsaw)`
     * Przylot: `2025-03-30 05:00:00 (Europe/Warsaw)`
     * **Oczekiwane:** `3h`
     *Godzina 02:00–02:59 nie istnieje.**/
    static void zadanie4() {
        System.out.println("Zadanie 4:");
        Flight flight = new Flight("LO789", "WAW", "WAW",
                LocalDateTime.of(2025, 3, 30, 1, 0, 0),
                LocalDateTime.of(2025, 3, 30, 5, 0, 0));
        Duration duration = flight.calculateFlightDuration();
        System.out.println(flight);
        System.out.println("Duration: " + formatDuration(duration));
        System.out.println();
    }

    /*5. **Zmiana na czas zimowy (fall‑back)**

     * Wylot: `2025-10-26 01:00:00 (Europe/Warsaw)`
     * Przylot: `2025-10-26 02:30:00 (Europe/Warsaw)`
     * **Oczekiwane:** `1h 30m`
     *Uwaga: 02:30 występuje dwa razy; przyjmujemy wcześniejszy offset.**/
    static void zadanie5() {
        System.out.println("Zadanie 5:");
        Flight flight = new Flight("LO321", "WAW", "WAW",
                LocalDateTime.of(2025, 10, 26, 1, 0, 0),
                LocalDateTime.of(2025, 10, 26, 2, 30, 0));
        Duration duration = flight.calculateFlightDuration();
        System.out.println(flight);
        System.out.println("Duration: " + formatDuration(duration));
        System.out.println();
    }

    /*6. **Linia zmiany daty (Tokyo → LA)**

     * Wylot: `2025-01-15 10:00:00 (Asia/Tokyo)`
     * Przylot: `2025-01-14 18:00:00 (America/Los_Angeles)`
     * **Oczekiwane:** `1h`
     *01:00Z → 02:00Z (to przykład „szkolny”, a nie realistyczny).**/
    static void zadanie6() {
        System.out.println("Zadanie 6:");
        Flight flight = new Flight("NH105", "NRT", "LAX",
                LocalDateTime.of(2025, 1, 15, 10, 0, 0),
                LocalDateTime.of(2025, 1, 14, 18, 0, 0));
        Duration duration = flight.calculateFlightDuration();
        System.out.println(flight);
        System.out.println("Duration: " + formatDuration(duration));
        System.out.println();
    }

    /*7. **Nieprawidłowa strefa czasowa**

     * Próba: `ZoneId.of("Invalid/Zone")`
     * **Oczekiwane:** wyjątek `DateTimeException` (np. `ZoneRulesException`).*/
    static void zadanie7() {
        System.out.println("Zadanie 7:");
        try {
            ZoneId invalid = ZoneId.of("Invalid/Zone");
            System.out.println("Zone created: " + invalid);
        } catch (DateTimeException e) {
            System.out.println("Caught expected exception: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
        }
        System.out.println();
    }

    /*8. **Przylot przed wylotem (ta sama strefa)**

     * Wylot: `2025-01-15 10:00:00 (Europe/Warsaw)`
     * Przylot: `2025-01-15 08:00:00 (Europe/Warsaw)`
     * **Oczekiwane:** wyjątek `IllegalArgumentException` (walidacja po `Instant`).*/
    static void zadanie8() {
        System.out.println("Zadanie 8:");
        try {
            Flight flight = new Flight("LO999", "WAW", "WAW",
                    LocalDateTime.of(2025, 1, 15, 10, 0, 0),
                    LocalDateTime.of(2025, 1, 15, 8, 0, 0));
            System.out.println("Flight created: " + flight);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
        }
        System.out.println();
    }

    /*9. **Brak DST w miejscu przylotu (WAW → Kolkata)**

     * Wylot: `2025-01-15 10:00:00 (Europe/Warsaw)`
     * Przylot: `2025-01-15 19:00:00 (Asia/Kolkata)`
     * **Oczekiwane:** `4h 30m`
     *09:00Z → 13:30Z.**/
    static void zadanie9() {
        System.out.println("Zadanie 9:");
        Flight flight = new Flight("LO445", "WAW", "CCU",
                LocalDateTime.of(2025, 1, 15, 10, 0, 0),
                LocalDateTime.of(2025, 1, 15, 19, 0, 0));
        Duration duration = flight.calculateFlightDuration();
        System.out.println(flight);
        System.out.println("Duration: " + formatDuration(duration));
        System.out.println();
    }

    /*10. **Długi lot (WAW → Singapore)**

     * Wylot: `2025-01-15 06:00:00 (Europe/Warsaw)`
     * Przylot: `2025-01-16 06:00:00 (Asia/Singapore)`
     * **Oczekiwane:** `17h`
     *05:00Z (15.01) → 22:00Z (15.01).**/
    static void zadanie10() {
        System.out.println("Zadanie 10:");
        Flight flight = new Flight("SQ368", "WAW", "SIN",
                LocalDateTime.of(2025, 1, 15, 6, 0, 0),
                LocalDateTime.of(2025, 1, 16, 6, 0, 0));
        Duration duration = flight.calculateFlightDuration();
        System.out.println(flight);
        System.out.println("Duration: " + formatDuration(duration));
        System.out.println();
    }

    /*11. **W obie strony tego samego dnia (WAW ↔ LON, zima)**

     * WAW → LON: `2025-01-15 08:00:00 (Europe/Warsaw)` → `2025-01-15 12:00:00 (Europe/London)`

     * **Oczekiwane:** `5h`  *(07:00Z → 12:00Z)*
     * LON → WAW: `2025-01-15 16:00:00 (Europe/London)` → `2025-01-15 20:00:00 (Europe/Warsaw)`

     * **Oczekiwane:** `3h`  *(16:00Z → 19:00Z)**/
    static void zadanie11() {
        System.out.println("Zadanie 11:");
        Flight flight1 = new Flight("BA472", "WAW", "LHR",
                LocalDateTime.of(2025, 1, 15, 8, 0, 0),
                LocalDateTime.of(2025, 1, 15, 12, 0, 0));
        Duration duration1 = flight1.calculateFlightDuration();
        System.out.println(flight1);
        System.out.println("Duration: " + formatDuration(duration1));
        System.out.println();

        Flight flight2 = new Flight("BA473", "LHR", "WAW",
                LocalDateTime.of(2025, 1, 15, 16, 0, 0),
                LocalDateTime.of(2025, 1, 15, 20, 0, 0));
        Duration duration2 = flight2.calculateFlightDuration();
        System.out.println(flight2);
        System.out.println("Duration: " + formatDuration(duration2));
        System.out.println();
    }

    private static String formatDuration(Duration d) {
        long hours = d.toHours();
        long minutes = d.toMinutesPart();
        if (minutes > 0) {
            return hours + "h " + minutes + "m";
        }
        return hours + "h";
    }
}