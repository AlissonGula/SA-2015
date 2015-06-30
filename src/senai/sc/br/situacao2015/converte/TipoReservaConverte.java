package senai.sc.br.situacao2015.converte;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import senai.sc.br.situacao2015.dao.TipoReservaDao;
import senai.sc.br.situacao2015.entity.TipoMesa;
import senai.sc.br.situacao2015.entity.TipoReserva;

public class TipoReservaConverte {

	@FacesConverter(forClass=TipoReserva.class)
	public class TipoReservaConverter implements Converter {

		@Override
		public Object getAsObject(FacesContext context, UIComponent uiComponent, String value) {
			TipoReservaDao dao = new TipoReservaDao();
			Long id = Long.valueOf(value);
			return dao.buscaPorId(id);
		}

		@Override
		public String getAsString(FacesContext context, UIComponent uiComponent, Object value) {
			TipoMesa tipoReserva = (TipoMesa) value;
			return tipoReserva.getId().toString();
		}
		
	
	}
	
	
	
}
