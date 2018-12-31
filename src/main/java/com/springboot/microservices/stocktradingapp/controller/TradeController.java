package com.springboot.microservices.stocktradingapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.microservices.stocktradingapp.domain.Trade;
import com.springboot.microservices.stocktradingapp.services.TradeService;

@Controller
@RequestMapping("/trade")
public class TradeController {

	@Autowired
	private TradeService tradeService;

	@Autowired
	private HttpSession session;

	@RequestMapping("")
	public String redirToList() {
		return "redirect:/trade/trade";
	}

	@RequestMapping("/trade")
	public String mainPage(HttpSession session, Model model) {
		Trade trade = new Trade();

		trade.setTradeList(tradeService.getTradeDetails());

		model.addAttribute("trade", trade);

		return "trade/trademain";
	}

	@RequestMapping("/add")
	public String add(Trade trade, Model model) {

		trade.setTradeList(tradeService.getTradeDetails());

		trade = tradeService.calculateTrade(trade);

		model.addAttribute("user", session.getAttribute("user"));

		model.addAttribute("trade", trade);

		return "trade/success";
	}

	@RequestMapping("/exit")
	public String exit() {
		return "/register/login/";
	}

}