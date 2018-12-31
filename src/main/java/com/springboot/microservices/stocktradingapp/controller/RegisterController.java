package com.springboot.microservices.stocktradingapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.microservices.stocktradingapp.domain.User;
import com.springboot.microservices.stocktradingapp.services.RegisterService;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private RegisterService registerService;

	@Autowired
	private HttpSession session;

	@RequestMapping("")
	public String redirToList() {
		return "redirect:/register/main";
	}

	@RequestMapping("/main")
	public String mainPage(Model model) {

		return "register/main";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		User user = new User();

		model.addAttribute("user", user);

		return "register/register";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public String saveEmployee(User user, Model model) {

		User savedUser = registerService.save(user);

		model.addAttribute("user", savedUser);
		return "/register/success";
	}

	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST, produces = "application/json")
	public String loginCheck(User user, Model model) {
System.out.println("RAMA HERE--->"+user);
		String result = registerService.getUser(user);

		model.addAttribute("result", result);

		if (result.equals("success")) {
			session.setAttribute("user", user);
			model.addAttribute("user", user);
			return "redirect:/trade/trade";
		} else {
			return "/register/error";
		}
	}

	@RequestMapping(value = "/loginCheck1", method = RequestMethod.POST)
	public String login(User user, Model model) {

		model.addAttribute("user", user);

		return "trade/trade";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		User user = new User();

		model.addAttribute("user", user);

		return "register/login";
	}

}