package org.libertas.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.libertas.model.teste.Telefone;

public class TelefoneDao {
		
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoHibernate");
	private static EntityManager em = emf.createEntityManager();
	
	// Listar
	public List<Telefone> listar() {
		
		Query query = em.createQuery("SELECT t FROM Telefone t");
		List<Telefone> lista = (List<Telefone>) query.getResultList();
		return lista;
		
	}
	
	// Inserir
	public void inserir(Telefone t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}
	
	// Alterar
	public void alterar(Telefone t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}
	
	// Inserir
	public void excluir(Telefone t) {
		em.getTransaction().begin();
		em.remove(em.merge(t));
		em.getTransaction().commit();
	}
	
	// Consultar
	public Telefone consultar(int id) {
		Telefone t = em.find(Telefone.class, id);
		return t;
	}

}
