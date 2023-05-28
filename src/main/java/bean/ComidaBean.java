package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.ComidaDao;
import entity.Comida;

@ManagedBean
public class ComidaBean {
	
	private Comida comida = new Comida();
	private List<Comida> listaComida;
	private Comida messageComida;
		
	public String salvar() {
		try {
			ComidaDao.salvar(comida);
			return null;
		}catch(Exception e) {
			return "Bucho em ComidaBean.salvar() -> " + e;
		}
	}
	
	public List<Comida> buscarTodos() {
		listaComida = ComidaDao.buscarTodos();
		return listaComida;
	}
	
	public String deletar() {
		try {
			ComidaDao.deletar(comida);
			listaComida = ComidaDao.buscarTodos();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, " =>", "Deletado com sucesso!"));
			return null;
		}catch(Exception e) {
			return "Bucho em ComidaBean.deletar() -> " + e;
		}
	}
	
	public void infoItem(Comida comida) {
		try {
			String texto = ComidaDao.buscarPorId(comida.getId()).toString();
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Info =>", texto));
		}catch(Exception e) {
			System.out.println("Bucho em ComidaBean.infoItem()" + e);
		}
	}
	
	public void info() {
		try {
			listaComida = ComidaDao.buscarTodos();
			Integer maiorId = Integer.MIN_VALUE;
			for(Comida objComida :  listaComida) {
				if(objComida.getId() > maiorId) {
					maiorId = objComida.getId();
				}
			}
			String texto = ComidaDao.buscarPorId(maiorId).toString();
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Informação sobre o Objeto com maior ID => ", texto));
		}catch(Exception e) {
			System.out.println("Bucho em ComidaBean.info() " + e);
		}
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
	public Comida getMessageComida() {
		return messageComida;
	}
	public void setMessageComida(Comida messageComida) {
		this.messageComida = messageComida;
	}
	
	
}
