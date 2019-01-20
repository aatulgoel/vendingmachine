package exception;

public class CurrencyNotSupportedException extends Exception {

    public CurrencyNotSupportedException(String transactionRef) {
        super(transactionRef);
    }

}
