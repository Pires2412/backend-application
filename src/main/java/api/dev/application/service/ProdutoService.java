package api.dev.application.service;

import api.dev.application.model.Produto;
import api.dev.application.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import api.dev.application.DTO.responses.ResponseProdutoDTO;
import api.dev.application.DTO.requests.RequestProdutoDTO;

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

    public ResponseProdutoDTO updateProduct(RequestProdutoDTO dto) {



       Optional<Produto> produto = produtoRepository.findById(dto.id());

       produto.get().setNameProduct(dto.nameProduct());
       produto.get().setDescription(dto.description());
       produto.get().setQuantityInStock(dto.quantityInStock());
       produto.get().setPurchasePrice(dto.purchasePrice());
       produto.get().setSellingPrice(dto.sellingPrice());
       produto.get().setSupplier(dto.supplier());
       produto.get().setCategory(dto.category());
       produto.get().setSubcategory(dto.subcategory());

       produtoRepository.save(produto.orElse(null));

       ResponseProdutoDTO responseProdutoDTO = new ResponseProdutoDTO(
               dto.nameProduct(),
               dto.description(),
               dto.quantityInStock(),
               dto.purchasePrice(),
               dto.sellingPrice(),
               dto.supplier(),
               dto.category(),
               dto.subcategory());

       return responseProdutoDTO;
    }

    public ResponseProdutoDTO createNewProduct(RequestProdutoDTO dto) {
        Produto product = new Produto(
                dto.nameProduct(),
                dto.description(),
                dto.quantityInStock(),
                dto.purchasePrice(),
                dto.sellingPrice(),
                dto.supplier(),
                dto.category(),
                dto.subcategory());

        produtoRepository.save(product);

        ResponseProdutoDTO responseProduct = new ResponseProdutoDTO(
                dto.nameProduct(),
                dto.description(),
                dto.quantityInStock(),
                dto.purchasePrice(),
                dto.sellingPrice(),
                dto.supplier(),
                dto.category(),
                dto.subcategory());

        return  responseProduct;
    }

    public void deleteProductById(Long id) {produtoRepository.deleteById(id);}

}
