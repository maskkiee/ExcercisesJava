package Excercises.TASK11;

public final class MinMax {
    private MinMax() {}
    public static <T extends Comparable<? super T>> Pair<T,T> minMax(T[] arr) {
        if (arr.length == 0 || arr == null) {
            throw new IllegalArgumentException("Array is empty");
        }
        T min = arr[0];
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == null) {
                throw new IllegalArgumentException("Array has null elements.");
            }
            if (min.compareTo(arr[i]) > 0) {
                min = arr[i];
            }
            if (max.compareTo(arr[i]) < 0) {
                max = arr[i];
            }
        }
        return Pair.of(min, max);
    }
}
