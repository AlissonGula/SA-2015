package senai.sc.br.situacao2015.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class TipoReserva {
	@Id
	@GeneratedValue
	private Long id;
	private Date data;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
}
