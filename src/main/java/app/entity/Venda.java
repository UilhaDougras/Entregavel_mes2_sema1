package app.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idVenda;
	
	@NotBlank(message = "Erro campo vazio")
	private String endereco;
	
	@NotNull(message = "Erro campo vazio")
	private double valor;
	
	@ManyToMany
	@JoinTable(
			name = "venda_produto", 
			joinColumns = @JoinColumn(name = "IdVenda"),
			inverseJoinColumns = @JoinColumn(name = "IdProduto")
			)
	private List<Produto>produto;
}
