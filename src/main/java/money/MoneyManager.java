package money;

import java.util.Map;

public interface MoneyManager {
    public boolean addToWallet(Map<USCurrency, Integer> moneyFromSale);

    public void withdrawFromWallet(Map<USCurrency, Integer> unitsToWithdraw);
}
