package br.com.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.modelo.Cliente;
import br.com.jpa.modelo.Conta;

public class TestaRelacionamentoClienteConta {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setId(1L);
		
		Cliente cliente = new Cliente();
		cliente.setConta(conta);
		cliente.setNome("Teste");
		cliente.setEndereco("Rua dali, 77");
		cliente.setProfissao("Dev");
		
		em.getTransaction().begin();
		
		em.persist(cliente);
		em.getTransaction().commit();
		
		em.close();
		
	}

}
