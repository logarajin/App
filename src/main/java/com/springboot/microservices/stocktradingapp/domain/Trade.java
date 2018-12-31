package com.springboot.microservices.stocktradingapp.domain;

import java.io.Serializable;
import java.util.List;

public class Trade implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -123786462799302458L;
	private String ticker;
	private Double price;
	private List<Trade> tradeList;
	
	private Double quantity;
	
	private Double balance;
	
	public Trade() {
	
	}

	public Trade(String ticker, Double price) {
		this.ticker = ticker;
		this.price = price;
	}

	 	

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public Double getPrice() {
		return price;
	}

   
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
	

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public List<Trade> getTradeList() {
		return tradeList;
	}

	public void setTradeList(List<Trade> tradeList) {
		this.tradeList = tradeList;
	}

	@Override
	public String toString() {
		return "User [ticker=" + ticker + ", price=" + price + ", balance=" + balance+"= ]";
	}
	
	
}