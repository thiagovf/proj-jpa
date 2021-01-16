package br.com.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.jpa.modelo.Conta;
import br.com.jpa.modelo.Movimentacao;

public class TesteJPQL {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		String sql = "select m from Movimentacao m where m.conta = :pConta";
		
		Conta conta = new Conta();
		conta.setId(1L);
		
		Query query = em.createQuery(sql);
		query.setParameter("pConta", conta);
		
		List<Movimentacao> movimentacoes = query.getResultList();
		for(Movimentacao movimentacao : movimentacoes) {
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Valor: " + movimentacao.getValor());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
		}
	}
}
