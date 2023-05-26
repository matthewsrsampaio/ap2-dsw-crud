package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.Comida;
import util.JPA;

public class ComidaDao {

	public static void salvar(Comida comida) {
		EntityManager em = JPA.criarEntityManager(); //Esse tipo de instanciação fica dentro do pq para cada chamada do método eu vou criar uma nova instância desse carinha. 
			em.getTransaction().begin();
			em.persist(comida);
			em.getTransaction().commit();
			em.close();
		}
	}
	
	public static List<Comida> buscarTodos(){
		EntityManager em = JPA.criarEntityManager();
		Query query = em.createQuery("select c from Comida c");
		List<Comida> lista = query.getResultList();
		em.close();
		return lista;
	}

	public static void deletar(Comida comida) {
		EntityManager em = JPA.criarEntityManager();
		em.getTransaction().begin();
		comida = em.find(Comida.class, comida.getId());
		em.remove(comida);
		em.getTransaction().commit();
		em.close();
	}
	
	public static Comida buscarPorId(Integer id) {
		EntityManager em = JPA.criarEntityManager();
		Comida comida = em.find(Comida.class, id);
		em.close();
		return comida;
	}
	
}