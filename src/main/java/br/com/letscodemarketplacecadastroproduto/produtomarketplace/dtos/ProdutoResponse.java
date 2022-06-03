package br.com.letscodemarketplacecadastroproduto.produtomarketplace.dtos;

import lombok.Data;
import java.util.UUID;

@Data
public class ProdutoResponse {

    private UUID id;
    private String nome;
    private String fabricante;
    private String valor;

    public ProdutoResponse(UUID id, String nome, String fabricante, String valor) {
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
        this.valor = valor;
    }
}
