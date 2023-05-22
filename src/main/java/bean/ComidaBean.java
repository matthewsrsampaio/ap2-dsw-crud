package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.ComidaDao;
import entity.Comida;

@ManagedBean
public class ComidaBean {
	
	private Comida comida = new Comida();
	private List<Comida> listaComida;
	
	public String salvar() {
		try {
			ComidaDao.salvar(comida);
			comida = new Comida();
		} catch(Exception e) {
			System.out.println("Tem algum mistério em ComidaBean.salvar()");
		}
		return null;
	}
	
	public List<Comida> buscarTodos() {
		listaComida = ComidaDao.buscarTodos();
		return listaComida;
	}

	
	//Getter and Setters
	public Comida getComida() {
		return comida;
	}
	public void setComida(Comida comida) {
		this.comida = comida;
	}
	public List<Comida> getListaComida() {
		return ComidaDao.buscarTodos();
	}

	public void setListaComida(List<Comida> listaComida) {
		this.listaComida = listaComida;
	}
	
}
