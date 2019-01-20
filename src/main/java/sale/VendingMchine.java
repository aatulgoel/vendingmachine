package sale;

import money.impl.Bill;
import money.impl.Coin;
import product.Product;

import java.util.List;

public interface VendingMchine {
    List<Product> listAvailableProducts();

    boolean addCoin(Coin coin);

    boolean addBill(Bill bill);

    boolean cancel();

    boolean dispenseProduct();

    boolean selectProduct(String productCode);


}
