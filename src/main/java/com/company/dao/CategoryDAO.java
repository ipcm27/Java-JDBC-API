package com.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.model.Category;
import com.company.model.Product;

public class CategoryDAO {
	
	private static Connection connection;
	
	
	public  CategoryDAO(Connection connection) {
		this.connection = connection;
	}
	
	public static List<Category> list(){
		List<Category> categorys = new ArrayList<>();
		String sql = "select * FROM category";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()) {
				
				while(rst.next()) {
					Category category = new Category(rst.getInt(1), rst.getString(2));
					
					
					categorys.add(category);
					return categorys;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categorys;
		
	}
	

}
