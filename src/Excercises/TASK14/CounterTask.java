package Excercises.TASK14;

public class CounterTask implements Runnable {
    private final int number;              // numer TEGO wątku – przekazany w konstruktorze

    public CounterTask(int number) {
        // TODO
        this.number = number;
    }

    @Override
    public void run() {
        // TODO: wypisz numer, potem pętla 1..10 z Thread.sleep(100)
        System.out.println("Thread #" + number);
        for (int i = 0; i < number; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // TODO: utwórz N wątków, uruchom je, poczekaj na wszystkie, wypisz komunikat końcowy
        final int threadAmount = 3;
        Thread[] threads = new Thread[threadAmount];
        for (int i = 0; i < threadAmount; i++) {
            threads[i] = new Thread(new CounterTask(i + 1), "counter-" + (i + 1));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Finished all threads");
    }
}