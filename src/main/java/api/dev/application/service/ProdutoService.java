package api.dev.application.service;

import api.dev.application.model.Produto;
import api.dev.application.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import api.dev.application.model.Produto;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Optional<Produto> findById(long id) {
        return produtoRepository.findById(id);
    }

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listingAll() {
        return produtoRepository.findAll();
    }

    public List<Produto> saveAll(List<Produto> produtos) {
        return  produtoRepository.saveAll(produtos);
    }

    public List<Produto> findPartialName(String name) {return produtoRepository.findByNameProductContainingIgnoreCase(name);}

    public Optional<Produto> findById(Long id) {return  produtoRepository.findById(id);}

}
