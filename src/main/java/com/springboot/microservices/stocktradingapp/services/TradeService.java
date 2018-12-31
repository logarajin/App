package com.springboot.microservices.stocktradingapp.services;

import java.util.List;

import com.springboot.microservices.stocktradingapp.domain.Trade;


public interface TradeService {
	List<Trade> getTradeDetails();
	
	Trade  calculateTrade(Trade trade);
}
