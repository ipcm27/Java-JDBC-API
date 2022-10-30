package com.company.test;

import com.company.services.ProductManager;

import java.sql.SQLException;

public class TestServices {

    public static void main(String[] args) throws SQLException {
        ProductManager manager = new ProductManager();

        //  manager.createProduct("Home Connecta Flexi 100GB","50 GBAnytime Data, 50 GBNite Data, 30 Day Validity", 199L);

        //manager.deleteProductFromId(7);
        manager.getAllProducts();

    }
}
