package testeTecnico.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Audited
@Entity
@Table(name="licenca")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Licenca {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private int id;

	@ManyToOne
    @JoinColumn
    @NotNull
    private Cliente cliente;

	@Column
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date dataInicio;

	@Column
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date dataValidade;

}
