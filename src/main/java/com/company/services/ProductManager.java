package com.company.services;

import com.company.dao.ProductDAO;
import com.company.model.Product;
import com.company.repository.ConnectionFactory;


import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;



import java.sql.ResultSet;

public class ProductManager {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ProductDAO productDAO;

  

    public void getAllProducts() throws SQLException {
    	try{
			productDAO.listAll();
			
		}
		catch(Exception e) {
			System.out.println("trying to get on the service.Got exception: " + e);
			
		}

     
    }

    public Product createProduct(Product product) throws SQLException{
        // this.stm.execute("INSERT INTO PRODUCT (name, description,price) VALUES ('"+ name + "', '"+ description + " ',"+ price + ");", Statement.RETURN_GENERATED_KEYS);
        
    		try{
    			productDAO.create(product);
    			return product;
    		}
    		catch(Exception e) {
    			System.out.println("trying to get on the service.Got exceptio:" + e);
    			return product;
    		}
    	

    }

    public void deleteProductFromId (int id) throws SQLException {
        preparedStatement = connection.prepareStatement("DELETE FROM PRODUCT WHERE id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        preparedStatement.getUpdateCount();
    }
}
