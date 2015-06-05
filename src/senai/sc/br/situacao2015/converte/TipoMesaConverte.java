package senai.sc.br.situacao2015.converte;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import senai.sc.br.situacao2015.dao.TipoMesaDao;
import senai.sc.br.situacao2015.entity.TipoMesa;

public class TipoMesaConverte {

	@FacesConverter(forClass=TipoMesa.class)
	public class TipoMesaConverter implements Converter {

		@Override
		public Object getAsObject(FacesContext context, UIComponent uiComponent, String value) {
			TipoMesaDao dao = new TipoMesaDao();
			Long id = Long.valueOf(value);
			return dao.buscaPorId(id);
		}

		@Override
		public String getAsString(FacesContext context, UIComponent uiComponent, Object value) {
			TipoMesa tipoMesa = (TipoMesa) value;
			return tipoMesa.getId().toString();
		}
		
	
	}
	
}
