package br.com.letscodemarketplacecadastroproduto.produtomarketplace.controllers;


import br.com.letscodemarketplacecadastroproduto.produtomarketplace.dtos.ProdutoRequest;
import br.com.letscodemarketplacecadastroproduto.produtomarketplace.dtos.ProdutoResponse;
import br.com.letscodemarketplacecadastroproduto.produtomarketplace.models.Produto;
import br.com.letscodemarketplacecadastroproduto.produtomarketplace.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
public class ProdutosController {

    final ProdutoService produtoService;

    @GetMapping("/health")
    public String healthAPI () {
        return "API up";
    }

    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodosProdutos() {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarProdutoPeloId(@PathVariable(value = "id") UUID id) {
        Optional<Produto> produtoOptional = produtoService.findById(id);
        if (!produtoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoOptional);
    }


    @PostMapping
    public ResponseEntity<ProdutoResponse> novoProduto (@RequestBody ProdutoRequest produtoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produtoRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRebel(@PathVariable(value = "id") UUID id) {
        Optional<Produto> produtoOptional = produtoService.findById(id);
        if (!produtoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        produtoService.delete(produtoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto excluido");
    }

}
