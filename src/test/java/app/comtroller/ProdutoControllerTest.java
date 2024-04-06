package app.comtroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import app.controller.ProdutoController;
import app.entity.Produto;
import app.entity.Venda;
import app.repository.ProdutoRepository;

@SpringBootTest

public class ProdutoControllerTest {

	@Autowired
	ProdutoController	produtoController;
	
	@MockBean
	ProdutoRepository produtoRepository;
	
	@BeforeEach
	void setup() {
		List<Produto> lista = new ArrayList<Produto>();
		for(int i=0; i<3;i++) {
			lista.add(new Produto((long) i, "nome", 0));		
		}
		
		when(this.produtoRepository.findAll()).thenReturn(lista);
		when(this.produtoRepository.findById((long) 1)).thenReturn(Optional.of(lista.get(1)));
		when(this.produtoRepository.save(lista.get(1))).thenReturn(lista.get(1));
		when(this.produtoRepository.findByPodutoValor(1)).thenReturn(lista);
	}
	
	@Test
	@DisplayName("Teste de findAll() OK em Produto")
	void findAllOk() {
		ResponseEntity<List<Produto>> response = this.produtoController.findAll();
		List<Produto> lista = response.getBody();
		assertEquals(3, lista.size());
	}
	
	@Test
	@DisplayName("Teste de findById() OK em Produto")
	void findByIdOk() {
		ResponseEntity<Produto> response = this.produtoController.findById(1);
		Produto produto = response.getBody();
		assertEquals(1, produto.getIdProduto());
	}
	
	@Test
	@DisplayName("Teste de save() OK em Produto")
	void saveOk() {
		Produto produto = new Produto(0, "nome", 0);
		ResponseEntity<String> response = this.produtoController.save(produto);
		int httpStatus = response.getStatusCode().value();
		assertEquals(201, httpStatus);
	}
	
	@Test
	@DisplayName("Teste de update() OK em Produto")
	void updateOk() {
		Produto produto = new Produto(0,"nome 1", 0);
		ResponseEntity<String> response = this.produtoController.update(1, produto);
		int httpStatus = response.getStatusCode().value();
		assertEquals(200, httpStatus);
	}
	
	@Test
	@DisplayName("Teste de delete() OK em Produto")
	void deleteOk() {
		ResponseEntity<String> response = this.produtoController.delete(1);
		int httpStatus = response.getStatusCode().value();
		assertEquals(200, httpStatus);
	}
	
	@Test
	@DisplayName("Teste de findByPodutoValor() OK em Produto")
	void findByNomeOk() {
		ResponseEntity<List<Produto>> response = this.produtoController.findByPodutoValor(1);
		int httpStatus = response.getStatusCode().value();
		assertEquals(200, httpStatus);
	}
	
}
