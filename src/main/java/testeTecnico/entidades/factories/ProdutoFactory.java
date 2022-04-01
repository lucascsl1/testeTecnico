package testeTecnico.entidades.factories;

import testeTecnico.entidades.Cliente;
import testeTecnico.entidades.Produto;
import util.exceptions.DadosInvalidosException;

public class ProdutoFactory {

	public static Produto novoProduto(String nome, Cliente cliente) {

		if(nome == null || nome.isEmpty())
			throw new DadosInvalidosException("Nome não pode ser vazio ou nulo");

		if(cliente == null || cliente.getId() == 0)
			throw new DadosInvalidosException("Cliente não informado, ou não registrado");

		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setCliente(cliente);

		return produto;
	}

}
