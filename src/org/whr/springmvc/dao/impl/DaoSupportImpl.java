package org.whr.springmvc.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import org.whr.springmvc.dao.DaoSupport;

public class DaoSupportImpl<T> implements DaoSupport<T> {
	@Resource
	private SessionFactory sessionFactory;
	private Class<T> clazz;
	public DaoSupportImpl(){
		ParameterizedType pt=(ParameterizedType) this.getClass().getGenericSuperclass();
		clazz=(Class<T>) pt.getActualTypeArguments()[0];
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void add(T Entity) {
		// TODO Auto-generated method stub
		getSession().save(Entity);
	}

	@Override
	public void delete(int id) {
		Object Entity=findById(id);
		if(Entity!=null){
		Session session=getSession();
		session.delete(Entity);
		}

	}

	@Override
	public T findById(int id) {
		// TODO Auto-generated method stub
		return (T) getSession().createQuery("from "+clazz.getSimpleName()+" where id =?").setParameter(0, id).uniqueResult();
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return  getSession().createQuery("from "+clazz.getSimpleName()+"").list();
	}

	@Override
	public void update(T Entity) {
		// TODO Auto-generated method stub
		getSession().update(Entity);

	}

}
