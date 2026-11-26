package Excercises.TASK14.bank;

public class InsufficientFundsException extends RuntimeException {
  public InsufficientFundsException(Long accountId, long balanceGr, long requestedGr) {
    super("Insufficient Funds " + accountId + ": saldo " + balanceGr + " gr < requested " + requestedGr + " gr");
  }
}
