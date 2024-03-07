package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Produto;
import app.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
	@Autowired
	public ProdutoService produtoService;
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Produto>> findAll(){
		try {
			return new ResponseEntity<List<Produto>>(this.produtoService.findAll(), HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
