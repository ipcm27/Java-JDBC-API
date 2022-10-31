package com.company.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.company.dao.CategoryDAO;
import com.company.dao.ProductDAO;
import com.company.model.Category;
import com.company.model.Product;
import com.company.repository.ConnectionFactory;

public class TestLIstCategorys {
	
	public static void ListCategorys(Connection connection) {
		
			CategoryDAO categoryDAO = new CategoryDAO(connection);
			List<Category> listCategories = CategoryDAO.list();
			listCategories.stream().forEach(ct -> System.out.println(((Category) ct).getName()));
			
		
	}
	
	public static void ListProducts(Connection connection) {
		
		ProductDAO productDAO = new ProductDAO(connection);
		List<Product> listProduct = productDAO.list();
		listProduct.stream().forEach(ct -> System.out.println(((Product) ct).getName()));
		
	
}
	
	
	
	public static void main (String[] args) throws SQLException {
		
		Connection connection = new ConnectionFactory().connect();
		
	
		ListProducts(connection);	
		ListCategorys(connection);
		
		
		
		
	}

}
