package com.tc.employeemanagement.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.tc.employeemanagement.entity.EmpEntity;
import com.tc.employeemanagement.service.EmpServiceImplementation;

@Controller
public class EmpController {

	@Autowired
	private EmpServiceImplementation service;

	@GetMapping("/register")
	public String getRegister() {
		return "register";
	}

	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}

	@PostMapping("/register")
	public String register(EmpEntity entity, ModelMap map) {
		if (entity != null) {
			if (service.register(entity)) {
				map.addAttribute("msg", "Successfully Register");
			} else {
				map.addAttribute("errmsg", "Error in register");
			}
		}
		return "register";
	}

	@PostMapping("/login")
	public String getAuthentication(EmpEntity entity, ModelMap map, HttpServletRequest request) {
		EmpEntity entity2 = service.autihentication(entity);
		System.out.println("entity from user" + entity + "----" + " entity from service-->" + entity2);
		if (entity2 != null) {
			HttpSession session = request.getSession(); // to start session
			session.setAttribute("loggedIn", entity2);
			session.setMaxInactiveInterval(500);
			map.addAttribute("name", entity2.getEmpName());
			return "welcome";
		} else {
			map.addAttribute("errmsg", "invalid Data");

		}
		return "login";
	}

	@PostMapping("/welcome")
	public String changeName(EmpEntity entity, ModelMap map) {
		if (entity != null) {

		}
		return "welcome";

	}

	@GetMapping("/delete")
	public String deleteView(ModelMap map, @SessionAttribute(name = "loggedIn", required = false) EmpEntity entity) {
		if (entity != null) {
			map.addAttribute("empId", entity.getEmpId());
			return "delete";
		}
		map.addAttribute("errmsg", "please Login");
		return "login";
	}

	@PostMapping("/delete")
	public String delete(ModelMap map, @SessionAttribute(name = "loggedIn", required = false) EmpEntity entity) {
		if (entity != null) {
			service.deleteEmployee(entity.getEmpId());
			map.addAttribute("errmsg", "Account deleted");
			return "register";
		}
		return "delete";
	}

	@GetMapping("/update")
	public String update(ModelMap map, @SessionAttribute(name = "loggedIn", required = false) EmpEntity entity) {

		if (entity != null) {
			map.addAttribute("entity", entity);
			return "update";
		}

		map.addAttribute("errmsg", "Please Login");
		return "login";

	}

	@PostMapping("/update")
	public String getUpdate(ModelMap map, @SessionAttribute(name = "loggedIn", required = false) EmpEntity entity,
			EmpEntity entity2) {
		String email = entity2.getEmpEmail();
		String name = entity2.getEmpName();
		String pass = entity2.getEmpPass();
		if (entity != null) {
			System.out.println(entity + "=======>" + entity2);
			service.updateEmployee(entity, email, name, pass);
			map.addAttribute("msg", "Your data is updated please Re-Login to check");
			map.addAttribute("entity", entity);
			return "update";
		}

		map.addAttribute("errmsg", "Please Login");
		return "login";

	}

	@GetMapping("/all")
	public String allEmployee(ModelMap map, @SessionAttribute(name = "loggedIn", required = false) EmpEntity entity) {
		       List list= service.allEmployeeService();
		       map.addAttribute("list",list);
				return "/all";
		
	}
	
	@PostMapping("/all")
	public String startEmployee(ModelMap map, @SessionAttribute(name = "loggedIn", required = false) EmpEntity entity,String value) {
		       List list= service.allEmployeeStarts(value);
		       map.addAttribute("list",list);
				return "/all";
		
	}

	@GetMapping("/logout")
	public String logout(ModelMap map, HttpSession session) {
		session.invalidate(); // to off the session
		map.addAttribute("errmsg", "Logged Out successfully!");
		return "login";

	}
	
	

}
