package senai.sc.br.situacao2015.util;

import java.io.IOException;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(servletNames="Faces Servlet")
public class JPAFilter implements Filter {
	private static Logger logger;
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		logger = Logger.getLogger(this.getClass().getName());
		
		logger.info("Criou O EMF");
		JPAUtil.createEntityManagerFactory();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		EntityManager entityManager = JPAUtil.createEntityManager(request);
		entityManager.getTransaction().begin();
		
		filterChain.doFilter(request, response);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	@Override
	public void destroy() {
		logger.warning("Fechou O EMF");
		JPAUtil.entityManagerFactoryClose();
	}
}