package senai.sc.br.situacao2015.converte;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import senai.sc.br.situacao2015.dao.TipoFuncionarioDao;
import senai.sc.br.situacao2015.entity.TipoFuncionario;

public class TipoFuncionarioConverte {

	@FacesConverter(forClass=TipoFuncionario.class)
	public class TipoFuncionarioConverter implements Converter {

		@Override
		public Object getAsObject(FacesContext context, UIComponent uiComponent, String value) {
			TipoFuncionarioDao dao = new TipoFuncionarioDao();
			Long id = Long.valueOf(value);
			return dao.buscaPorId(id);
		}

		@Override
		public String getAsString(FacesContext context, UIComponent uiComponent, Object value) {
			TipoFuncionario tipoFuncionario = (TipoFuncionario) value;
			return tipoFuncionario.getId().toString();
		}
		
	
	}
	
}
