package com.alura.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {
	
public static void main(String[] args) throws SQLException {	
			
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		connection.setAutoCommit(false);
		
		try {
			PreparedStatement stm = connection.prepareStatement("INSERT INTO produto (nome, descricao) VALUES (? , ?)", Statement.RETURN_GENERATED_KEYS);
			
			
			adcionarVariavel("SmartTV","45 Polegadas", stm);
			adcionarVariavel("Radio","Radio de bateria", stm);	
			
			connection.commit();
					
			stm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("RollBack Executado");
			connection.rollback();
		}			
		
	}

private static void adcionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
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
