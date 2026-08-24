package Excercises.TEST11;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }

    public static void test1() {
        System.out.println("test1:");
        Pair<Integer, String> p1 = Pair.of(1, "a");
        Pair<Integer, String> p2 = Pair.of(1, "a");
        Pair<Integer, String> p3 = Pair.of(1, "b");

        System.out.println("p1.equals(p2) = " + p1.equals(p2));
        System.out.println("p1.equals(p3) = " + p1.equals(p3));
        System.out.println("p1.hashCode() == p2.hashCode() = " + (p1.hashCode() == p2.hashCode()));

        Pair<Object, String> pNull = Pair.of(null, "x");
        System.out.println("pNull.first(): " + pNull.first());
        System.out.println("pNull: " + pNull);
        System.out.println();
    }

    public static void test2() {
        System.out.println("test2:");
        String[] a = {"A", "B", "C"};
        System.out.println("Before swap: " + Arrays.toString(a));
        ArrayUtils.swap(a, 0, 2);
        System.out.println("After swap(0,2): " + Arrays.toString(a));
        try {
            Integer[] nums = {1, 2, 3};
            ArrayUtils.swap(nums, -1, 0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("swap(-1,0): " + e.getMessage());
        }

        String[] x = {"X", "Y"};
        System.out.println("Before swap: " + Arrays.toString(x));
        ArrayUtils.swap(x, 1, 1);
        System.out.println("After swap(1,1): " + Arrays.toString(x));

        System.out.println();
    }

    public static void test3() {
        System.out.println("test3:");
        Integer[] a = {1, 2, 3, 4};
        Stats<Integer> stats = new Stats<>(a);
        System.out.println("mean [1,2,3,4]: " + stats.mean());
        System.out.println("variance [1,2,3,4]: " + stats.variance());

        Double[] x = {2.0, 2.0};
        Double[] y = {2.001, 1.999};
        Stats<Double> statsX = new Stats<>(x);
        Stats<Double> statsY = new Stats<>(y);
        System.out.println("hasSameMean([2.0,2.0], [2.001,1.999], eps=0.01): "
                + statsX.hasSameMean(statsY, 0.01));

        try {
            Stats<Integer> empty = new Stats<>(new Integer[]{});
        } catch (IllegalArgumentException e) {
            System.out.println("Empty stats: " + e.getMessage());
        }
        System.out.println();
    }

    public static void test4() {
        System.out.println("test4:");
        String[] s = {"aa", "b", "ccc"};
        Pair<String, String> minMaxS = MinMax.minMax(s);
        System.out.println("minMax([aa,b,ccc]): " + minMaxS.first() + ", " + minMaxS.second());

        Integer[] nums = {5, 5, -1, 10, 10};
        Pair<Integer, Integer> minMaxN = MinMax.minMax(nums);
        System.out.println("minMax([5,5,-1,10,10]): " + minMaxN.first() + ", " + minMaxN.second());

        Integer[] single = {42};
        Pair<Integer, Integer> minMaxSingle = MinMax.minMax(single);
        System.out.println("minMax([42]): " + minMaxSingle.first() + ", " + minMaxSingle.second());

        try {
            Integer[] arr = {1, null, 2};
            Pair<Integer, Integer> minMaxArr = MinMax.minMax(arr);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }

    public static void test5() {
        System.out.println("test5:");
        String[] s = {null, "a", null, "b", "a"};
        System.out.println("indexOf(null): " + ArrayUtils.indexOf(s, null));
        System.out.println("lastIndexOf(null): " + ArrayUtils.lastIndexOf(s, null));
        System.out.println("indexOf(a): " + ArrayUtils.indexOf(s, "a"));
        System.out.println("lastIndexOf(a): " + ArrayUtils.lastIndexOf(s, "a"));

        String[] s2 = {"x", "y"};
        System.out.println("indexOf(zzz): " + ArrayUtils.indexOf(s2, "zzz"));
        System.out.println();
    }

    public static void test6() {
        System.out.println("test6:");
        Integer[] a = {1, null, 3};
        Integer[] b = {1, null, 3};
        Integer[] c = {1, 2, 3};
        System.out.println("ArrayUtils.arraysEqual(a, b) = " + ArrayUtils.arraysEqual(a, b));
        System.out.println("ArrayUtils.arraysEqual(a, c) = " + ArrayUtils.arraysEqual(a, c));
        System.out.println("[x] == null: " + ArrayUtils.arraysEqual(new String[]{"x"}, null));
        System.out.println("null == null: " + ArrayUtils.arraysEqual(null, null));
        System.out.println();
    }

    public static void test7() {
        System.out.println("test7:");
        Triple t1 = Triple.of("id", 42, true);
        Triple t2 = Triple.of("id", 42, true);
        Triple t3 = Triple.of("id", 43, true);
        System.out.println("t1.equals(t2) = " + t1.equals(t2));
        System.out.println("t1.equals(t3) = " + t1.equals(t3));

        System.out.println("t1.first(): " + t1.first());
        System.out.println("t1.second(): " + t1.second());
        System.out.println("t1.third(): " + t1.third());

        Triple t = Triple.of("A", "B", "C");
        System.out.println(t);
        System.out.println();
    }
}

