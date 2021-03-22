package org.libertas.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.libertas.model.Fornecedor;

public class FornecedorDao {
		
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoHibernate");
	private static EntityManager em = emf.createEntityManager();
	
	// Listar
	public List<Fornecedor> listar() {
		
		Query query = em.createQuery("SELECT p FROM Produto p");
		List<Fornecedor> lista = (List<Fornecedor>) query.getResultList();
		return lista;
		
	}
	
	// Inserir
	public void inserir(Fornecedor p) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	
	// Alterar
	public void alterar(Fornecedor p) {
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}
	
	// Inserir
	public void excluir(Fornecedor p) {
		em.getTransaction().begin();
		em.remove(em.merge(p));
		em.getTransaction().commit();
	}
	
	// Consultar
	public Fornecedor consultar(int id) {
		Fornecedor p = em.find(Fornecedor.class, id);
		return p;
	}

}
