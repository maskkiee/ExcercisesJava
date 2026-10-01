package Excercises.TASK14;

import java.util.Random;

public class ParallelSum {

    private static final int SIZE = 1_000_000;
    private static final int PARTS = 4;

    /**
     * Zadanie liczące sumę fragmentu [from, to) i zapisujące ją pod swój indeks.
     */
    static class PartialSumTask implements Runnable {
        private final int[] data;
        private final int from;             // włącznie
        private final int to;               // wyłącznie
        private final long[] results;       // WSPÓLNA tablica wyników
        private final int index;            // MÓJ i tylko mój indeks w results

        // TODO: konstruktor
        PartialSumTask(int[] data, int from, int to, long[] results, int index) {
            this.data = data;
            this.from = from;
            this.to = to;
            this.results = results;
            this.index = index;
        }

        @Override
        public void run() {
            // TODO: policz sumę data[from..to) i zapisz do results[index]
            long sum = 0;
            for (int i = from; i < to; i++) {
                sum += data[i];
            }
            results[index] = sum;
        }
    }

    static long sequentialSum(int[] data) {
        // TODO: zwykła pętla, wynik odniesienia
        long sum = 0;
        for (int i : data) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) throws InterruptedException {
        // TODO: wypełnij tablicę, podziel na PARTS, uruchom wątki, poczekaj, zsumuj, porównaj
        int[] data = new int[SIZE];
        Random random = new Random(10); // powtarzalne dane
        for (int i = 0; i < SIZE; i++) {
            data[i] = random.nextInt(10);
        }
        long[] results = new long[PARTS];
        Thread[] threads = new Thread[PARTS];
        int partSize = SIZE / PARTS;
        int from = 0;
        for (int j = 0; j < PARTS; j++) {
            int to = (j == PARTS - 1) ? SIZE : from + partSize;
            System.out.println("Fragment " + j + " from " + from + " to " + to + " size: " + (to - from));
            threads[j] = new Thread(new PartialSumTask(data, from, to, results, j), "sum-" + j);
            from = to;
        }
        long t0 = System.nanoTime();
        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();
        long parallelMs = (System.nanoTime() - t0) / 1_000_000;
        long parallel = 0;
        for (long r : results) {
            parallel += r;
        }
        long t1 = System.nanoTime();
        long sequential = sequentialSum(data);
        long sequentialMs = (System.nanoTime() - t1) / 1_000_000;
        System.out.println("Parallel sum : " + parallel + "  (" + parallelMs + " ms)");
        System.out.println("Sequential sum: " + sequential + "  (" + sequentialMs + " ms)");
    }
}