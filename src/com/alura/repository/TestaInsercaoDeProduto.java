package com.alura.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.alura.dao.ProdutoDao;
import com.alura.modelo.Produto;

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
			
			List<Produto> listaDeProdutos = produtoDao.listar();
			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
		}

		System.out.println(comoda);

	}

}
