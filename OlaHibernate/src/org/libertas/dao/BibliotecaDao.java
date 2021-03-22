package org.libertas.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.libertas.model.teste.Biblioteca;

public class BibliotecaDao {
		
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoHibernate");
	private static EntityManager em = emf.createEntityManager();
	
	// Listar
	public List<Biblioteca> listar() {
		
		Query query = em.createQuery("SELECT l FROM Biblioteca l");
		List<Biblioteca> lista = (List<Biblioteca>) query.getResultList();
		return lista;
		
	}
	
	// Inserir
	public void inserir(Biblioteca b) {
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
	}
	
	// Alterar
	public void alterar(Biblioteca b) {
		em.getTransaction().begin();
		em.merge(b);
		em.getTransaction().commit();
	}
	
	// Inserir
	public void excluir(Biblioteca b) {
		em.getTransaction().begin();
		em.remove(em.merge(b));
		em.getTransaction().commit();
	}
	
	// Consultar
	public Biblioteca consultar(int id) {
		Biblioteca b = em.find(Biblioteca.class, id);
		return b;
	}

}
