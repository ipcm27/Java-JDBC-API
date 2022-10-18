package com.company.test;

import com.comapany.repository.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

    public static void main ( String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.connect();

        System.out.println("Fechando a conexão");

        connection.close();

    }
}
