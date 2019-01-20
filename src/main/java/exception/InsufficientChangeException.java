package exception;

public class InsufficientChangeException extends Exception {
    public InsufficientChangeException(String transactionRef) {
        super(transactionRef);
    }

}
