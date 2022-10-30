package com.company.repository;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public DataSource datasource;


    // got erros depois de implemnetar o pool de conexoes. Deixo pra ver depois
    public ConnectionFactory(){
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/CELLC_TEST?useTimeZOne=true&serverTimeZOne=UTC");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("admin12345");

        this.datasource = comboPooledDataSource;
    };

    public Connection connect() throws SQLException {
        // return DriverManager.getConnection("jdbc:mysql://localhost/CELLC_TEST?useTimeZOne=true&serverTimeZOne=UTC", "root", "admin12345");
        return this.datasource.getConnection();

    }


}
