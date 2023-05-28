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
	
	public void clear() {
        comida.setTipoComida(null);
        comida.setPrecoPorKg(null);
    }
		
	public String salvar() {
		try {
			ComidaDao.salvar(comida);
			String texto = comida.toString();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Info =>", texto));
			clear();
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			return "Bucho em ComidaBean.salvar()";
		}
	}
	
	public List<Comida> buscarTodos() {
	    try {
	        listaComida = ComidaDao.buscarTodos();
	        return listaComida;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	public String deletar() {
		try {
			ComidaDao.deletar(comida);
			listaComida = ComidaDao.buscarTodos();
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			return "Bucho em ComidaBean.deletar()";
		}
	}
	
	public void infoItem(Comida comida) {
		try {
			String texto = ComidaDao.buscarPorId(comida.getId()).toString();
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Info =>", texto));
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Bucho em ComidaBean.infoItem()");
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
			e.printStackTrace();
			System.out.println("Bucho em ComidaBean.info()");
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
