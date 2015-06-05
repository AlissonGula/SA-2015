package senai.sc.br.situacao2015.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import senai.sc.br.situacao2015.dao.MesaDao;
import senai.sc.br.situacao2015.dao.TipoMesaDao;
import senai.sc.br.situacao2015.entity.Mesa;
import senai.sc.br.situacao2015.entity.TipoMesa;

@ManagedBean
public class MesaMB {

	private Mesa mesa;
	private List<Mesa> mesas;
	private List<TipoMesa> tipos;
	private MesaDao mesaDao;
	
	@PostConstruct
	public void initMB() {
		this.mesa = new Mesa();
		mesaDao = new MesaDao();
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	
	public List<Mesa> getMesas() {
		if(mesas == null){
			mesas = mesaDao.listarTodos();
		}
		return mesas;
	}

	public void setMesas(List<Mesa> Mesas) {
		this.mesas = Mesas;
	}

	public List<TipoMesa> getTipos() {
		if(tipos == null){
			TipoMesaDao tipoMesaDao = new TipoMesaDao();
			tipos = tipoMesaDao.listarTodos();
		}
		return tipos;
	}

	public void setTipos(List<TipoMesa> tipos) {
		this.tipos = tipos;
	}

	public String salvar(){
		mesaDao.salvar(mesa);
		return "listamesas?faces-redirect=true";
	}
	
	public String excluir(String idParam){
		Long id = Long.valueOf(idParam);
		mesaDao.excluir(id);
	   mesas = null;
		return "";
	}
	
	public String editar(String idParam){
		Long id = Long.valueOf(idParam);
		mesa = mesaDao.buscarPorId(id);
		return "formmesa";
	}

	
	
	
}
