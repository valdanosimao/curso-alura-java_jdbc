package com.alura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alura.modelo.Categoria;
import com.alura.modelo.Produto;

public class ProdutoDao {

	public Connection connection;

	public ProdutoDao(Connection connection) {
		this.connection = connection;
	}

	/**
	 * Método que salvar um produto
	 * @param produto
	 * @throws SQLException
	 */
	public void salvar(Produto produto) throws SQLException {
		String sql = "INSERT INTO produto (NOME, DESCRICAO) VALUES (?, ?)";

		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());

			pstm.execute();

			try (ResultSet rst = pstm.getGeneratedKeys()) {
				while (rst.next()) {
					produto.setId(rst.getInt(1));
				}
			}
		}
	}

	/**
	 * Método que lista os produtos
	 */
	public List<Produto> listar() throws SQLException {
		List<Produto> produtos = new ArrayList<>();

		String sql = "SELECT ID, NOME, DESCRICAO FROM produto";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();

			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));

					produtos.add(produto);
				}
			}
		}
		return produtos;
	}

	public List<Produto> buscar(Categoria ct) throws SQLException {
		
		List<Produto> produtos = new ArrayList<>();

		String sql = "SELECT ID, NOME, DESCRICAO FROM produto WHERE CATEGORIA_ID = ?";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, ct.getId());
			pstm.execute();

			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));

					produtos.add(produto);
				}
			}
		}
		return produtos;
		
		
	}

}
