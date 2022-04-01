package testeTecnico.entidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Audited
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cliente {

	public static final String EMAIL_REGEX = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private int id;

	@NotNull
    @NotBlank
    @NotEmpty
    @Size(max=120)
    @Column(length=120)
    private String nome;

	@NotNull
    @NotBlank
    @NotEmpty
	@Column(length = 14)
    private String cnpj;

	@NotNull
    @NotBlank
    @NotEmpty
	@Column(length = 80)
    private String email;

	/**
	 * Verifica se email é válido, com base em EMAIL_REGEX;
	 * @param email
	 */
	public boolean validarEmail(String email) {
		if(email == null || email.isEmpty())
			return false;

		Pattern pattern = Pattern.compile(EMAIL_REGEX);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

}
