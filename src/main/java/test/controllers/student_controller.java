package test.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import test.dao.studentdao;
import test.model.student;


@Controller
public class student_controller {
	
	@Autowired
	studentdao dao;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String registration(@ModelAttribute("stud")student stud){
		dao.save_data(stud);
		
		return "redirect:/welcome"; //page URL
	}
	
	@RequestMapping("/welcome")
	public String wel(Model m) {//We use Model to pass data to other page
		List<student> list = dao.getallstudents();
		m.addAttribute("list",list);//passing data while loading welcome.jsp in the form of list
		return "welcome"; //welcome.jsp (page name)
	}
	
	@RequestMapping(value="/deletestud/{id}",method=RequestMethod.GET)
	public String deletestud(@PathVariable int id) { //@PathVariable is used to get value from URL
		dao.delete_data(id);
		
		return "redirect:/welcome";
	}
	
	@RequestMapping("/edit")
	public String edit() {
		return "edit"; //file.jsp
	}
	
	@RequestMapping(value="/editstud/{id}",method=RequestMethod.GET)
	public String getstud(@PathVariable int id,Model m) { //@PathVariable is used to get value from URL
		student s = dao.getstud(id);
		m.addAttribute("command",s);
		return "edit";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updatestud(@ModelAttribute("stud")student stud){
		dao.updatestud(stud);
		
		return "redirect:/welcome"; //page URL	
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login"; //login.jsp
	}
	
	@RequestMapping("/dashboard")
	public String dashboard() {
		return "dashboard"; //dashboard.jsp
	}
	
	
}
