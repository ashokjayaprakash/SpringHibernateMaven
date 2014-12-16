package com.ionixx;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.ionixx.service.DataService;

@Controller
@SessionAttributes("name")
public class HomeController {
	
	@Autowired
	private DataService ds;

	@RequestMapping("/")
	public String getHome(@ModelAttribute("userData") UserPojo user,Map<String, Object> map){
		System.out.println("Page gets mapped"+ ds.listData().size());
		
		map.put("keys", ds.listData());
		return "home";
	}
	
	@RequestMapping(value="/data",method=RequestMethod.POST)
	public ModelAndView getHome1(@ModelAttribute("userData") UserPojo user, Model model){
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", user);
		mv.setViewName("redirect:welcome");
		System.out.println("Page1 gets mapped"+mv);
		ds.addData(user);
		return mv;
	}
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public String prg(@ModelAttribute("userData") UserPojo user, Model model,SessionStatus s) {
		return "welcome";
	}
	
	@RequestMapping("view/{id}")
	public String editData(@PathVariable("id") Integer id,Map<String, Object> map, @ModelAttribute("userData") UserPojo user) {
		System.out.println("View Page Called"+ds.editUser(id));
		map.put("userData",ds.editUser(id));
		return "welcome";
	}
	
	@RequestMapping("delete/{id}")
	public String deleteData(@PathVariable("id") Integer id,@ModelAttribute("userData") UserPojo user) {
		System.out.println("Delete User Id "+id);
		ds.deleteData(id);
		return "redirect:/";
	}
	
	@RequestMapping(value="view/update", method=RequestMethod.POST)
	public String updateData(@ModelAttribute("userData") UserPojo user) {
		System.out.println("View User Id "+user.getId() + user.getName());
		ds.updateData(user);
		return "redirect:/";
	}
	
}
