package Excercises.TEST11;

public final class ArrayUtils {
    private ArrayUtils() {
    }

    public static <T> void swap(T[] arr, int i, int j) {
        if (arr == null) {
            throw new NullPointerException("Array is null");
        }
        if (i < 0 || i >= arr.length || j < 0 || j >= arr.length) {
            throw new IndexOutOfBoundsException("Index out of bounds: i=" + i + ", j=" + j + ", length=" + arr.length);
        }
        if (arr[i] == arr[j]) return;
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <T> int indexOf(T[] arr, T value) {
        if (arr == null) {
            throw new NullPointerException("Array is null");
        }
        for (int i = 0; i < arr.length; i++) {
            if (value == null) {
                if (arr[i] == null) return i;
            } else {
                if (value.equals(arr[i])) return i;
            }
        }
        return -1;
    }
    public static <T> int lastIndexOf(T[] arr, T value) {
        if (arr == null) {
            throw new NullPointerException("Array is null");
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (value == null) {
                if (arr[i] == null) return i;
            } else {
                if (value.equals(arr[i])) return i;
            }
        }
        return -1;
    }

    public static <T> boolean arraysEqual(T[] a, T[] b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null) {
                if (b[i] != null) return false;
            } else {
                if (!a[i].equals(b[i])) return false;
            }
        }
        return true;
    }
}