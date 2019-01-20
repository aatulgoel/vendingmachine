package money.impl;


import exception.CurrencyNotSupportedException;
import exception.InsufficientChangeException;
import money.USCurrency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoneyManagerImpl implements money.MoneyManager {
    static final Logger LOG = LoggerFactory.getLogger(MoneyManagerImpl.class);
    private Map<USCurrency, Integer> moneyWallet = new HashMap<>();

    public MoneyManagerImpl() {
        initialize();
    }

    private void initialize() {
        moneyWallet.put(Money.PENNY, 10000);
        moneyWallet.put(Money.NICKEL, 10000);
        moneyWallet.put(Money.DIME, 10000);
        moneyWallet.put(Money.QUARTER, 5000);
        moneyWallet.put(Money.DOLLAR, 100);
        moneyWallet.put(Money.TWO_DOLLAR, 100);
        moneyWallet.put(Money.FIVE_DOLLAR, 50);
        moneyWallet.put(Money.TEN_DOLLAR, 20);
        moneyWallet.put(Money.TWENTY_DOLLAR, 10);
        moneyWallet.put(Money.FIFTY_DOLLAR, 0);
        moneyWallet.put(Money.HUNDRED_DOLLAR, 0);
    }

    public boolean addToWallet(USCurrency currency) throws CurrencyNotSupportedException {
        if (!moneyWallet.containsKey(currency)) {
            throw new CurrencyNotSupportedException("Currency not supported");
        }
        moneyWallet.put(currency, moneyWallet.get(currency) + 1);
        return true;
    }

    public boolean addToWallet(Map<USCurrency, Integer> moneyFromSale) throws CurrencyNotSupportedException {
        for (USCurrency key : moneyFromSale.keySet()) {
            if (!moneyWallet.containsKey(key)) {
                throw new CurrencyNotSupportedException("Currency not supported");
            }
        }

        for (Map.Entry<USCurrency, Integer> entry : moneyFromSale.entrySet()) {
            moneyWallet.put(entry.getKey(), moneyWallet.get(entry.getKey()) + entry.getValue());
        }
        return true;
    }

    public void withdrawFromWallet(Map<USCurrency, Integer> unitsToWithdraw) {

        for (Map.Entry<USCurrency, Integer> entry : unitsToWithdraw.entrySet()) {
            moneyWallet.put(entry.getKey(), moneyWallet.get(entry.getKey()) - unitsToWithdraw.get(entry.getKey()));
        }
    }

    public Map<USCurrency, Integer> getChangeDenominations(int moneyToRefund) throws InsufficientChangeException {
        int unitsOfCurrencyRequired;
        int unitsOfCurrencyAvialable;
        List<USCurrency> currencyInDescOrder = Money.moneyInDescOrder;
        Map<USCurrency, Integer> unitsToWithdraw = new HashMap<>();

        for (USCurrency currency : currencyInDescOrder) {
            if (currency.pennyValue() <= moneyToRefund && checkCashExists(currency)) {
                unitsOfCurrencyRequired = moneyToRefund / currency.pennyValue();
                unitsOfCurrencyAvialable = moneyWallet.get(currency);
                if (unitsOfCurrencyRequired < unitsOfCurrencyAvialable) {
                    unitsToWithdraw.put(currency, unitsOfCurrencyRequired);
                    moneyToRefund = moneyToRefund - currency.pennyValue() * unitsOfCurrencyRequired;
                } else {
                    unitsToWithdraw.put(currency, unitsOfCurrencyAvialable);
                    moneyToRefund = moneyToRefund - currency.pennyValue() * unitsOfCurrencyAvialable;
                }
            }

        }
        if (moneyToRefund > 0) {
            throw new InsufficientChangeException("Providing exact change not possible");
        }
        return unitsToWithdraw;

    }


    private void persistTransactionRef(String transactionRef) {
        System.out.println(transactionRef);
    }

    private void logTransactionFailed(String transactionRef) {
        System.out.println(transactionRef);
    }


    private boolean checkCashExists(USCurrency usCurrency) {
        return (moneyWallet.get(usCurrency) > 0);
    }
}
