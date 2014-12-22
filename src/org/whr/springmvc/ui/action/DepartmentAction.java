package org.whr.springmvc.ui.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.whr.springmvc.domain.Department;
import org.whr.springmvc.service.DepartmentService;
import org.whr.springmvc.utils.DepartmentUtil;

@Controller
@RequestMapping("/department")
public class DepartmentAction {
	@Resource
	private DepartmentService departmentService;
	@RequestMapping(value="list",method=RequestMethod.GET)
	public String list(Model model){
		List<Department> departments=departmentService.findAll();
		model.addAttribute("departments", departments);
		return "departmentAction/list";
	}
	@RequestMapping(value="addUI",method=RequestMethod.GET)
	public String addUI(Model model){
		Department d= new Department();
		List<Department> list=DepartmentUtil.getlist(departmentService.toTopList());
		Department head =new Department();
		head.setName("==«Î—°‘Ò==");
		head.setId(0);
		list.add(0, head);
		model.addAttribute("department", d);
		model.addAttribute("list", list);
		return "departmentAction/saveUI";
	}
	@RequestMapping(value="addUI",method=RequestMethod.POST)
	public String addUI(Department d,Model model,HttpServletRequest req){

		Department department=departmentService.findById(d.getId());
		if(department!=null){
			
			d.setParent(department);
		}
		departmentService.add(d);
		return "redirect:/department/list";
	}
	@RequestMapping(value="editUI",method=RequestMethod.GET)
	public String editUI(int id,Model model){
		List<Department> list=DepartmentUtil.getlist(departmentService.toTopList());
		Department head =new Department();
		
		Department d=departmentService.findById(id);
		model.addAttribute("department",d);
		model.addAttribute("list", list);
		return "departmentAction/saveUI";
	}
	@RequestMapping(value="editUI",method=RequestMethod.POST)
	public String editUI(Department d,Model model,HttpServletRequest req){
//		int id=(int) req.getAttribute("parent.id");
		Department department = departmentService.findById(d.getId());
		department.setName(d.getName());
		department.setPrescription(d.getPrescription());
		department.setParent(departmentService.findById(d.getParent().getId()));
		departmentService.update(department);
		return "redirect:/department/list";
	}
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String delete(int id){
		departmentService.delete(id);
		return "redirect:/department/list";
	}
}
