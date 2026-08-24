package Excercises.TEST11;

public final class Stats<T extends Number> {
    private final T[] data;

    public Stats(T[] data) {
        if (data.length == 0 || data == null) {
            throw new IllegalArgumentException("Arrays cannot be empty.");
        }
        this.data = data;
    }

    public double mean() {
        double mean = 0;
        for (T value : data) {
            mean += value.doubleValue();
        }
        return mean / data.length;
    }

    public double variance() {
        double m = mean();
        double sum = 0;
        for (T value : data) {
            double diff = value.doubleValue() - m;
            sum += diff * diff;
        }
        return sum / data.length;
    }

    public boolean hasSameMean(Stats<?> other, double eps) {
        return Math.abs(this.mean() - other.mean()) <= eps;
    }
}