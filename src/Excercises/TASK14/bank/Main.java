package Excercises.TASK14.bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final int ACCOUNTS = 10;
    private static final long INITIAL_PLN = 1000;
    private static final int TRANSFERS = 1000;
    private static final long MIN_AMOUNT_GR = 100 * 100;  // 100 PLN
    private static final long MAX_AMOUNT_GR = 500 * 100;  // 500 PLN
    private static final int POOL_SIZE = 8;
    private static final long EXPECTED_TOTAL_GR = ACCOUNTS * INITIAL_PLN * 100;

    record Transfer(long fromId, long toId, long amountGr) {
    }

    static Transfer[] generateTransfers() {
        Random random = new Random(10);
        Transfer[] transfers = new Transfer[TRANSFERS];
        for (int i = 0; i < TRANSFERS; i++) {
            long fromId = random.nextInt(ACCOUNTS);
            long toId = random.nextInt(ACCOUNTS - 1);
            if (toId >= fromId) {
                toId++;
            }
            long amountGr = MIN_AMOUNT_GR + random.nextInt((int) (MAX_AMOUNT_GR - MIN_AMOUNT_GR + 1));
            transfers[i] = new Transfer(fromId, toId, amountGr);
        }
        return transfers;
    }

    static void runSynchronized(Transfer[] transfers) throws Exception {
        Bank bank = new Bank();
        for (int id = 0; id < ACCOUNTS; id++) {
            bank.openAccount(id, INITIAL_PLN);
        }

        AtomicInteger failed = new AtomicInteger();
        ExecutorService pool = Executors.newFixedThreadPool(POOL_SIZE);
        long t0 = System.nanoTime();

        CompletableFuture<?>[] all = new CompletableFuture[TRANSFERS];
        for (int i = 0; i < TRANSFERS; i++) {
            final Transfer transfer = transfers[i];
            all[i] = CompletableFuture.runAsync(() -> {
                try {
                    bank.transfer(transfer.fromId, transfer.toId, transfer.amountGr);
                } catch (InsufficientFundsException e) {
                    failed.incrementAndGet();
                }
            }, pool);
        }
        CompletableFuture.allOf(all).join();

        long elapsedMs = (System.nanoTime() - t0) / 1_000_000;
        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);

        for (int id = 0; id < ACCOUNTS; id++) {
            long balance = bank.get((long) id).getBalanceGr();
            System.out.printf("Account: " + id + " balance: " + balance + " gr, " + balance / 100.0 + " PLN%n");
        }
        verdict("synchronized", elapsedMs, failed.get(), -1, bank.totalBalanceGr());
    }

    static void runLock(Transfer[] transfers) throws Exception {
        Map<Long, BankAccountLock> accounts = new HashMap<>();
        for (long id = 0; id < ACCOUNTS; id++) {
            accounts.put(id, new BankAccountLock(id, INITIAL_PLN));
        }

        AtomicInteger failed = new AtomicInteger();
        AtomicInteger gaveUp = new AtomicInteger();
        ExecutorService pool = Executors.newFixedThreadPool(POOL_SIZE);
        long t0 = System.nanoTime();

        CompletableFuture<?>[] all = new CompletableFuture[TRANSFERS];
        for (int i = 0; i < TRANSFERS; i++) {
            final Transfer transfer = transfers[i];
            all[i] = CompletableFuture.runAsync(() -> {
                BankAccountLock from = accounts.get(transfer.fromId());
                BankAccountLock to = accounts.get(transfer.toId());
                try {
                    if (!BankAccountLock.transfer(from, to, transfer.amountGr())) {
                        gaveUp.incrementAndGet();
                    }
                } catch (InsufficientFundsException e) {
                    failed.incrementAndGet();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, pool);
        }
        CompletableFuture.allOf(all).join();

        long elapsedMs = (System.nanoTime() - t0) / 1_000_000;
        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);

        long total = 0;
        for (int id = 0; id < ACCOUNTS; id++) {
            long balance = accounts.get((long) id).balanceGr();
            total += balance;
            System.out.printf("Account: " + id + " balance: " + balance + " gr, " + balance / 100.0 + " PLN%n");
        }
        verdict("ReentrantLock", elapsedMs, failed.get(), gaveUp.get(), total);
    }

    static void runAtomic(Transfer[] transfers) throws Exception {
        Map<Long, BankAccountAtomic> accounts = new HashMap<>();
        for (long id = 0; id < ACCOUNTS; id++) {
            accounts.put(id, new BankAccountAtomic(INITIAL_PLN));
        }

        AtomicInteger failed = new AtomicInteger();
        ExecutorService pool = Executors.newFixedThreadPool(POOL_SIZE);
        long t0 = System.nanoTime();

        CompletableFuture<?>[] all = new CompletableFuture[TRANSFERS];
        for (int i = 0; i < TRANSFERS; i++) {
            final Transfer transfer = transfers[i];
            all[i] = CompletableFuture.runAsync(() -> {
                BankAccountAtomic from = accounts.get(transfer.fromId());
                BankAccountAtomic to = accounts.get(transfer.toId());
                if (from.tryWithdraw(transfer.amountGr())) {
                    to.deposit(transfer.amountGr());
                } else {
                    failed.incrementAndGet();
                }
            }, pool);
        }
        CompletableFuture.allOf(all).join();

        long elapsedMs = (System.nanoTime() - t0) / 1_000_000;
        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);

        long total = 0;
        for (int id = 0; id < ACCOUNTS; id++) {
            long balance = accounts.get((long) id).balanceGr();
            total += balance;
            System.out.printf("Account: " + id + " balance: " + balance + " gr, " + balance / 100.0 + " PLN%n");
        }
        verdict("AtomicReference", elapsedMs, failed.get(), -1, total);
    }

    private static void verdict(String variant, long elapsedMs, int failed, int gaveUp, long total) {
        System.out.println(variant);
        System.out.println("  time: " + elapsedMs + " ms, unsuccessful: " + failed
                + (gaveUp >= 0 ? ",tryLock resignation: " + gaveUp : ""));
        System.out.printf("  sum: %d gr (%.2f PLN)%n", total, total / 100.0);
        if (total != EXPECTED_TOTAL_GR) {
            throw new AssertionError("Verdict: failed. sum=" + total);
        }
        System.out.println("Verdict: OK");
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Transfer[] transfers = generateTransfers();
        System.out.println("Transactions=" + TRANSFERS + ", Accounts=" + ACCOUNTS
                + " * " + INITIAL_PLN + " PLN, pool=" + POOL_SIZE);

        runSynchronized(transfers);
        runLock(transfers);
        runAtomic(transfers);
    }
}
