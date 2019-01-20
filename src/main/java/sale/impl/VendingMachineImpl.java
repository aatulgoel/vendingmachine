package sale.impl;

import exception.InsufficientChangeException;
import exception.OutOfStockException;
import money.USCurrency;
import money.impl.Bill;
import money.impl.Coin;
import money.impl.Money;
import money.impl.MoneyManagerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import product.Product;
import product.impl.ProductManagerImpl;
import sale.VendingMchine;

import java.util.List;
import java.util.Map;

public class VendingMachineImpl implements VendingMchine {

    static final Logger LOG = LoggerFactory.getLogger(VendingMachineImpl.class);
    Order order;
    ProductManagerImpl productManager = new ProductManagerImpl();
    MoneyManagerImpl moneyManager = new MoneyManagerImpl();

    public List<Product> listAvailableProducts() {
        return productManager.listAvailableProducts();
    }

    public boolean addCoin(Coin coin) {
        if (order == null) {
            order = new Order();
        }
        if (Money.isValidCurrency(coin.currencyName())) {
            order.setPayment(coin.pennyValue());
            moneyManager.addToWallet(coin);
            display("Balance = " + order.getPayment());
            return true;
        } else {
            display("Invalid Coin");
            return false;
        }
    }

    public Order getOrder() {
        return order;
    }

    public boolean addBill(Bill bill) {
        if (order == null) {
            order = new Order();
        }
        if (Money.isValidCurrency(bill.currencyName())) {
            order.setPayment(bill.pennyValue());
            moneyManager.addToWallet(bill);
            display("Balance = " + order.getPayment());
            return true;
        } else {
            display("Invalid Bill");
            return false;
        }
    }


    public boolean cancel() {
        Map<USCurrency, Integer> changeMap;
        if (order == null) {
            display("No Order to Cancel");
            return false;
        } else {
            // Order Cleanup
            changeMap = moneyManager.getChangeDenominations(order.getPayment());
            dispenseCash(changeMap);
            order = null;
            return true;
        }

    }

    public boolean dispenseProduct() {
        if (order.getProductCode() != null) {
            Product product = productManager.getProductByCode(order.getProductCode());
            Map<USCurrency, Integer> changeMap;
            if (order.getPayment() >= product.price()) {
                try {
                    if ((productManager.isStockAvailable(product))) {
                        changeMap = moneyManager.getChangeDenominations(order.getPayment() - product.price());
                        productManager.issueStock(product);
                        display("Please collect " + product.name() + " from tray");
                        if (changeMap != null) {
                            for (Map.Entry<USCurrency, Integer> entry : changeMap.entrySet()) {
                                display("Please collect change " + entry.getKey().currencyName() + " " + entry.getValue());
                            }
                        }
                        order = null;

                    }
                } catch (OutOfStockException e) {
                    display("Product of of stock, choose another product or cancel");
                    return false;
                } catch (InsufficientChangeException e) {
                    display("Exact change cannot be given, choose another product or cancel");
                    return false;
                }
            } else {
                display("Please add funds to get product");
                return false;
            }
            return true;
        } else {
            display("Please select product");
            return false;
        }
    }

    boolean dispenseCash(Map<USCurrency, Integer> changeMap) {
        for (Map.Entry<USCurrency, Integer> entry : changeMap.entrySet()) {
            display("Please collect change " + entry.getKey().currencyName() + " " + entry.getValue());
        }
        return true;
    }


    public boolean selectProduct(String productCode) {
        order.setProductCode(productCode);
        return true;
    }

    void display(String displayMessge) {
        LOG.info(displayMessge);


    }
}
