package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.Comida;
import util.JPA;

public class ComidaDao {

	public static void salvar(Comida comida) throws Exception {
	    EntityManager em = JPA.criarEntityManager();
	    try {
		    em.getTransaction().begin();
		    em.persist(comida);
		    em.getTransaction().commit();
	    } catch (Exception e) {
		    throw e;
	    } finally {
		    em.close();
	    }
	}
	
	public static List<Comida> buscarTodos() throws Exception {
		EntityManager em = JPA.criarEntityManager();
		try {
			Query query = em.createQuery("select c from Comida c");
			List<Comida> lista = query.getResultList();
			return lista;
		}catch(Exception e) {
			throw e;
		}finally {
			em.close();
		}
	}

	public static void deletar(Comida comida) throws Exception {
		EntityManager em = JPA.criarEntityManager();
		try {
			em.getTransaction().begin();
			comida = em.find(Comida.class, comida.getId());
			em.remove(comida);
			em.getTransaction().commit();
		}catch(Exception e) {
			throw e;
		}finally {
			em.close();
		}
	}
	
	public static Comida buscarPorId(Integer id) throws Exception{
		EntityManager em = JPA.criarEntityManager();
		try {
			Comida comida = em.find(Comida.class, id);
			return comida;
		}catch(Exception e) {
			throw e;
		}finally {
			em.close();
		}
	}
	
}
