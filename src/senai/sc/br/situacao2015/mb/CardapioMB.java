package senai.sc.br.situacao2015.mb;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import senai.sc.br.situacao2015.dao.CardapioDao;
import senai.sc.br.situacao2015.dao.TipoCardapioDao;
import senai.sc.br.situacao2015.entity.Cardapio;
import senai.sc.br.situacao2015.entity.TipoCardapio;
import senai.sc.br.situacao2015.util.UploadImageException;
import senai.sc.br.situacao2015.util.UploadImageUtil;

@ManagedBean
public class CardapioMB {

		private Cardapio cardapio;
		private List<Cardapio> cardapios;
		private List<TipoCardapio> tipos;
		private CardapioDao cardapioDao;
		private Part logo;
		private UploadImageUtil uploadImageUtil;
		
		@PostConstruct
		public void initMB() {
			this.cardapio = new Cardapio();
			cardapioDao = new CardapioDao();
			uploadImageUtil = new UploadImageUtil("/img/");
		}

		public Cardapio getCardapio() {
			return cardapio;
		}

		public void setCardapio(Cardapio cardapio) {
			this.cardapio = cardapio;
		}
		
		public List<Cardapio> getCardapios() {
			if(cardapios == null){
				cardapios = cardapioDao.listarTodos();
			}
			return cardapios;
		}

		public void setCanais(List<Cardapio> cardapios) {
			this.cardapios = cardapios;
		}

		public List<TipoCardapio> getTipos() {
			if(tipos == null){
				TipoCardapioDao tipoCardapioDao = new TipoCardapioDao();
				tipos = tipoCardapioDao.listarTodos();
			}
			return tipos;
		}

		public void setTipos(List<TipoCardapio> tipos) {
			this.tipos = tipos;
		}

		public Part getLogo() {
			return logo;
		}

		public void setLogo(Part logo) {
			this.logo = logo;
		}

		public String caminhoUpload(String imagem){
			return uploadImageUtil.getCaminhoRelativo(imagem);
		}
		
		public String salvar(){
			String nomeLogo;
			try {
				nomeLogo = uploadImageUtil.salvar(logo, cardapio.getLogo());
				cardapio.setLogo(nomeLogo);
			} catch (UploadImageException e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
				e.printStackTrace();
				return "";
			} catch (IOException e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possivel salvar a imagem."));
				e.printStackTrace();
				return "";
			}
			
			cardapioDao.salvar(cardapio);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
			return "listacardapio";
		}
		
		public String excluir(String idParam){
			Long id = Long.valueOf(idParam);
			
			Cardapio cardapioExcluir = cardapioDao.buscarPorId(id);
			uploadImageUtil.excluir(cardapioExcluir.getLogo());
			
			cardapioDao.excluir(id);
			cardapios = null;
			return "";
		}
		
		public String editar(String idParam){
			Long id = Long.valueOf(idParam);
			cardapio = cardapioDao.buscarPorId(id);
			return "formcardapio";
		}
		
	}
