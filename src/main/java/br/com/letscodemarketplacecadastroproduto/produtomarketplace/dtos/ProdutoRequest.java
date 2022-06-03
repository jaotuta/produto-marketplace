package br.com.letscodemarketplacecadastroproduto.produtomarketplace.dtos;

import lombok.Data;

@Data
public class ProdutoRequest {

    private String nome;
    private String fabricante;
    private String valor;

}
