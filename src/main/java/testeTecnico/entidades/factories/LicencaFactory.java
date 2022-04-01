package testeTecnico.entidades.factories;

import java.util.Date;

import testeTecnico.entidades.Cliente;
import testeTecnico.entidades.Licenca;
import util.exceptions.DadosInvalidosException;

public class LicencaFactory {

	public static Licenca novaLicenca(Date dataInicio, Date dataValidade, Cliente cliente) {

		if(dataInicio == null)
			throw new DadosInvalidosException("Data de início da licenca não informada");

		if(dataValidade == null)
			throw new DadosInvalidosException("Data de validade da licenca não informada");

		if(dataValidade.before(dataInicio))
			throw new DadosInvalidosException("Data de validade não pode ser posterior a data de início");

		if(cliente == null || cliente.getId() == 0)
			throw new DadosInvalidosException("Cliente não informado, ou não registrado");

		Licenca licenca = new Licenca();
		licenca.setCliente(cliente);
		licenca.setDataInicio(dataInicio);
		licenca.setDataValidade(dataValidade);

		return licenca;
	}

}
