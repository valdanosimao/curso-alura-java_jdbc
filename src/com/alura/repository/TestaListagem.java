package com.alura.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection connection = criaConexao.recuperarConexao();

		PreparedStatement stm = connection.prepareStatement("select ID, NOME, DESCRICAO FROM produto");
		stm.execute();

		ResultSet rst = stm.getResultSet();

		while (rst.next()) {
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
