package senai.sc.br.situacao2015.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class TipoCardapio {
	@Id
	@GeneratedValue
	private long id;
	private String nomePrato;
	private String origemPrato;
	private String rotulo;

	
	public String getRotulo() {
		return rotulo;
	}
	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomePrato() {
		return nomePrato;
	}
	public void setNomePrato(String nomePrato) {
		this.nomePrato = nomePrato;
	}
	public String getOrigemPrato() {
		return origemPrato;
	}
	public void setOrigemPrato(String origemPrato) {
		this.origemPrato = origemPrato;
	}
	
	
	
	
}
