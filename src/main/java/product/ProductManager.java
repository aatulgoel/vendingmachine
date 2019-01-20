package product;

import exception.OutOfStockException;

import java.util.HashMap;

public interface ProductManager {
    public String replenishStock(HashMap<Product, Integer> stockToReplenish, String transactionRef);

    public void issueStock(Product requestedProduct) throws OutOfStockException;


}
