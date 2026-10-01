package Excercises.TASK14.bank;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccountLock {

    private final Long id;
    private final ReentrantLock lock = new ReentrantLock();
    private long balanceGr;

    // TODO: konstruktor
    public BankAccountLock(Long id, long initialPln) {
        this.id = id;
        this.balanceGr = initialPln * 100;
    }

    /**
     * Wywołujący MUSI trzymać lock tego konta.
     */
    void depositUnlocked(long amountGr) { /* TODO */
        if (amountGr <= 0) {
            throw new IllegalArgumentException("Kwota musi być dodatnia: " + amountGr);
        }
        balanceGr += amountGr;
    }

    void withdrawUnlocked(long amountGr) { /* TODO */
        if (amountGr <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        if (balanceGr < amountGr) {
            throw new InsufficientFundsException(id, balanceGr, amountGr);
        }
        balanceGr -= amountGr;
    }

    ReentrantLock lock() {
        return lock;
    }

    long balanceGr() { /* TODO */
        return balanceGr;
    }

    public Long getId() {
        return id;
    }

    static boolean transfer(BankAccountLock from, BankAccountLock to, long amountGr)
            throws InterruptedException {
        if (from == to) {
            return false;
        }

        long deadline = System.currentTimeMillis() + 1000;

        while (System.currentTimeMillis() < deadline) {
            if (from.lock().tryLock(50, TimeUnit.MILLISECONDS)) {
                try {
                    if (to.lock.tryLock(50, TimeUnit.MILLISECONDS)) {
                        try {
                            from.withdrawUnlocked(amountGr);
                            to.depositUnlocked(amountGr);
                            return true;
                        } finally {
                            to.lock.unlock();
                        }
                    }
                } finally {
                    from.lock.unlock();
                }
                Thread.sleep(1);
            }
        }
        return false;
    }
}