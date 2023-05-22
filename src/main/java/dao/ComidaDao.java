package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import entity.Comida;
import util.JPA;

public class ComidaDao {

	public static void salvar(Comida comida) {
		System.out.println("Double esperado: "+comida.getPrecoPorKg());
		System.out.println("Tipo de comida esperado: "+comida.getTipoComida());
		EntityManager entityManager = JPA.criarEntityManager(); //Esse tipo de instanciação fica dentro do pq para cada chamada do método eu vou criar uma nova instância desse carinha. 
		entityManager.getTransaction().begin();
		entityManager.persist(comida);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public static List<Comida> buscarTodos(){
		EntityManager entityManager = JPA.criarEntityManager();
		Query query = entityManager.createQuery("select c from Comida c");
		List<Comida> lista = query.getResultList();
		entityManager.close();
		return lista;
	}
	
}