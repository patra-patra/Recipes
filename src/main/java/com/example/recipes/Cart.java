package com.example.recipes;

public class Cart {

    int prod_id;

    public Cart(int prod_id) {
        this.prod_id = prod_id;
    }

    public Cart() {
    }

    @Override
    public String toString() {
        return "Cart{" +
                "prod_id=" + prod_id +
                '}';
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }
}
