package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Produto;
import app.entity.Venda;
import app.repository.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	public VendaRepository vendaRepository;

	public List<Venda> findAll() {
		return this.vendaRepository.findAll();
	}

	public Venda findById(long id) {
		return this.vendaRepository.findById(id).get();
	}

	public void save(Venda venda) {
		venda.setValor(calcularValorTotal(venda.getProdutos()));
		this.vendaRepository.save(venda);
	}

	public void update(long id, Venda venda) {
		venda.setIdVenda(id);
		venda.setValor(calcularValorTotal(venda.getProdutos()));
		venda = verificarStatus(venda);
		this.vendaRepository.save(venda);
	}

	public String delete(long id) {
		String idString = Integer.toString((int) id);
		this.vendaRepository.deleteById(id);
		return idString;
	}

	public List<Venda> findByClienteNome(String clienteNome) {
		return this.vendaRepository.findByClienteNome(clienteNome);
	}

	public List<Venda> findByFuncionarioNome(String funcionarioNome) {
		return this.vendaRepository.findByFuncionarioNome(funcionarioNome);
	}

	public List<Venda> findByValorMaior(double valor) {
		return this.vendaRepository.findByValorMaior(valor);
	}

	public List<Venda> findByProdutos(long id) {
		Produto produto = new Produto();
		produto.setIdProduto(id);
		return this.vendaRepository.findByProdutos(produto);
	}

	public double calcularValorTotal(List<Produto> produtos) {
		double valorTotal = 0;
		for(Produto produto : produtos) {
			valorTotal += produto.getValor();
		}
		return valorTotal;
	}
	
	public Venda verificarStatus(Venda venda) {
		if(venda.getStatus().equalsIgnoreCase("CANCELADO")) {
			venda.setProdutos(null);
			venda.setValor(0);
		}
		return venda;
	}
	
	

}
