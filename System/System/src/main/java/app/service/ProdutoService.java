package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Produto;
import app.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;

	public String save(Produto produto) {
		this.produtoRepository.save(produto);
		return "Produto salvo com sucesso";
	}

	public String update(Produto produto, long id) {
		produto.setId(id);
		this.produtoRepository.save(produto);
		return "Produto atualizado com sucesso";
	}

	public Produto findById(Long id) {
		Optional<Produto> optional = this.produtoRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new RuntimeException("Produto com ID " + id + " não encontrado");
		}
	}

	public List<Produto> findAll() {
		return this.produtoRepository.findAll();
	}

	public String delete(Long id) {
		this.produtoRepository.deleteById(id);
		return "Produto deletado com sucesso";
	}

	public List<Produto> Top10ProdutosMaisCaros() {
		return produtoRepository.findTop10ByOrderByPrecoDesc();
	}
}