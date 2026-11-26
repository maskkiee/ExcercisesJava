package Excercises.TASK12;

public class Main {
    static void main() {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    private static void test1() {
        System.out.println("Test1: put / get / containsKeys / size / remove");
        TwoKeyMap<String, String, Integer> grades = Utils.setUp();
        Utils.check("isEmpty?", grades.isEmpty());
        grades.put("Ben", "Math", 3);
        Utils.check("contains Ben -> Math?", grades.containsKeys("Ben", "Math"));
        System.out.println("Ben -> Math grade:" + grades.get("Ben", "Math"));
        Utils.check("get missing = null", grades.get("Ben", "CS") == null);
        System.out.println("Size of the map:" + grades.size());
        grades.remove("Alice", "Math");
        Utils.check("Contains Alice -> Math?", grades.containsKeys("Alice", "Math"));
        System.out.println();
    }

    private static void test2() {
        System.out.println("Test2: entrySet, keySet, values");
        TwoKeyMap<String, String, Integer> grades = Utils.setUp();
        System.out.println("entrySet:" + grades.entrySet());
        System.out.println("keySet:" + grades.keySet());
        System.out.println("values:" + grades.values());
        System.out.println();
    }

    private static void test3() {
        System.out.println("Test3: clear");
        TwoKeyMap<String, String, Integer> grades = Utils.setUp();
        grades.clear();
        Utils.check("isEmpty?", grades.isEmpty());
        System.out.println();
    }

    private static void test4() {
        System.out.println("Test4: Iterator");
        TwoKeyMap<String, String, Integer> grades = Utils.setUp();
        System.out.println(grades.iterator());
        System.out.println();
    }

    private static void test5() {
        System.out.println("Test5: null rejected");
        TwoKeyMap<String, String, Integer> grades = Utils.empty();
        try{
            grades.put(null, "Math", 3);
        } catch(NullPointerException e) {
            System.out.println(e.getMessage());
        }
        try{
            grades.put("Ben", null, 3);
        } catch(NullPointerException e) {
            System.out.println(e.getMessage());
        }
        try{
            grades.put("Ben", "Math", null);
        } catch(NullPointerException e) {
            System.out.println(e.getMessage());
        }
        Utils.check("Still empty?", grades.isEmpty());
        System.out.println();
    }
}
