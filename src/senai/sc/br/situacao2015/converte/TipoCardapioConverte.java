package senai.sc.br.situacao2015.converte;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import senai.sc.br.situacao2015.dao.TipoCardapioDao;
import senai.sc.br.situacao2015.entity.TipoCardapio;



public class TipoCardapioConverte {

	@FacesConverter(forClass=TipoCardapio.class)
	public class TipoCardapioConverter implements Converter {

		@Override
		public Object getAsObject(FacesContext context, UIComponent uiComponent, String value) {
			TipoCardapioDao dao = new TipoCardapioDao();
			Long id = Long.valueOf(value);
			return dao.buscaPorId(id);
		}

		@Override
		public String getAsString(FacesContext context, UIComponent uiComponent, Object value) {
			TipoCardapio tipoCardapio = (TipoCardapio) value;
			return tipoCardapio.getNomePrato().toString();
		}
		
	
	}

}
