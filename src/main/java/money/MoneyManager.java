package money;

import java.util.Map;

public interface MoneyManager {
    boolean addToWallet(Map<USCurrency, Integer> moneyFromSale);

    void withdrawFromWallet(Map<USCurrency, Integer> unitsToWithdraw);
}
