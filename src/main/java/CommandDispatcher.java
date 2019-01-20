import money.impl.Money;
import sale.VendingMchine;
import sale.impl.VendingMachineImpl;

import java.util.StringTokenizer;

public class CommandDispatcher {

    final static String DELIM = ",";
    static VendingMchine vendingMachine = new VendingMachineImpl();

    public void handleCompositeCommand(String commandString) {
        try {
            StringTokenizer tokenizer = new StringTokenizer(commandString, DELIM);
            while (tokenizer.hasMoreTokens()) {
                try {
                    dispatch(tokenizer.nextToken());
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();

        }
    }

    private void dispatch(String commandKey) throws IllegalArgumentException {

        switch (commandKey) {
            case "PE":
                vendingMachine.addCoin(Money.PENNY);
                break;
            case "NI":
                vendingMachine.addCoin(Money.NICKEL);
                break;
            case "DI":
                vendingMachine.addCoin(Money.DIME);
                break;
            case "QU":
                vendingMachine.addCoin(Money.QUARTER);
                break;
            case "D":
                vendingMachine.addBill(Money.DOLLAR);
                break;
            case "2D":
                vendingMachine.addBill(Money.TWO_DOLLAR);
                break;
            case "5D":
                vendingMachine.addBill(Money.FIVE_DOLLAR);
                break;
            case "10D":
                vendingMachine.addBill(Money.TEN_DOLLAR);
                break;
            case "20D":
                vendingMachine.addBill(Money.TWENTY_DOLLAR);
                break;
            case "50D":
                vendingMachine.addBill(Money.FIFTY_DOLLAR);
                break;
            case "100D":
                vendingMachine.addBill(Money.HUNDRED_DOLLAR);
                break;
            case "COKE":
                vendingMachine.selectProduct("Coke");
                vendingMachine.dispenseProduct();
                break;
            case "PEPSI":
                vendingMachine.selectProduct("Pepsi");
                vendingMachine.dispenseProduct();
                break;
            case "WATER":
                vendingMachine.selectProduct("Water");
                vendingMachine.dispenseProduct();
                break;
            case "CANCEL":
                vendingMachine.cancel();
                break;

            default:
                System.out.println("Invalid Input");
                throw new IllegalArgumentException();

        }

    }
}