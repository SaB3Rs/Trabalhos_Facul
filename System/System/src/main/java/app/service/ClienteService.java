package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Cliente;
import app.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	public String save(Cliente cliente) {
		this.clienteRepository.save(cliente);
		return "Cliente salvo com sucesso";
	}

	public String update(Cliente cliente, long id) {
		cliente.setId(id);
		this.clienteRepository.save(cliente);
		return "Cliente atualizado com sucesso";
	}

	public Cliente findById(long id) {
		Optional<Cliente> optional = this.clienteRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else
			return null;
	}

	public List<Cliente> findAll() {
		return this.clienteRepository.findAll();
	}

	public String delete(Long id) {
		this.clienteRepository.deleteById(id);
		return " Cliente deletado com sucesso!";
	}

	public List<Cliente> findIdade() {
		return clienteRepository.Idade18a35(18, 35);
	}
}