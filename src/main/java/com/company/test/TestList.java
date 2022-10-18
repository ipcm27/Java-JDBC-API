package com.company.test;

import com.comapany.repository.ConnectionFactory;

import java.sql.*;

public class TestList {

    public static void main ( String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.connect();

        Statement stm = connection.createStatement();
         stm.execute("select ID,NAME,DESCRIPTION,PRICE FROM PRODUCT");

        ResultSet rst = stm.getResultSet();


        while(rst.next()){
            Integer id = rst.getInt("ID");
            System.out.println(id);
            String name = rst.getString("NAME");
            System.out.println(name);
            String description= rst.getString("DESCRIPTION");
            System.out.println(description);
            Long price = rst.getLong("PRICE");
            System.out.println(price);
        }
    }

}
