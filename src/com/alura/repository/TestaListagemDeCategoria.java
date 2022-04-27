package com.alura.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.alura.dao.CategoriaDao;
import com.alura.modelo.Categoria;
import com.alura.modelo.Produto;

public class TestaListagemDeCategoria {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {

			CategoriaDao categoriaDao = new CategoriaDao(connection);
			List<Categoria> listaDeCategoria = categoriaDao.listarComProduto();
			listaDeCategoria.stream().forEach(ct -> {
				System.out.println(ct.getNome());

				for (Produto produto : ct.getProdutos()) {
					System.out.println(ct.getNome() + " - " + produto.getNome());
				}

			});
		}

	}
}
