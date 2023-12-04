package com.example.recipes;
import java.util.List;
public class Test {
    public static void main(String[] args) {



        Product product = Database.searchProduct("паddd");
        System.out.println(product);
        Database.addProduct("sss", 1,1,1,1,1);

    }
}
