package br.com.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.modelo.Conta;

public class AlteraSaldoContaThiago {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta contaDoThiago = em.find(Conta.class, 1L);
		
		em.getTransaction().begin();
		contaDoThiago.setSaldo(5000.0);
		em.getTransaction().commit();
		em.close();
		
		contaDoThiago.setSaldo(4500.0);
		
		EntityManager em2 = emf.createEntityManager();
		
		em2.getTransaction().begin();
		
		em2.merge(contaDoThiago);
		
		em2.getTransaction().commit();
	}
}
