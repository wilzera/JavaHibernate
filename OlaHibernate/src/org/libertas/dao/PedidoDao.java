package org.libertas.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.libertas.model.teste.Pedido;

public class PedidoDao {
		
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoHibernate");
	private static EntityManager em = emf.createEntityManager();
	
	// Listar
	public List<Pedido> listar() {
		
		Query query = em.createQuery("SELECT p FROM Pedido p");
		List<Pedido> lista = (List<Pedido>) query.getResultList();
		return lista;
		
	}
	
	// Inserir
	public void inserir(Pedido p) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	
	// Alterar
	public void alterar(Pedido p) {
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}
	
	// Inserir
	public void excluir(Pedido p) {
		em.getTransaction().begin();
		em.remove(em.merge(p));
		em.getTransaction().commit();
	}
	
	// Consultar
	public Pedido consultar(int id) {
		Pedido p = em.find(Pedido.class, id);
		return p;
	}

}
