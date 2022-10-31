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
					
				}return categorys;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categorys;
		
	}
	
	public List <Category> listWithProduct() throws SQLException {
		Category last = null;
		List<Category> categories = new ArrayList<>();
		
		String sql = "SELECT C.ID, C.NAME, P.ID, P.NAME, P.DESCRIPTION FROM CATEGORY C INNER JOIN PRODUCT P ON C.ID = P.CATEGORY_ID";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()){
				while(rst.next()) {
					if(last == null || !last.getName().equals(rst.getString(2))) {
						Category category = new Category(rst.getInt(1), rst.getString(2));
						
						categories.add(category);
						last = category;
					}
				}
				return categories;
			}
		}
		
	}
		};

