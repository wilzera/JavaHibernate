package org.libertas.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.libertas.model.teste.Autor;

public class AutorDao {
		
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoHibernate");
	private static EntityManager em = emf.createEntityManager();
	
	// Listar
	public List<Autor> listar() {
		
		Query query = em.createQuery("SELECT l FROM Autor l");
		List<Autor> lista = (List<Autor>) query.getResultList();
		return lista;
		
	}
	
	// Inserir
	public void inserir(Autor a) {
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
	}
	
	// Alterar
	public void alterar(Autor a) {
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
	}
	
	// Inserir
	public void excluir(Autor a) {
		em.getTransaction().begin();
		em.remove(em.merge(a));
		em.getTransaction().commit();
	}
	
	// Consultar
	public Autor consultar(int id) {
		Autor a = em.find(Autor.class, id);
		return a;
	}

}
