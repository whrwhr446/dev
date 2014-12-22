package org.whr.springmvc.utils;

import java.util.ArrayList;
import java.util.List;

import org.whr.springmvc.domain.Department;

public class DepartmentUtil {
	public static List<Department> getlist(List<Department> toList){
		List<Department> list = new ArrayList<Department>();
		getTreeList(toList, list, "+");
		return list;
		
	}
	public static void getTreeList(List<Department> toList,List<Department> list,String prefix){
		for(Department d:toList){
			Department dp =new Department();
			dp.setName(prefix+d.getName());
			dp.setId(d.getId());
			dp.setPrescription(d.getPrescription());
			list.add(dp);
			getTreeList(new ArrayList(d.getChilren()),list, prefix+"++");
		}
	}
}
