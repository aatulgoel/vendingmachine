package product.impl;

import product.Product;

import java.util.Objects;

public class Water implements Product {
    private String name = "Water";
    private Integer price = 150;

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
        Water water = (Water) o;
        return Objects.equals(name, water.name) &&
                Objects.equals(price, water.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
