package org.libertas.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.libertas.model.teste.Produto;

public class ProdutoDao {
		
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoHibernate");
	private static EntityManager em = emf.createEntityManager();
	
	// Listar
	public List<Produto> listar() {
		
		Query query = em.createQuery("SELECT p FROM Produto p");
		List<Produto> lista = (List<Produto>) query.getResultList();
		return lista;
		
	}
	
	// Inserir
	public void inserir(Produto p) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	
	// Alterar
	public void alterar(Produto p) {
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}
	
	// Inserir
	public void excluir(Produto p) {
		em.getTransaction().begin();
		em.remove(em.merge(p));
		em.getTransaction().commit();
	}
	
	// Consultar
	public Produto consultar(int id) {
		Produto p = em.find(Produto.class, id);
		return p;
	}

}
