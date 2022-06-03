package br.com.letscodemarketplacecadastroproduto.produtomarketplace.service;

import br.com.letscodemarketplacecadastroproduto.produtomarketplace.dtos.ProdutoRequest;
import br.com.letscodemarketplacecadastroproduto.produtomarketplace.dtos.ProdutoResponse;
import br.com.letscodemarketplacecadastroproduto.produtomarketplace.models.Produto;
import br.com.letscodemarketplacecadastroproduto.produtomarketplace.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoResponse save(ProdutoRequest produtoRequest) {
        Produto produto = new Produto();
        BeanUtils.copyProperties(produtoRequest, produto);
        produtoRepository.save(produto);
        ProdutoResponse produtoResponse = new ProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getFabricante(),
                produto.getValor());
        return produtoResponse;
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> findById(UUID id) {
        return produtoRepository.findById(id);
    }

    @Transactional
    public void delete(Produto produto) {
        produtoRepository.delete(produto);
    }

}
