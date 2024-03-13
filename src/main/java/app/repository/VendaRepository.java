package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Produto;
import app.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{
	public List<Venda> findByClienteNome(String nome);
	public List<Venda> findByFuncionarioNome(String nome);
	@Query("SELECT v FROM Venda v WHERE v.valor > :valor")
	public List<Venda> findByValorMaior(double valor);
	public List<Venda> findByProdutos(Produto produto);
}
