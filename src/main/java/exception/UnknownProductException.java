package exception;

public class UnknownProductException extends RuntimeException {
    public UnknownProductException(String transactionRef) {
        super(transactionRef);
    }
}
