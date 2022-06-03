package br.com.letscodemarketplacecadastroproduto.produtomarketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
public class CadastroProdutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroProdutoApplication.class, args);
	}

}
