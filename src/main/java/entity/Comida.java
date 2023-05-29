package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;



@Entity
public class Comida {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "Tipo_de_Comida")
	private String tipoComida;
	@Column(name = "Preco_por_Kg")
	@Type(type = "double")
	private Double precoPorKg;
	@Temporal(TemporalType.DATE)
	@Column(columnDefinition = "DATE")
	private Date fabricacao = new Date();
	
	@Override
	public String toString() {
		return "id=" + id + ", tipoComida=" + tipoComida + ", precoPorKg=" + precoPorKg + ", fabricacao="
				+ fabricacao + "\n";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipoComida() {
		return tipoComida;
	}
	public void setTipoComida(String tipoComida) {
		this.tipoComida = tipoComida;
	}
	public Double getPrecoPorKg() {
		return precoPorKg;
	}
	public void setPrecoPorKg(Double precoPorKg) {
		this.precoPorKg = precoPorKg;
	}
	public Date getFabricacao() {
		return fabricacao;
	}
	public void setFabricacao(Date fabricacao) {
		this.fabricacao = fabricacao;
	}
	
	
	
}
