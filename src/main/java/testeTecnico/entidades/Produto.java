package testeTecnico.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Produto {

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

	@ManyToOne
    @JoinColumn
    @NotNull
    private Cliente cliente;

}
