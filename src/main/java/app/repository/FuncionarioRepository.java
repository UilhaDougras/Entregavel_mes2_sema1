package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Funcionario;
import app.entity.Venda;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	public List<Funcionario> findByVenda(Venda venda);
	
	public List<Funcionario> findByNome(String nome);
	
	public List<Funcionario> findByIdade(int idade);
	
	public List<Funcionario> findByMatricula(int matricula);
	
	@Query("SELECT f"
			+ "FROM Funcionario f"
			+ "WHERE f.nome > :matricula")
	public List<Funcionario> findMatriculaNome(int matricula);
}
