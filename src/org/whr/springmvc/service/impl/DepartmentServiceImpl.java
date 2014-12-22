package org.whr.springmvc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.whr.springmvc.dao.impl.DaoSupportImpl;
import org.whr.springmvc.domain.Department;
import org.whr.springmvc.service.DepartmentService;
@Service
public class DepartmentServiceImpl extends DaoSupportImpl<Department> implements DepartmentService{

	@Override
	public List<Department> toTopList() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Department d where d.parent is null").list();
	}

}
