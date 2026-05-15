package api.dev.application.repository;

import api.dev.application.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.dev.application.model.Produto;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public List<Produto> findByNameProductContainingIgnoreCase(String name);

    public Optional<Produto> findById(long id);

    public  Produto save(Produto produto);

}
