package org.libertas.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.libertas.model.teste.Marca;

public class MarcaDao {
		
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoHibernate");
	private static EntityManager em = emf.createEntityManager();
	
	// Listar
	public List<Marca> listar() {
		
		Query query = em.createQuery("SELECT m FROM Marca m");
		List<Marca> lista = (List<Marca>) query.getResultList();
		return lista;
		
	}
	
	// Inserir
	public void inserir(Marca m) {
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
	}
	
	// Alterar
	public void alterar(Marca m) {
		em.getTransaction().begin();
		em.merge(m);
		em.getTransaction().commit();
	}
	
	// Inserir
	public void excluir(Marca m) {
		em.getTransaction().begin();
		em.remove(em.merge(m));
		em.getTransaction().commit();
	}
	
	// Consultar
	public Marca consultar(int id) {
		Marca m = em.find(Marca.class, id);
		return m;
	}

}
