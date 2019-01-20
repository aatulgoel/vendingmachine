package exception;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String transactionRef) {
        super(transactionRef);
    }
}
