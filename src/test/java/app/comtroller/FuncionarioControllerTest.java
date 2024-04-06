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

import app.controller.FuncionarioController;
import app.entity.Funcionario;
import app.entity.Venda;
import app.repository.FuncionarioRepository;

@SpringBootTest

public class FuncionarioControllerTest {

	@Autowired
	FuncionarioController	funcionarioController;
	
	@MockBean
	FuncionarioRepository funcionarioRepository;
	
	@BeforeEach
	void setup() {
		List<Funcionario> lista = new ArrayList<Funcionario>();
		for(int i=0; i<3;i++) {
			lista.add(new Funcionario((long) i, "nome", 0, 0, new ArrayList<Venda>()));		
		}
		
		when(this.funcionarioRepository.findAll()).thenReturn(lista);
		when(this.funcionarioRepository.findById((long) 1)).thenReturn(Optional.of(lista.get(1)));
		when(this.funcionarioRepository.save(lista.get(1))).thenReturn(lista.get(1));
		when(this.funcionarioRepository.findByNome("funcionario 1")).thenReturn(lista);
		when(this.funcionarioRepository.findByMatricula(1)).thenReturn(lista);
		when(this.funcionarioRepository.findByIdade(1)).thenReturn(lista);
	}
	
	@Test
	@DisplayName("Teste de findAll() OK em Funcionario")
	void findAllOk() {
		ResponseEntity<List<Funcionario>> response = this.funcionarioController.findAll();
		List<Funcionario> lista = response.getBody();
		assertEquals(3, lista.size());
	}
	
	@Test
	@DisplayName("Teste de findById() OK em Funcionario")
	void findByIdOk() {
		ResponseEntity<Funcionario> response = this.funcionarioController.findById(1);
		Funcionario funcionario = response.getBody();
		assertEquals(1, funcionario.getIdFuncionario());
	}
	
	@Test
	@DisplayName("Teste de save() OK em Funcionario")
	void saveOk() {
		Funcionario funcionario = new Funcionario(0, "nome", 0, 0, new ArrayList<Venda>());
		ResponseEntity<String> response = this.funcionarioController.save(funcionario);
		int httpStatus = response.getStatusCode().value();
		assertEquals(201, httpStatus);
	}
	
	@Test
	@DisplayName("Teste de update() OK em Funcionario")
	void updateOk() {
		Funcionario funcionario = new Funcionario(0,"nome 1", 0, 0,  new ArrayList<Venda>());
		ResponseEntity<String> response = this.funcionarioController.update(1, funcionario);
		int httpStatus = response.getStatusCode().value();
		assertEquals(200, httpStatus);
	}
	
	@Test
	@DisplayName("Teste de delete() OK em Funcionario")
	void deleteOk() {
		ResponseEntity<String> response = this.funcionarioController.delete(1);
		int httpStatus = response.getStatusCode().value();
		assertEquals(200, httpStatus);
	}
	
	@Test
	@DisplayName("Teste de findByNome() OK em Funcionario")
	void findByNomeOk() {
		ResponseEntity<List<Funcionario>> response = this.funcionarioController.FuncionariofindByNome("funcionario 1");
		int httpStatus = response.getStatusCode().value();
		assertEquals(200, httpStatus);
	}
	
	@Test
	@DisplayName("Teste de findByMatricula() OK em Funcionario")
	void findByMatriculaOk() {
		ResponseEntity<List<Funcionario>> response = this.funcionarioController.FuncionariofindByMatricula(1);
		int httpStatus = response.getStatusCode().value();
		assertEquals(200, httpStatus);
	}
	
	@Test
	@DisplayName("Teste de findByIdade() OK em Funcionario")
	void findByIdadeOk() {
		ResponseEntity<List<Funcionario>> response = this.funcionarioController.FuncionariofindByIdade(1);
		int httpStatus = response.getStatusCode().value();
		assertEquals(200, httpStatus);
	}

}
