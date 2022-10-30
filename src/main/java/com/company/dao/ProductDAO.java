package com.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.model.Product;
import com.company.repository.ConnectionFactory;

public class ProductDAO {
	
	private static Connection connection;
	private PreparedStatement preparedStatement;
	
	public void create(Product product) {
		
		try ( Connection connection = new ConnectionFactory().connect()){
	    	preparedStatement = connection.prepareStatement("INSERT INTO PRODUCT (name, description,price) VALUES(?,?,?)", preparedStatement.RETURN_GENERATED_KEYS );

	        preparedStatement.setString(1,product.getName());
	        preparedStatement.setString(2,product.getDescription());
	        preparedStatement.setLong(3,product.getPrice());

	        preparedStatement.execute();

	        ResultSet rst = preparedStatement.getGeneratedKeys();

	        while(rst.next()){
	        	// The parameter is the collumn index
	            Integer id = rst.getInt(1);
	            System.out.println("The created id was " + id);
	        }}
	    	catch (Exception ex) {
	    		System.out.println("Excpetion trying to connect to Db: " + ex);
	    	}
	}

	public void listAllOLd() throws SQLException {


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
	
	public static List<Product> listAll(){
		List<Product> products = new ArrayList<Product>();
		
		String sql = "select ID,NAME,DESCRIPTION,PRICE FROM PRODUCT";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()) {
				
				while(rst.next()) {
					Product product = new Product(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getLong(4));
					
					products.add(product);
					return products;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
		
	}


}
