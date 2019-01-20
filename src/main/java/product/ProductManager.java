package product;

import exception.OutOfStockException;

import java.util.HashMap;

public interface ProductManager {
    String replenishStock(HashMap<Product, Integer> stockToReplenish);

    void issueStock(Product requestedProduct) throws OutOfStockException;


}
