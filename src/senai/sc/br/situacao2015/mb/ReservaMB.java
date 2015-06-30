package senai.sc.br.situacao2015.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import senai.sc.br.situacao2015.dao.ReservaDao;
import senai.sc.br.situacao2015.dao.TipoReservaDao;
import senai.sc.br.situacao2015.entity.Reserva;
import senai.sc.br.situacao2015.entity.TipoReserva;



@ManagedBean
public class ReservaMB {

	private Reserva reserva;
	private List<Reserva> reservas;
	private List<TipoReserva> tipos;
	private ReservaDao reservaDao;
	
	@PostConstruct
	public void initMB() {
		this.reserva = new Reserva();
		reservaDao = new ReservaDao();
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	public List<Reserva> getReservas() {
		if(reservas == null){
			reservas = reservaDao.listarTodos();
		}
		return reservas;
	}

	public void setReservas(List<Reserva> Reservas) {
		this.reservas = Reservas;
	}

	public List<TipoReserva> getTipos() {
		if(tipos == null){
			TipoReservaDao tipoReservaDao = new TipoReservaDao();
			tipos = tipoReservaDao.listarTodos();
		}
		return tipos;
	}

	public void setTipos(List<TipoReserva> tipos) {
		this.tipos = tipos;
	}

	public String salvar(){
		reservaDao.salvar(reserva);
		return "listareservas?faces-redirect=true";
	}
	
	public String excluir(String idParam){
		Long id = Long.valueOf(idParam);
		reservaDao.excluir(id);
	   reservas = null;
		return "";
	}
	
	public String editar(String idParam){
		Long id = Long.valueOf(idParam);
		reserva = reservaDao.buscarPorId(id);
		return "formreserva";
	}

	
	
}
