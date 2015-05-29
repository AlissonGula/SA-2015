package senai.sc.br.situacao2015.converte;



import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import senai.sc.br.situacao2015.dao.TipoClienteDao;
import senai.sc.br.situacao2015.entity.TipoCliente;

public class TipoClienteConverte {

	
	@FacesConverter(forClass=TipoCliente.class)
	public class TipoCanalConverter implements Converter {

		@Override
		public Object getAsObject(FacesContext context, UIComponent uiComponent, String value) {
			TipoClienteDao dao = new TipoClienteDao();
			Long id = Long.valueOf(value);
			return dao.buscaPorId(id);
		}

		@Override
		public String getAsString(FacesContext context, UIComponent uiComponent, Object value) {
			TipoCliente tipoCliente = (TipoCliente) value;
			return tipoCliente.getId().toString();
		}
		
	
	}
}
