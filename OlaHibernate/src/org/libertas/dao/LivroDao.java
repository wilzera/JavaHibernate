package org.libertas.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.libertas.model.Fornecedor;
import org.libertas.model.teste.Livro;

public class LivroDao {
		
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoHibernate");
	private static EntityManager em = emf.createEntityManager();
	
	// Listar
	public List<Livro> listar() {
		
		Query query = em.createQuery("SELECT l FROM Livro l");
		List<Livro> lista = (List<Livro>) query.getResultList();
		return lista;
		
	}
	
	// Inserir
	public void inserir(Livro l) {
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
	}
	
	// Alterar
	public void alterar(Livro l) {
		em.getTransaction().begin();
		em.merge(l);
		em.getTransaction().commit();
	}
	
	// Inserir
	public void excluir(Livro l) {
		em.getTransaction().begin();
		em.remove(em.merge(l));
		em.getTransaction().commit();
	}
	
	// Consultar
	public Livro consultar(int id) {
		Livro l = em.find(Livro.class, id);
		return l;
	}

}
