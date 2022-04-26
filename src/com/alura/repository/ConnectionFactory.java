package com.alura.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//nome padrão para uma classe de conexão 'ConnectionFactory' Fornecer uma maneira mais simples para criar um objeto
public class ConnectionFactory { 
	
	public Connection recuperarConexao() throws SQLException {
		return DriverManager.getConnection
				("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC",
	    		 "valdano","3213");
		
	}

}
