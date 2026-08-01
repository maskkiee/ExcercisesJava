package Excercises.TASK6;

public enum Planet {
    Mercury(0.330, 2440),
    Venus(4.869, 6052),
    Earth(5.972, 6371),
    Mars(0.642, 3390),
    Jupiter(1898, 69991),
    Saturn(568, 58232),
    Uranus(86.8, 25362),
    Neptune(102, 24622);

    private final double mass;
    private final double radius;

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public double getDensity() {
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
        return mass / volume;
    }


}
