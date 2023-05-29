package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.ComidaDao;
import entity.Comida;


@ManagedBean // Usado para controlar a interface
public class ComidaBean {
	
	private Comida comida = new Comida();
	private List<Comida> listaComida;
	private Comida messageComida;
	
	public void clear() throws Exception{
		try {
			comida.setTipoComida(null);
			comida.setPrecoPorKg(null);
		}catch(Exception e) {
			throw e;
		}
    }
		
	public String salvar() throws Exception{
		try {
			ComidaDao.salvar(comida);
			String texto = comida.toString();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Info =>", texto));
			clear();
			return null;
		}catch(Exception e) {
			throw e;
		}
	}
	
	public List<Comida> buscarTodos() throws Exception {
	    try {
	        listaComida = ComidaDao.buscarTodos();
	        return listaComida;
	    } catch (Exception e) {
	        throw e;
	    }
	}
	
	public String deletar() throws Exception {
		try {
			ComidaDao.deletar(comida);
			listaComida = ComidaDao.buscarTodos();
			return null;
		}catch(Exception e) {
			throw e;
		}
	}
	
	public void infoItem(Comida comida) throws Exception {
		try {
			String texto = ComidaDao.buscarPorId(comida.getId()).toString();
	        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Info =>", texto));
		}catch(Exception e) {
			throw e;
		}
	}
	
	public void info() throws Exception {
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
			throw e;
		}
    }
	
	//Getter and Setters
	public Comida getComida() {
		return comida;
	}
	public void setComida(Comida comida) {
		this.comida = comida;
	}
	public List<Comida> getListaComida() throws Exception {
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
