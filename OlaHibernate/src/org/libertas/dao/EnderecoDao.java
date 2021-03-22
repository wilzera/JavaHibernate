package org.libertas.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.libertas.model.teste.Endereco;

public class EnderecoDao {
		
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoHibernate");
	private static EntityManager em = emf.createEntityManager();
	
	// Listar
	public List<Endereco> listar() {
		
		Query query = em.createQuery("SELECT e FROM Endereco e");
		List<Endereco> lista = (List<Endereco>) query.getResultList();
		return lista;
		
	}
	
	// Inserir
	public void inserir(Endereco e) {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	
	// Alterar
	public void alterar(Endereco e) {
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
	}
	
	// Inserir
	public void excluir(Endereco e) {
		em.getTransaction().begin();
		em.remove(em.merge(e));
		em.getTransaction().commit();
	}
	
	// Consultar
	public Endereco consultar(int id) {
		Endereco e = em.find(Endereco.class, id);
		return e;
	}

}
