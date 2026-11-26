package Excercises.TASK12;

public class Utils {

    static TwoKeyMap<String, String, Integer> setUp() {
        TwoKeyMap<String, String, Integer> grades = new NestedTwoKeyHashMap<>();
        grades.put("Alice", "Math", 5);
        grades.put("Alice", "CS", 4);
        grades.put("Bob", "Math", 3);
        return grades;
    }

    static TwoKeyMap<String, String, Integer> empty() {
        return new NestedTwoKeyHashMap<>();
    }

    static void check(String name, boolean condition) {
        if (condition) {
            System.out.println(name + " true");
        } else {
            System.out.println(name + " false");
        }
    }
}
