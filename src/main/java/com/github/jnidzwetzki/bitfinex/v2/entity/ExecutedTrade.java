/*******************************************************************************
 *
 *    Copyright (C) 2015-2018 Jan Kristof Nidzwetzki
 *  
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License. 
 *    
 *******************************************************************************/
package com.github.jnidzwetzki.bitfinex.v2.entity;

import java.math.BigDecimal;

public class ExecutedTrade {
	
	private long id;
	private long timestamp;
	private BigDecimal amount;
	private BigDecimal price;
	private BigDecimal rate;
	private int period;
	
	public ExecutedTrade() {
	}
	
	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(final long timestamp) {
		this.timestamp = timestamp;
	}

	@Deprecated
	public double getAmount() {
		return amount.doubleValue();
	}
	
	public BigDecimal getAmountAsBigDecimal() {
		return amount;
	}

	public void setAmount(final double amount) {
		this.amount = BigDecimal.valueOf(amount);
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	@Deprecated
	public double getPrice() {
		return price.doubleValue();
	}
	
	public BigDecimal getPriceAsBigDecimal() {
		return price;
	}

	public void setPrice(final double price) {
		this.price = BigDecimal.valueOf(price);
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Deprecated
	public double getRate() {
		return rate.doubleValue();
	}
	
	public BigDecimal getRateAsBigDecimal() {
		return rate;
	}

	public void setRate(final double rate) {
		this.rate = BigDecimal.valueOf(rate);
	}
	
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(final int period) {
		this.period = period;
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ExecutedTrade [id=" + id + ", timestamp=" + timestamp + ", amount=" + amount + ", price=" + price
				+ ", rate=" + rate + ", period=" + period + "]";
	}

}
