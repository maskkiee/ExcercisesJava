package Excercises.TASK14.bank;

import java.util.concurrent.atomic.AtomicReference;

public class BankAccountAtomic {

    /** Niemutowalna migawka stanu konta. */
    private record Snapshot(long balanceGr, long version) {}

    private final AtomicReference<Snapshot> state;

    public BankAccountAtomic(long initialPln) {
        this.state = new AtomicReference<>(new Snapshot(initialPln * 100, 0));
    }

    public void deposit(long amountGr) {
        // TODO: jedna operacja updateAndGet – zbuduj nową migawkę na podstawie starej
        if (amountGr <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        state.updateAndGet(s -> new Snapshot(s.balanceGr + amountGr, s.version + 1));
    }

    /** @return true gdy wypłacono, false gdy brak środków. */
    public boolean tryWithdraw(long amountGr) {
        // TODO: ręczna pętla CAS
        //   1. odczytaj bieżącą migawkę
        //   2. jeśli brak środków -> return false
        //   3. zbuduj następną migawkę
        //   4. compareAndSet(bieżąca, następna): udało się -> return true;
        //      nie udało się -> ktoś cię wyprzedził, wróć do kroku 1
        if (amountGr <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        while (true) {
            Snapshot current = state.get();
            if (current.balanceGr < amountGr) {
                return false;
            }
            Snapshot next = new Snapshot(current.balanceGr() - amountGr, current.version() + 1);
            if (state.compareAndSet(current, next)) {
                return true;
            }
        }
    }

    public long balanceGr() {
        return state.get().balanceGr();
    }
}
