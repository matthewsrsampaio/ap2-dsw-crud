package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPA {
	//Criar a fábrica
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persisteComida");
	
	public static EntityManager criarEntityManager() {
		return emf.createEntityManager();
	}
	
}
