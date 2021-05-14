package com.inkesh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.inkesh.Electrical;
import com.inkesh.Painting;
import com.inkesh.PestControl;
import com.inkesh.Plumbing;
import com.inkesh.dao.CustomerDao;
import com.inkesh.dao.ElectricalDao;
import com.inkesh.dao.LoginDao;
import com.inkesh.dao.PaintingDao;
import com.inkesh.dao.PestControlDao;
import com.inkesh.dao.PlumbingDao;

import com.inkesh.Login;

import com.inkesh.Customer;

@Controller
public class HomeController {
	@Autowired
	ElectricalDao dao;// will inject dao from XML file

	@Autowired
	PlumbingDao dao1;// will inject dao from XML file

	@Autowired
	PestControlDao dao2;// will inject dao from XML file

	@Autowired
	PaintingDao dao3;// will inject dao from XML file

	@Autowired
	CustomerDao dao11;// will inject dao from XML file
	
	@Autowired
	LoginDao dao15;

	@RequestMapping("/")
	public String showPage() {
		return "MainMenu";
	}

	@RequestMapping("/home")
	public String homePage() {
		return "MainMenu";
	}
	
	@RequestMapping("/home1")
	public String homePage2() {
		return "MainMenu2";
	}

	@RequestMapping("/Services")
	public String ServicesForm() {
		return "Services";
	}

	@RequestMapping("/AboutUs")
	public String AboutUsForm() {
		return "About_Us";
	}

	@RequestMapping("/Contact_Us")
	public String ContactUsForm() {
		return "Contact_Us";
	}

	@RequestMapping("/user")
	public String showUserForm() {
		return "userform";
	}

	@RequestMapping("/login12")
	public String loginPage() {
		return "login";
	}

	@RequestMapping("/login11")
	public String login11Page() {
		return "MainMenu";
	}

	//@RequestMapping("/wish")
	//public String wishUser(HttpServletRequest request, Model model) {
		//String uname = request.getParameter("Username");
		//model.addAttribute("user", uname);
	//	return "wishUser";
	//}
	
	@RequestMapping("/wish")
		public String wishUser(HttpServletRequest request, Model model) {
			//String uname = request.getParameter("Username");
			//model.addAttribute("user", uname);
			return "wishUser";
		}

	/*
	 * It displays a form to input data, here "command" is a reserved request
	 * attribute which is used to display object data into form
	 */
	@RequestMapping("/Electrical")
	public String electricalPage(Model m) {
		m.addAttribute("command", new Electrical());
		return "electricalForm";
	}

	/*
	 * It saves object into database. The @ModelAttribute puts request data into
	 * model object. You need to mention RequestMethod.POST method because
	 * default request is GET
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("Electrical_table") Electrical Electrical_table) {
		dao.save(Electrical_table);
		return "wishUser";// will redirect to viewemp request mapping
	}

	@RequestMapping("/Plumbing")
	public String plumbingPage(Model n) {
		n.addAttribute("command", new Plumbing());
		return "plumbingForm";
	}/*
		 * It saves object into database. The @ModelAttribute puts request data
		 * into model object. You need to mention RequestMethod.POST method
		 * because default request is GET
		 */

	@RequestMapping(value = "/save1", method = RequestMethod.POST)
	public String save1(@ModelAttribute("Plumbing_table") Plumbing Plumbing_table) {
		dao1.save(Plumbing_table);
		return "wishUser";// will redirect to viewemp request mapping
	}

	@RequestMapping("/PestControl")
	public String PestControlPage(Model o) {
		o.addAttribute("command", new PestControl());
		return "pestControlForm";
	}/*
		 * It saves object into database. The @ModelAttribute puts request data
		 * into model object. You need to mention RequestMethod.POST method
		 * because default request is GET
		 */

	@RequestMapping(value = "/save2", method = RequestMethod.POST)
	public String save2(@ModelAttribute("PestControl_table") PestControl PestControl_table) {
		dao2.save(PestControl_table);
		return "wishUser";// will redirect to viewemp request mapping
	}

	@RequestMapping("/Painting")
	public String PaintingPage(Model p) {
		p.addAttribute("command", new Painting());
		return "paintingForm";
	}/*
		 * It saves object into database. The @ModelAttribute puts request data
		 * into model object. You need to mention RequestMethod.POST method
		 * because default request is GET
		 */

	@RequestMapping(value = "/save3", method = RequestMethod.POST)
	public String save3(@ModelAttribute("Painting_table") Painting Painting_table) {
		dao3.save(Painting_table);
		return "wishUser";// will redirect to viewemp request mapping
	}

	/*
	 * @RequestMapping("/Customerform") public String showform(Model m){
	 * m.addAttribute("command", new Customer()); return "Customerform"; }
	 */
	@RequestMapping("/Customerform")
	public String showform(Model m) {
		m.addAttribute("command", new Customer());
		return "Customerform";
	}

	/*
	 * It saves object into database. The @ModelAttribute puts request data into
	 * model object. You need to mention RequestMethod.POST method because
	 * default request is GET
	 */
	@RequestMapping(value = "/save11", method = RequestMethod.POST)
	public String save11(@ModelAttribute("cust") Customer cust) {
		dao11.save(cust);
		return "redirect:/";// will redirect to viewemp request mapping
	}

	
	  @RequestMapping(value = "/login", method = RequestMethod.GET) public
	  ModelAndView showLogin(HttpServletRequest request, HttpServletResponse
	  response) 
	  { 
		  ModelAndView mav = new ModelAndView("login");
		  mav.addObject("login",new Login());
	  
	  return mav;
	  
	  }
	 

	/*
	 * @RequestMapping("/login") public String loginform(Model m){
	 * m.addAttribute("login", new Login()); return "login"; }
	 */
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") Login login) {
		ModelAndView mav = null;
		Customer user = dao15.validateUser(login);
		if (null != user) {
			HttpSession session = request.getSession();
			session.setAttribute("username", user.getEmailC());
			session.setAttribute("firstname", user.getFname());
			mav = new ModelAndView("MainMenu2");
			mav.addObject("firstname", user.getFname());
		} else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or Password is wrong!!");
		}
		return mav;
	}

}
