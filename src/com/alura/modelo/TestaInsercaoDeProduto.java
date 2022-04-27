package com.alura.modelo;

import java.sql.Connection;
import java.sql.SQLException;

import com.alura.dao.ProdutoDao;
import com.alura.repository.ConnectionFactory;

/**
 * @author val
 *
 */
public class TestaInsercaoDeProduto {

	public static void main(String[] args) throws SQLException {

		Produto comoda = new Produto("Cômoda", "Cômoda Vertical");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			ProdutoDao produtoDao = new ProdutoDao(connection);
			produtoDao.salvar(comoda);
			
			//Lista = persistenciaProduto.listar();
			
		}

		System.out.println(comoda);

	}

}
