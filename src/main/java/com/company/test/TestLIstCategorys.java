package com.company.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.company.dao.CategoryDAO;
import com.company.model.Category;
import com.company.repository.ConnectionFactory;

public class TestLIstCategorys {
	
	public static void main (String[] args) throws SQLException {
		
		
		try(Connection connection = new ConnectionFactory().connect()){
			CategoryDAO categoryDAO = new CategoryDAO(connection);
			List<Category> listCategories = CategoryDAO.list();
			listCategories.stream().forEach(ct -> System.out.println(((Category) ct).getName()));
			
		}
	}

}
