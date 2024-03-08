package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Produto;
import app.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	public ProdutoRepository produtoRepository;

	public List<Produto> findAll() {
		return this.produtoRepository.findAll();
	}

	public Produto findById(long id) {
		// TODO Auto-generated method stub
		return this.produtoRepository.findById(id).get();
	}

	public void save(Produto produto) {
		this.produtoRepository.save(produto);
	}
	
}
