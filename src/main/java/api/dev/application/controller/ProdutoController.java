package api.dev.application.controller;

import api.dev.application.model.Produto;
import api.dev.application.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import api.dev.application.DTO.requests.RequestProdutoDTO;
import api.dev.application.DTO.responses.ResponseProdutoDTO;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/products")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findProductById(@PathVariable long id) {
        Produto produto = produtoService.findById(id)
                .orElseThrow(()-> new RuntimeException("Produto não encontrado"));
        return ResponseEntity.ok(produto);
    }

    @GetMapping("/listProducts")
    public List<Produto> listingProducts() {
        return produtoService.listingAll();
    }

    @PostMapping("/createNewProduct")
    public Produto saveNewProduct(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @PostMapping("/createMulitpleProducts")
    public List<Produto> saveMultipleProducts(@RequestBody List<Produto> produtos) {
        return produtoService.saveAll(produtos);
    }

    @GetMapping("/searchProductWithContain")
    public List<Produto> searchProductsWithContain(@RequestParam String search) {
        return produtoService.findPartialName(search);
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<ResponseProdutoDTO> updateProduct(@RequestBody RequestProdutoDTO reqProductDto) {

        ResponseProdutoDTO responseProdutoDTO = produtoService.updateProduct(reqProductDto);

        return ResponseEntity.ok(responseProdutoDTO) ;
    }
}
