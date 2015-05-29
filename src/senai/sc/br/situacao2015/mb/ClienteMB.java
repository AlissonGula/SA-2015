package senai.sc.br.situacao2015.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import senai.sc.br.situacao2015.dao.ClienteDao;
import senai.sc.br.situacao2015.dao.TipoClienteDao;
import senai.sc.br.situacao2015.entity.Cliente;
import senai.sc.br.situacao2015.entity.TipoCliente;


@ManagedBean
public class ClienteMB {

	
	private Cliente cliente;
	private List<Cliente> clientes;
	private List<TipoCliente> tipos;
	private ClienteDao clienteDao;
	
	@PostConstruct
	public void initMB() {
		this.cliente = new Cliente();
		clienteDao = new ClienteDao();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Cliente> getClientes() {
		if(clientes == null){
			clientes = clienteDao.listarTodos();
		}
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<TipoCliente> getTipos() {
		if(tipos == null){
			TipoClienteDao tipoClienteDao = new TipoClienteDao();
			tipos = tipoClienteDao.listarTodos();
		}
		return tipos;
	}

	public void setTipos(List<TipoCliente> tipos) {
		this.tipos = tipos;
	}

	public String salvar(){
		clienteDao.salvar(cliente);
		return "listaclientes?faces-redirect=true";
	}
	
	public String excluir(String idParam){
		Long id = Long.valueOf(idParam);
		clienteDao.excluir(id);
		clientes = null;
		return "";
	}
	
	public String editar(String idParam){
		Long id = Long.valueOf(idParam);
		cliente = clienteDao.buscarPorId(id);
		return "formcliente";
	}

	
}
