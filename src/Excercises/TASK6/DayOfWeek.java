package Excercises.TASK6;

public enum DayOfWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
        /*5. **Enum z metodą**
    - Dodaj w `DayOfWeek` metodę `isWeekend()`, która zwraca `true` dla SATURDAY i SUNDAY.
    - W `main` sprawdź działanie dla kilku dni.*/
    public boolean isWeekend() {
        return this == SATURDAY || this == SUNDAY;
    }
}