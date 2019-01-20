package exception;

public class UnidentifiedCurrencyException extends Exception {
    public UnidentifiedCurrencyException(String transactionRef) {
        super(transactionRef);
    }

}
