package exception;

public class NoSuchOrderException extends RuntimeException {
    public NoSuchOrderException(String transactionRef) {
        super(transactionRef);
    }

}
