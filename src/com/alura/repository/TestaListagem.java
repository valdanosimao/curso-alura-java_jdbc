package com.alura.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestaListagem {
	
	public static void main(String[] args) throws SQLException {
		
	     Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC",
	    		 "valdano","3213");	      
	     
	     Statement stm = connection.createStatement();
	     stm.execute("select ID, NOME, DESCRICAO FROM produto");
	     
	     ResultSet rst = stm.getResultSet();
	     
	     while(rst.next()) {
	    	 Integer id = rst.getInt("ID");
	    	 System.out.println(id);
	    	 
	    	 String nome = rst.getString("NOME");
	    	 System.out.println(nome);
	    	 
	    	 String descricao = rst.getString("DESCRICAO");
	    	 System.out.println(descricao);
	    	 
	     }

	        connection.close();
	    }
		 
		
	}


