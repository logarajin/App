package com.springboot.microservices.stocktradingapp.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.springboot.microservices.stocktradingapp.domain.Trade;

@Service
public class TradeServiceImpl implements TradeService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private Double balance = new Double(100000);

	private static Map<String, Double> tradeMap = new HashMap<String, Double>();

	TradeServiceImpl() {
		tradeMap.put("WIPRO", 298.45);
		tradeMap.put("INFY", 949.95);
		tradeMap.put("TCS", 2713.70);
		tradeMap.put("TECHM", 485.8);
	}

	@Override
	public List<Trade> getTradeDetails() {

		List<Trade> tradelist = new ArrayList<Trade>();

		for (Entry<String, Double> entry : tradeMap.entrySet()) {

			Trade objTrade = new Trade(entry.getKey(), entry.getValue());
			tradelist.add(objTrade);
		}
		return tradelist;
	}

	@Override
	public Trade calculateTrade(Trade trade) {
		// TODO Auto-generated method stub

		Double price = tradeMap.get(trade.getTicker());

		balance = balance - (trade.getQuantity() * price);

		trade.setBalance(balance);
		return trade;
	}

}