package com.alura.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {
	
	 public static void main(String[] args) throws SQLException {

	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTomezone=UTC", "valdano","3213");
	        
	        System.out.println("Fechando conexão!!");

	        connection.close();
	    }

}
