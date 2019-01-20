package product.impl;

import product.Product;

import java.util.Objects;

public class Coke implements Product {
    private String name = "Coke";
    private Integer price = 65;

    public String name() {
        return name;
    }

    public Integer price() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coke coke = (Coke) o;
        return Objects.equals(name, coke.name) &&
                Objects.equals(price, coke.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
