package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Cliente;
import app.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	public ClienteRepository clienteRepository;

	public List<Cliente> findAll() {
		return this.clienteRepository.findAll();
	}

	public Cliente findById(long id) {
		// TODO Auto-generated method stub
		return this.clienteRepository.findById(id).get();
	}

	public void save(Cliente cliente) {
		this.clienteRepository.save(cliente);
	}

	public void update(long id, Cliente cliente) {
		cliente.setIdCliente(id);
		this.clienteRepository.save(cliente);
	}

	public String delete(long id) {
		String nome = findById(id).getNome();
		this.clienteRepository.deleteById(id);
		return nome;
	}

}
