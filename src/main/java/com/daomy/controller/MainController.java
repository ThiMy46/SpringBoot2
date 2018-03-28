package com.daomy.controller;

import java.lang.ProcessBuilder.Redirect;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daomy.model.Account;
import com.daomy.model.News;
import com.daomy.service.AccountService;
import com.daomy.service.NewsService;

@Controller
public class MainController {

	@Autowired
	private NewsService newsService;
	@Autowired
	private AccountService accService;
	
	@GetMapping("/")
	public String home(HttpServletRequest request){
		request.setAttribute("news", newsService.findAll());
		return "home";
	}
	
	@GetMapping("/newNews")
	public String NewNews(){
		return "NewNews";
	}
	
	@GetMapping("/admin")
	public String admin(HttpServletRequest request,HttpSession session){
		if(session.getAttribute("SESSION_FULL_NAME")==null)
		{
			request.setAttribute("news", newsService.findAll());
			return "home";
		}
		request.setAttribute("news", newsService.findAll());
		return "admin";
	}
	@GetMapping("/speaker")
	public String speaker(HttpServletRequest request){
		request.setAttribute("news", newsService.findAll());
		return "speakers";
	}
	@GetMapping("/contact")
	public String contact(HttpServletRequest request){
		request.setAttribute("news", newsService.findAll());
		return "contact";
	}
	
	@GetMapping("/gallery")
	public String gallery(HttpServletRequest request){
		request.setAttribute("news", newsService.findAll());
		return "gallery";
	}
	
	@GetMapping("/list_news")
	public String list_news(HttpServletRequest request){
		request.setAttribute("news", newsService.findAll());
		return "list_news";
	}
	
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	
	@PostMapping("/checkLogin")
	public String checkLogin(@RequestParam(required=false, name="accountname") String accountname, @RequestParam(required=false, name="password") String password,HttpSession session, ModelMap modelMap, HttpServletRequest request)
	{
		System.out.println("user: "+accountname+" pass: "+password);
		Account acc1=accService.findByAccountnameAndPassword(accountname, password);
		if(acc1==null){
			System.out.println("tên đăng nhập hoặc mật khẩu không đúng");
			modelMap.put("error", "Username and Password is wrong!!!");
			return "login";
		}
		System.out.println("tên đăng nhập hoặc mật khẩu đúng");
		session.setAttribute("SESSION_FULL_NAME", acc1.getAccountname());
		request.setAttribute("news", newsService.findAll());
		return "admin";
	}
	
	@GetMapping("/program")
	public String program(HttpServletRequest request){
		request.setAttribute("news", newsService.findAll());
		return "program";
	}
	@GetMapping("/venue_hotel")
	public String venue_hotel(HttpServletRequest request){
		request.setAttribute("news", newsService.findAll());
		return "venue_hotel";
	}
	
	@PostMapping("/save-news")
	public String saveNews(@Valid News news, BindingResult bindingResult,RedirectAttributes redirect){
			news.setDate_create(new Date(System.currentTimeMillis()));
			newsService.save(news);
			//request.setAttribute("news", newsService.findAll());
			redirect.addFlashAttribute("susscess","Save news susscessfully!!!");
			return "redirect:/admin";	
	}
	
	@GetMapping("/update-news")
	public String updateNews(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("news", newsService.findNews(id));
		return "NewNews";
	}
	
	@GetMapping("/delete-news")
	public String deleteTask(@RequestParam int id, HttpServletRequest request){
		newsService.delete(id);
		request.setAttribute("news", newsService.findAll());
		return "admin";
	}
	
}
