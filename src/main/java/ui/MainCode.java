package ui;

import java.util.Date;

import dao.ComidaDao;
import entity.Comida;

public class MainCode {

	public static void main(String[] args) throws Exception {
		
		/*Comida comida1 = new Comida();
		comida1.setTipoComida("bife de choriço");
		comida1.setPrecoPorKg(57.9);
		comida1.setFabricacao(new Date());
		ComidaDao.salvar(comida1);
		ComidaDao.buscarTodos();*/
		
		ComidaDao.deletar(ComidaDao.buscarPorId(81));
		

		
	}

}
