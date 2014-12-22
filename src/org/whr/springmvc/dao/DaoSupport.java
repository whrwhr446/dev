package org.whr.springmvc.dao;

import java.util.List;

public interface DaoSupport<T> {
	public void add(T Entity);
	public void delete(int id);
	public T findById(int id);
	public List<T> findAll();
	public void update(T Entity);
}
