package br.com.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.modelo.Categoria;
import br.com.jpa.modelo.Conta;
import br.com.jpa.modelo.Movimentacao;
import br.com.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamentoMovimentacaoCategoria {

	public static void main(String[] args) {
		Categoria categoria1 = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negócios");
		
		Conta conta = new Conta();
		conta.setId(1L);
		
		Movimentacao movimentacaoIda = new Movimentacao();
		movimentacaoIda.setDescricao("Viagen à SP.");
		movimentacaoIda.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacaoIda.setData(LocalDateTime.now());
		movimentacaoIda.setValor(new BigDecimal(300.0));
		movimentacaoIda.setCategorias(Arrays.asList(categoria1, categoria2));
		movimentacaoIda.setConta(conta);
		
		Movimentacao movimentacaoVolta = new Movimentacao();
		movimentacaoVolta.setDescricao("Viagen ao DF.");
		movimentacaoVolta.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacaoVolta.setData(LocalDateTime.now());
		movimentacaoVolta.setValor(new BigDecimal(400.0));
		movimentacaoVolta.setCategorias(Arrays.asList(categoria1, categoria2));
		movimentacaoVolta.setConta(conta);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(categoria1);
		em.persist(categoria2);
		
		em.persist(movimentacaoIda);
		em.persist(movimentacaoVolta);
		
		em.getTransaction().commit();
		em.close();
		
	}
}
