package com.company.services;

import com.comapany.repository.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ProductManager {

    private final Connection connection;
    private PreparedStatement preparedStatement;

    public ProductManager() throws SQLException {
        this.connection = ConnectionFactory.connect();
    }

    public void getAllProducts() throws SQLException {

        preparedStatement = connection.prepareStatement("select ID,NAME,DESCRIPTION,PRICE FROM PRODUCT");
        preparedStatement.execute();

        ResultSet rst =   preparedStatement.getResultSet();

        while(rst.next()){
            Integer id = rst.getInt("ID");
            System.out.println(id);
            String name = rst.getString("NAME");
            System.out.println(name);
            String description= rst.getString("DESCRIPTION");
            System.out.println(description);
            Long price = rst.getLong("PRICE");
            System.out.println(price);
            System.out.println("----------");
        }
    }

    public void createProduct(String name, String description, Long price) throws SQLException{
        // this.stm.execute("INSERT INTO PRODUCT (name, description,price) VALUES ('"+ name + "', '"+ description + " ',"+ price + ");", Statement.RETURN_GENERATED_KEYS);
        preparedStatement = connection.prepareStatement("INSERT INTO PRODUCT (name, description,price) VALUES(?,?,?)", preparedStatement.RETURN_GENERATED_KEYS );

        preparedStatement.setString(1,name);
        preparedStatement.setString(2,description);
        preparedStatement.setLong(3,price);

        preparedStatement.execute();

        ResultSet rst = preparedStatement.getGeneratedKeys();

        while(rst.next()){
            Integer id = rst.getInt(1);
            System.out.println("The created id was " + id);
        }


    }

    public void deleteProductFromId (int id) throws SQLException {
        preparedStatement = connection.prepareStatement("DELETE FROM PRODUCT WHERE id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        preparedStatement.getUpdateCount();

    }
}
