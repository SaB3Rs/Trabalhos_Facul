package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Venda;
import app.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;

	public String save(Venda venda) {
		double valorTotal = venda.calcularValorTotal();
		venda.setVlTotal(valorTotal);
		this.vendaRepository.save(venda);
		return "Venda salva com sucesso!";
	}

	public String update(Venda venda, Long id) {
		venda.setId(id);
		double valorTotal = venda.calcularValorTotal();
		venda.setVlTotal(valorTotal);
		this.vendaRepository.save(venda);
		return "Venda atualizada com sucesso!";
	}

	public Venda findById(Long id) {
		Optional<Venda> optional = this.vendaRepository.findById(id);
		return optional.orElse(null);
	}

	public List<Venda> findAll() {
		return this.vendaRepository.findAll();
	}

	public String delete(Long id) {
		this.vendaRepository.deleteById(id);
		return "Venda deletada com sucesso!";
	}

	public List<Venda> findByClienteNome(String nome) {
		return vendaRepository.findByClienteNomeContaining(nome);
	}

	public List<Venda> findByFuncionarioNome(String nome) {
		return vendaRepository.findByFuncionarioNomeContaining(nome);
	}

	public List<Venda> listarTop10VendasMaisAltas() {
		return vendaRepository.findTop10ByOrderByVlTotalDesc();
	}
}