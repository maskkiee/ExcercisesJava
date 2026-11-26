package Excercises.TASK6;

public enum Currency {
    PLN("zł"),
    USD("$"),
    EUR("€");

private final String symbol;

private Currency(String symbol) {
    this.symbol = symbol;
}

public String getSymbol() {
    return this.symbol;
}

}
