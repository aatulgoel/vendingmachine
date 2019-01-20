package exception;

public class OutOfStockException extends Exception {
    public OutOfStockException(String transactionRef) {
        super(transactionRef);
    }
}
