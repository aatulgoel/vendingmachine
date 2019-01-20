package exception;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String transactionRef) {
        super(transactionRef);
    }
}
