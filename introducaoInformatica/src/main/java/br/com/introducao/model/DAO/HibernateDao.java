package br.com.introducao.model.DAO;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

public class HibernateDao<T> implements InterfaceDao<T>, Serializable {
    
    private static final long serialVerisonUID =1L ;
    private Class<T> classe;
    private Session session;

    public HibernateDao(Class<T> classe, Session session) {
        super();
        this.classe = classe;
        this.session = session;
    }
    
    
    @Override
    public void create(T entity) {
        session.save(entity);
    }

    @Override
    public void upadate(T entity) {
        session.update(entity);
    }

    @Override
    public void remove(T entity) {
        session.delete(this);
    }

    @Override
    public void merge(T entity) {
        session.merge(entity);
    }

    @Override
    public T getEntity(Serializable id) {
       T entity = (T) session.get(classe, id);
        return entity;
    }

    @Override
    public T getEntityByDetachedCriteria(DetachedCriteria criteria) {
        T entity = (T) criteria.getExecutableCriteria(session).uniqueResult();
        return entity;
        
    }

    @Override
    public List<T> getEntities() {
        List<T> entities = (List<T>) session.createCriteria(classe).list();
        return entities;
        
    }

    @Override
    public List<T> getListByDetachedCriteria(DetachedCriteria criteria) {
        return criteria.getExecutableCriteria(session).list();
        
    }
}
