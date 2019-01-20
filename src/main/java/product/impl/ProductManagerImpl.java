package product.impl;

import exception.OutOfStockException;
import product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductManagerImpl implements product.ProductManager {

    private static Map<String, Product> productMap = new HashMap<>();
    private static Map<Product, Integer> productQuantityMap = new HashMap<>();


    public ProductManagerImpl() {
        initialize();
    }


    public Product getProductByCode(String productCode) {
        return productMap.get(productCode);
    }

    private void initialize() {
        productMap.put("Coke", new Coke());
        productMap.put("Pepsi", new Pepsi());
        productMap.put("Water", new Water());

        productQuantityMap.put(new Coke(), 100);
        productQuantityMap.put(new Water(), 100);
        productQuantityMap.put(new Pepsi(), 100);

    }

    public String replenishStock(HashMap<Product, Integer> stockToReplenish) {
        for (Map.Entry<Product, Integer> entry : stockToReplenish.entrySet()) {
            productQuantityMap.put(entry.getKey(), productQuantityMap.get(entry.getKey()) + stockToReplenish.get(entry.getKey()));
        }
        return "Success";
    }


    public void issueStock(Product requestedProduct) throws OutOfStockException {
        if (productQuantityMap.get(requestedProduct) > 0) {
            productQuantityMap.put(requestedProduct, productQuantityMap.get(requestedProduct) - 1);
        } else {
            throw new OutOfStockException(requestedProduct.name() + " out of stock");
        }
    }

    public boolean isStockAvailable(Product requestedProduct) throws OutOfStockException {
        if (productQuantityMap.get(requestedProduct) > 0) {
            return true;
        } else {
            throw new OutOfStockException(requestedProduct.name() + " out of stock");
        }
    }


    public List<Product> listAvailableProducts() {
        List<Product> availableProducts = new ArrayList<>();
        for (Map.Entry<Product, Integer> product : productQuantityMap.entrySet()) {
            if (product.getValue() > 0) {
                availableProducts.add(product.getKey());
            }
        }
        return availableProducts;
    }

    private void persistTransactionRef(String transactionRef) {
        System.out.println(transactionRef);
    }

    private void logTransactionFailed(String transactionRef) {
        System.out.println(transactionRef);
    }
}
