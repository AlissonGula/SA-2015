package senai.sc.br.situacao2015.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Mesa {

	@Id
	@GeneratedValue
	private long id;
	private String nome;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	private Date data;
	private String disponivel;
	private String lugares; 
	
	
	
	public String getLugares() {
		return lugares;
	}
	public void setLugares(String lugares) {
		this.lugares = lugares;
	}
	
	
	@ManyToOne
	private TipoMesa tipoMesa;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public String getDisponivel() {
		return disponivel;
	}
	public void setDisponivel(String disponivel) {
		this.disponivel = disponivel;
	}
	public TipoMesa getTipoMesa() {
		return tipoMesa;
	}
	public void setTipoMesa(TipoMesa tipoMesa) {
		this.tipoMesa = tipoMesa;
	}
}
