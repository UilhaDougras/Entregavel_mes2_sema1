package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		// TODO Auto-generated method stub
		return this.vendaRepository.findById(id).get();
	}

	public void save(Venda venda) {
		this.vendaRepository.save(venda);
	}

	public void update(long id, Venda venda) {
		venda.setIdVenda(id);
		this.vendaRepository.save(venda);
	}

	public String delete(long id) {
		String idString = Integer.toString((int) id);
		this.vendaRepository.deleteById(id);
		return idString;
	}

}
