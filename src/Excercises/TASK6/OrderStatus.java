package Excercises.TASK6;

public enum OrderStatus {
    NEW,
    PROCESSING,
    SHIPPED,
    DELIVERED,
    CANCELED;

    public boolean isActive() {
        return this == DELIVERED || this == CANCELED;
    }
}
