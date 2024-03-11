package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFuncionario;
	
	@NotBlank(message = "Erro campo vazio")
	private String Nome;
	
	@NotNull(message = "Erro campo vazio")
	private int Idade;
	
	@NotNull(message = "Erro campo vazio")
	private int Matricula;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("cliente")
	private Funcionario funcionario;
	
	@ManyToMany
	@JoinTable(
			name = "funcionario_venda",
			joinColumns = @JoinColumn(name = "IdFuncionario"),
			inverseJoinColumns = @JoinColumn(name = "IdVenda")
			)
	private List<Venda>venda;
}
