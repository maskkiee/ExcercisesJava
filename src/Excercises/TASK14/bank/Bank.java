package Excercises.TASK14.bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    //Bank może trzymać konta w zwykłej HashMapie, bo konta zakładane są raz, jednym wątkiem,
    //zanim w ogóle wątki zostaną przydzielone. Późniejsze operacje tylko wczytują dane.
    // TODO: struktura danych przechowująca konta, dostępna po id
    //       (wybór struktury jest częścią zadania – patrz "Co jest czym")
    private final Map<Long, BankAccount> accounts = new HashMap<>();

    public void openAccount(long id, long initialPln) {
        // TODO
        accounts.put(id, new BankAccount(id, initialPln));
    }

    /**
     * Atomowy przelew: albo obie strony, albo żadna. NIE może się zakleszczyć.
     */
    public void transfer(long fromId, long toId, long amountGr) {
        // TODO
        if (fromId == toId) {
            throw new IllegalArgumentException("Przelew na to samo konto: " + fromId);
        }
        BankAccount from = accounts.get(fromId);
        BankAccount to = accounts.get(toId);

        BankAccount first = from.getId() <= to.getId() ? from : to;
        BankAccount second = from.getId() <= to.getId() ? to : from;
        synchronized (first) {
            synchronized (second) {
                from.withdraw(amountGr);
                to.deposit(amountGr);
            }
        }
    }

    /**
     * Suma sald wszystkich kont w groszach.
     */
    public long totalBalanceGr() {
        // TODO
        long total = 0;
        for (BankAccount account : accounts.values()) {
            total += account.getBalanceGr();
        }
        return total;
    }

    public BankAccount get(long id) {
        return accounts.get(id);
    }

    public int size() {
        return accounts.size();
    }
}