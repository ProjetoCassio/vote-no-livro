package com.votenolivro.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import com.votenolivro.bean.EntityTemplate;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;

/**
 * 
 * @author Cassio Lemos
 * 
 */
@SuppressWarnings("deprecation")
@Component
@ApplicationScoped
public class DaoFactory {

	protected SessionFactory sessionFactory;
	protected Session session;

	public DaoFactory() {
		super();
		createInitialFactory();
	}


	private void createInitialFactory() {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();
		this.sessionFactory = configuration.buildSessionFactory();
	}

	public Session getSession() {
		if (this.session == null || !this.session.isOpen()) {
			this.session = this.sessionFactory.openSession();
		}
		return this.session;
	}

	public <T extends EntityTemplate> IDao<T> getDao(Class<T> clazz) {
		return new GenericDao<T>(clazz, this);
	}
}
