package senai.sc.br.situacao2015.mb;

import javax.faces.bean.ManagedBean;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import senai.sc.br.situacao2015.util.EmailUtil;


	@ManagedBean
	public class ContatoMB {
		
		private String email;
		private String telefone;
		private String cidade;
		private String assunto;
		private String mensagem;
	
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getTelefone() {
			return telefone;
		}
		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
		public String getCidade() {
			return cidade;
		}
		public void setCidade(String cidade) {
			this.cidade = cidade;
		}
		public String getAssunto() {
			return assunto;
		}
		public void setAssunto(String assunto) {
			this.assunto = assunto;
		}		
	
		public String getMensagem() {
			return mensagem;
		}
		public void setMensagem(String mensagem) {
			this.mensagem = mensagem;
		}
		


		public String enviar(){
			String mensagemText = "Email: " + email +
					"\nTelefone: " + telefone +
					"\nCidade: " + cidade +
					"\nAssunto: " + assunto+
					"\nMensagem: " + mensagem ;
					
			
			try {
				EmailUtil.enviarEmail(email, "Contato via site.", mensagemText);
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			
			return "";
		}
		
	}
	

