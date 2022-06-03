package br.com.letscodemarketplacecadastroproduto.produtomarketplace.models;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_PRODUCT")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column
    private String nome;
    @Column
    private String fabricante;
    @Column
    private String valor;


}
