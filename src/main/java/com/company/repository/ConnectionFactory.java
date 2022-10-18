package com.comapany.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/CELLC_TEST?useTimeZOne=true&serverTimeZOne=UTC", "root", "admin12345");

    }


}
