package com.tc.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	public String getAuthentication(EmpEntity entity, ModelMap map) {
		if (entity != null && (!entity.getEmpId().isEmpty())) {
			EmpEntity entity2 = service.autihentication(entity);
			if (entity2 != null) {
				map.addAttribute("name", entity2.getEmpName());
				return "welcome";
			} else {
				map.addAttribute("errMess", "invalid Data");

			}
		} else {
			map.addAttribute("errMess", "Enter Something");
		}

		return "login";
	}

}
