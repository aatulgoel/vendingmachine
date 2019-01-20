package product.impl;

import product.Product;

import java.util.Objects;

public class Pepsi implements Product {
    private String name = "Pepsi";
    private Integer price = 120;

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
        Pepsi pepsi = (Pepsi) o;
        return Objects.equals(name, pepsi.name) &&
                Objects.equals(price, pepsi.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
