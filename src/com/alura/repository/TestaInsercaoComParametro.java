package com.alura.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {
	
public static void main(String[] args) throws SQLException {
	
		String nome = "Geladeira";
		String descricao = "Geladeira Preta";		
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		
		//para evitar Sql injection, é muito importante usar o PrepareStatement, sendo assim NÂO usar Statement.
		
		PreparedStatement stm = connection.prepareStatement("INSERT INTO produto (nome, descricao) VALUES (? , ?)", Statement.RETURN_GENERATED_KEYS);
		
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		stm.execute();
		
		ResultSet rst = stm.getGeneratedKeys();
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id criado foi: " + id);
		}
		
	}

}
