package org.whr.springmvc.ui.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.whr.springmvc.domain.Role;
import org.whr.springmvc.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleAction {
	@Resource
	private RoleService roleService;
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model){
		List<Role> roles=roleService.findAll();
		model.addAttribute("roles", roles);
		return "roleAction/list";
	}
	@RequestMapping(value="{id}/delete" ,method=RequestMethod.GET)
	public String delete(@PathVariable int id){
		roleService.delete(id);
		return "redirect:/role/list";
	}
	@RequestMapping(value="/addUI",method=RequestMethod.GET)
	public String addUI(Model model){
		Role role = new Role();
		model.addAttribute("role", role);
		return"roleAction/saveUI";
	}
	@RequestMapping(value="/addUI",method=RequestMethod.POST)
	public String addUI(Role role){
		roleService.add(role);
		return"redirect:/role/list";
	}
	@RequestMapping(value="{id}/editUI",method=RequestMethod.GET)
	public String eitUI(@PathVariable int id,Model model){
		Role role=roleService.findById(id);
		model.addAttribute("role", role);
		return"roleAction/saveUI";
	}
	@RequestMapping(value="{id}/editUI",method=RequestMethod.POST)
	public String editUI(Role role){
		roleService.update(role);
		return"redirect:/role/list";
	}
}
