package Excercises.TASK4;

public class TASK4s {
    static void main() {
        System.out.println("NWD 20, 30 = " + nwdRek(20, 30));
        System.out.println("NWD 17, 3 = " + nwdRek(17, 3));
        System.out.println("NWD 18, 84 = " + nwdRek(18, 54));
    }

    public static int nwdRek(int a, int b) {
        if (b == 0) {
            return a;
        }
        return nwdRek(b, a % b);
    }
}