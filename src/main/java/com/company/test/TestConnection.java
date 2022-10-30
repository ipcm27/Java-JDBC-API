package com.company.test;


import java.sql.Connection;
import java.sql.SQLException;

import com.company.repository.ConnectionFactory;

public class TestConnection {

    public static void main ( String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.connect();

        System.out.println("Fechando a conexão");

        connection.close();

    }
}
