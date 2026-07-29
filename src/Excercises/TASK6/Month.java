package Excercises.TASK6;

public enum Month {
    JANUARY(31, false),
    FEBRUARY(28, false),
    MARCH(31, false),
    APRIL(30, false),
    MAY(31, false),
    JUNE(30, false),
    JULY(31, true),
    AUGUST(31, true),
    SEPTEMBER(30, false),
    OCTOBER(31, false),
    NOVEMBER(30, false),
    DECEMBER(31, false);

    private final int days;
    private final boolean isHolidaySeason;

    private Month(int days, boolean isHolidaySeason) {
        this.days = days;
        this.isHolidaySeason = isHolidaySeason;
    }

    public int getDays() {
        return this.days;
    }

    /*9. **Enum z kilkoma polami**
    - Dodaj w `Month` drugie pole: `isHolidaySeason` (boolean).
    - Wypisz wszystkie miesiące wraz z informacją, które są wakacyjne.*/
    public boolean isHolidaySeason() {
        return this.isHolidaySeason;
    }

    /*7. **Enum i metoda toString**
    - W `Month` nadpisz metodę `toString()`, aby zwracała napis w formacie:
      `NAZWA (days: X)`.*/
    public String toString() {
        String dayNumber = this.name();
        return dayNumber + " (days: " + this.days + ")";
    }
}