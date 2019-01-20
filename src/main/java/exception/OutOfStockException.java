package exception;

public class OutOfStockException extends RuntimeException {
    public OutOfStockException(String transactionRef) {
        super(transactionRef);
    }
}
