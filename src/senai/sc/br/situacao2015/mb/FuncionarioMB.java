package senai.sc.br.situacao2015.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import senai.sc.br.situacao2015.dao.FuncionarioDao;
import senai.sc.br.situacao2015.dao.TipoFuncionarioDao;
import senai.sc.br.situacao2015.entity.Funcionario;
import senai.sc.br.situacao2015.entity.TipoFuncionario;

@ManagedBean
public class FuncionarioMB {

	private Funcionario funcionario;
	private List<Funcionario> funcionarios;
	
	private List<TipoFuncionario> tipos;
	private FuncionarioDao funcionarioDao;
	
	@PostConstruct
	public void initMB() {
		this.funcionario = new Funcionario();
		funcionarioDao = new FuncionarioDao();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public List<Funcionario> getFuncionarios() {
		if(funcionarios == null){
			funcionarios = funcionarioDao.listarTodos();
		}
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<TipoFuncionario> getTipos() {
		if(tipos == null){
			TipoFuncionarioDao tipoFuncionarioDao = new TipoFuncionarioDao();
			tipos = tipoFuncionarioDao.listarTodos();
		}
		return tipos;
	}

	public void setTipos(List<TipoFuncionario> tipos) {
		this.tipos = tipos;
	}

	public String salvar(){
		funcionarioDao.salvar(funcionario);
		return "listaclientes?faces-redirect=true";
	}
	
	public String excluir(String idParam){
		Long id = Long.valueOf(idParam);
		funcionarioDao.excluir(id);
		funcionarios = null;
		return "";
	}
	
	public String editar(String idParam){
		Long id = Long.valueOf(idParam);
		funcionario = funcionarioDao.buscarPorId(id);
		return "formfuncionario";
	}
	
}
