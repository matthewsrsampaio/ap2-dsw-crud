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
		ComidaDao.salvar(comida);
		return null;
	}
	
	public List<Comida> buscarTodos() {
		listaComida = ComidaDao.buscarTodos();
		return listaComida;
	}
	
	public String deletar() {
		ComidaDao.deletar(comida);
		listaComida = ComidaDao.buscarTodos();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, " =>", "Deletado com sucesso!"));
		return null;
	}
	
	public void infoItem(Comida comida) {
		String texto = ComidaDao.buscarPorId(comida.getId()).toString();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Info =>", texto));
	}
	
	public void info(Comida comida) {
		listaComida = ComidaDao.buscarTodos();
		Integer maiorId = 0;
		for(Comida bt :  listaComida) {
			if(bt.getId() > 0) {
				maiorId = bt.getId();
			}
		}
		
		ComidaDao.buscarPorId(maiorId);
		
		String texto = ComidaDao.buscarPorId(maiorId).toString();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Informação sobre o Objeto com maior ID => ", texto));
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
