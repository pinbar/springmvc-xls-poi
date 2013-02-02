package com.percipient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.percipient.bean.Student;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private Student student;

	@RequestMapping(value = "/html", produces = "application/xml")
	public String html(Model model) {
		student.setName("Corey Brown");
		model.addAttribute("stud", student);
		return "studentPage";
	}
	
	@RequestMapping("/beanToXlsSimple.xls")
	public ModelAndView beanToXlsSimple() {
		ModelAndView m = new ModelAndView("simpleStudXlsView");
		student.setName("Braxton Miller");
		m.getModelMap().addAttribute("stud", student);
		return m;
	}

	@RequestMapping("/beanToXlsRich.xls")
	public ModelAndView beanToXlsRich() {
		ModelAndView m = new ModelAndView("richStudXlsView");
		student.setName("Braxton Miller");
		m.getModelMap().addAttribute("stud", student);
		return m;
	}

}
