package Excercises.TASK14.bank;

import java.util.concurrent.TimeUnit;

public class BankAccount {
    private final Long id;
    private long balanceGr;                 // saldo w GROSZACH

    public BankAccount(Long id, long initialPln) {
        // TODO: zapamiętaj id, przelicz złote na grosze
        this.id = id;
        this.balanceGr = initialPln * 100;
    }

    public synchronized void deposit(long amountGr) {
        // TODO: odrzuć amountGr <= 0 (IllegalArgumentException), dodaj do salda
        if (amountGr <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        balanceGr += amountGr;
    }

    public synchronized void withdraw(long amountGr) {
        // TODO: odrzuć amountGr <= 0; jeśli brakuje środków -> InsufficientFundsException;
        //       w przeciwnym razie odejmij
        if (amountGr <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        if (balanceGr < amountGr) {
            throw new InsufficientFundsException(id, balanceGr, amountGr);
        }
        balanceGr -= amountGr;
    }

    public synchronized long getBalanceGr() {
        // TODO
        return balanceGr;
    }

    public Long getId() {
        return id;                          // pole final – synchronizacja niepotrzebna
    }
}

