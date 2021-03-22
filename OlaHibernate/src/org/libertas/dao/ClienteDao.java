package org.libertas.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.libertas.model.teste.Cliente;

public class ClienteDao {
		
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoHibernate");
	private static EntityManager em = emf.createEntityManager();
	
	// Listar
	public List<Cliente> listar() {
		
		Query query = em.createQuery("SELECT c FROM Cliente c");
		List<Cliente> lista = (List<Cliente>) query.getResultList();
		return lista;
		
	}
	
	// Inserir
	public void inserir(Cliente c) {
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
	}
	
	// Alterar
	public void alterar(Cliente c) {
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
	}
	
	// Inserir
	public void excluir(Cliente c) {
		em.getTransaction().begin();
		em.remove(em.merge(c));
		em.getTransaction().commit();
	}
	
	// Consultar
	public Cliente consultar(int id) {
		Cliente c = em.find(Cliente.class, id);
		return c;
	}

}
