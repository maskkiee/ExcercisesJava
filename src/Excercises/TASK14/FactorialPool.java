package Excercises.TASK14;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class FactorialPool {

    private static final int POOL_SIZE = 4;
    private static final int MAX_N = 20;

    /** Liczy n! i zwraca wynik; w środku losowy sleep 100–500 ms. */
    static BigInteger factorial(int n) {
        // TODO
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 501));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(POOL_SIZE);
        List<Future<BigInteger>> futures = new ArrayList<>();
        long t0 = System.nanoTime();
        // TODO 1: dla każdego n złóż zadanie do puli i zapamiętaj Future
        for (int n = 1; n <= MAX_N; n++) {
            final int m = n;
            futures.add(pool.submit(() -> factorial(m)));
        }
        // TODO 2: w DRUGIEJ pętli odbierz wyniki i wypisz "n -> wynik"
        int n = 1;
        for (Future<BigInteger> future : futures) {
            BigInteger result = future.get();
            System.out.println(n + " -> " + result);
            n++;
        }

        long elapsedMs = (System.nanoTime() - t0) / 1_000_000;
        System.out.println("Time: " + elapsedMs + " ms");
        // TODO 3: zamknij pulę
        pool.shutdown();
    }
}