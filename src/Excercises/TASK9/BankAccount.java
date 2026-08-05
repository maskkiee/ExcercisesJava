package Excercises.TASK9;

final class BankAccount {
    private int balance;

    public BankAccount(int initial) {
        this.balance = initial;
    }

    public void withdraw(int amount) throws InsufficientFundsException {
        if (balance < amount) {
            throw new InsufficientFundsException("Insufficient Funds. Balance: " + balance + ". Trying to withdraw: " + amount);
        } else {
            balance -= amount;
            System.out.println("Withdraw successful.");
        }
    }
}