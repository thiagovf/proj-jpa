package br.com.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.modelo.Conta;
import br.com.jpa.modelo.Movimentacao;

public class TesteMovimentacaoConta {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Movimentacao movimentacao = em.find(Movimentacao.class, 1L);
		Conta conta = movimentacao.getConta();
		int qtdMovimentacoes = conta.getMovimentacoes().size();
		
		
	}
}
