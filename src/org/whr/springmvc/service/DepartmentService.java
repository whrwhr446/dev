package org.whr.springmvc.service;

import java.util.List;

import org.whr.springmvc.dao.DaoSupport;
import org.whr.springmvc.domain.Department;

public interface DepartmentService extends DaoSupport<Department> {

	List<Department> toTopList();

}
