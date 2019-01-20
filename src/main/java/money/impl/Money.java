package money.impl;


import money.USCurrency;

import java.util.*;

public class Money {


    public final static Coin PENNY = new Coin("Penny", 1);
    public final static Coin NICKEL = new Coin("Nickel", 5);
    public final static Coin DIME = new Coin("Dime", 10);
    public final static Coin QUARTER = new Coin("Quarter", 25);
    public final static Bill DOLLAR = new Bill("Dollar", 1, 100);
    public final static Bill TWO_DOLLAR = new Bill("TwoDollar", 2, 200);
    public final static Bill FIVE_DOLLAR = new Bill("FiveDollar", 5, 500);
    public final static Bill TEN_DOLLAR = new Bill("TenDollar", 10, 1000);
    public final static Bill TWENTY_DOLLAR = new Bill("TwentyDollar", 20, 2000);
    public final static Bill FIFTY_DOLLAR = new Bill("FiftyDollar", 50, 5000);
    public final static Bill HUNDRED_DOLLAR = new Bill("HundredDollar", 100, 10000);

    final static List<USCurrency> moneyInDescOrder = new ArrayList<>(Arrays.asList(HUNDRED_DOLLAR, FIFTY_DOLLAR,
            TWENTY_DOLLAR, TEN_DOLLAR, FIVE_DOLLAR, DOLLAR, QUARTER, DIME, NICKEL, PENNY));
    final static Set<String> acceptableCurrencyNames = new HashSet<>(Arrays.asList(
            HUNDRED_DOLLAR.currencyName(),
            FIFTY_DOLLAR.currencyName(),
            TWENTY_DOLLAR.currencyName(),
            TEN_DOLLAR.currencyName(),
            FIVE_DOLLAR.currencyName(),
            DOLLAR.currencyName(),
            QUARTER.currencyName(),
            DIME.currencyName(),
            NICKEL.currencyName(),
            PENNY.currencyName()));

    public static boolean isValidCurrency(String currencyName) {
        return acceptableCurrencyNames.contains(currencyName);
    }


}
