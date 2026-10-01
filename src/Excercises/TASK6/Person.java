package Excercises.TASK6;

public enum Person {
    Jan("Jan", DayOfWeek.WEDNESDAY),
    Kasia("Kasia", DayOfWeek.SUNDAY),
    Antek("Antek", DayOfWeek.FRIDAY);

    private String name;
    private DayOfWeek dayOff;

    Person(String name, DayOfWeek dayOff) {
        this.name = name;
        this.dayOff = dayOff;
    }

    public DayOfWeek showDayOff() {
        return dayOff;
    }

    @Override
    public String toString() {
        return name + ", " + dayOff;
    }
}
