package org.libertas.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.libertas.model.teste.Cidade;

public class CidadeDao {
		
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoHibernate");
	private static EntityManager em = emf.createEntityManager();
	
	// Listar
	public List<Cidade> listar() {
		
		Query query = em.createQuery("SELECT c FROM Cidade c");
		List<Cidade> lista = (List<Cidade>) query.getResultList();
		return lista;
		
	}
	
	// Inserir
	public void inserir(Cidade c) {
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
	}
	
	// Alterar
	public void alterar(Cidade c) {
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
	}
	
	// Inserir
	public void excluir(Cidade c) {
		em.getTransaction().begin();
		em.remove(em.merge(c));
		em.getTransaction().commit();
	}
	
	// Consultar
	public Cidade consultar(int id) {
		Cidade c = em.find(Cidade.class, id);
		return c;
	}

}
