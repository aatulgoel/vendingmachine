package money;

import exception.CurrencyNotSupportedException;

import java.util.Map;

public interface MoneyManager {
    boolean addToWallet(Map<USCurrency, Integer> moneyFromSale) throws CurrencyNotSupportedException;

    void withdrawFromWallet(Map<USCurrency, Integer> unitsToWithdraw);
}
