package testeTecnico.entidades.factories;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import testeTecnico.entidades.Cliente;
import util.exceptions.DadosInvalidosException;

public class ClienteFactory {


	public static final String EMAIL_REGEX =
			"^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";

	private static CNPJValidator cnpjValidator = new CNPJValidator(false);

	public static Cliente novoCliente(String nome, String  cnpj, String email) {

		if(nome == null || nome.isEmpty())
			throw new DadosInvalidosException("Nome não pode ser vazio ou nulo");

		if(cnpj == null || cnpj.isEmpty())
			throw new DadosInvalidosException("CNPJ não pode ser vazio ou nulo");

		if(validarCnpj(cnpj))
			throw new DadosInvalidosException("Valor informado não é um cnpj válido");

		if(email == null || email.isEmpty())
			throw new DadosInvalidosException("Email não pode ser vazio ou nulo");

		if(!validarEmail(email))
			throw new DadosInvalidosException("Valor informado não é um formato válido de e-mail");

		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setCnpj(cnpj);
		cliente.setEmail(email);

		return cliente;

	}

	/**
	 * Verifica se email é válido, com base em EMAIL_REGEX;
	 * @param emails
	 */
	private static boolean validarEmail(String email) {
		if(email == null || email.isEmpty())
			return false;

		Pattern pattern = Pattern.compile(EMAIL_REGEX);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	private static boolean validarCnpj(String cnpj) {
		try {
			cnpjValidator.assertValid(cnpj);
			return true;
		} catch (InvalidStateException e) {
			return false;
		}
	}
}
