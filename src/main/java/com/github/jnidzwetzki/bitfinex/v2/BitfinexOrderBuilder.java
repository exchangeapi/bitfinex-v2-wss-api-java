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
package com.github.jnidzwetzki.bitfinex.v2;

import java.math.BigDecimal;

import com.github.jnidzwetzki.bitfinex.v2.entity.BitfinexCurrencyPair;
import com.github.jnidzwetzki.bitfinex.v2.entity.BitfinexOrder;
import com.github.jnidzwetzki.bitfinex.v2.entity.BitfinexOrderType;

public class BitfinexOrderBuilder {

	private final BitfinexCurrencyPair symbol; 
	private final BitfinexOrderType type;
	private final BigDecimal amount;
	
	private BigDecimal price = BigDecimal.valueOf(-1);
	private BigDecimal priceTrailing = BigDecimal.valueOf(-1);
	private BigDecimal priceAuxLimit = BigDecimal.valueOf(-1);
	private boolean postOnly = false;
	private boolean hidden = false;
	private int groupid = -1;

	private BitfinexOrderBuilder(final BitfinexCurrencyPair symbol, final BitfinexOrderType type, 
			BigDecimal amount) {
		
		this.symbol = symbol;
		this.type = type;
		this.amount = amount;
	}
	
	public static BitfinexOrderBuilder create(final BitfinexCurrencyPair symbol, final BitfinexOrderType type, 
			final double amount) {
		
		return new BitfinexOrderBuilder(symbol, type, BigDecimal.valueOf(amount));
	}
	
	public static BitfinexOrderBuilder create(final BitfinexCurrencyPair symbol, final BitfinexOrderType type, 
			String amount) {
		
		return new BitfinexOrderBuilder(symbol, type, new BigDecimal(amount));
	}
	
	public BitfinexOrderBuilder setHidden() {
		hidden = true;
		return this;
	}
	
	public BitfinexOrderBuilder setPostOnly() {
		postOnly = true;
		return this;
	}
	
	@Deprecated
	public BitfinexOrderBuilder withPrice(final double price) {
		this.price = BigDecimal.valueOf(price);
		return this;
	}
	
	public BitfinexOrderBuilder withPrice(BigDecimal price) {
		this.price = price;
		return this;
	}
	
	public BitfinexOrderBuilder withPrice(String price) {
		this.price = new BigDecimal(price);
		return this;
	}
	
	@Deprecated
	public BitfinexOrderBuilder withPriceTrailing(final double price) {
		this.priceTrailing = BigDecimal.valueOf(price);
		return this;
	}
	
	public BitfinexOrderBuilder withPriceTrailing(BigDecimal price) {
		this.priceTrailing = price;
		return this;
	}
	
	public BitfinexOrderBuilder withPriceTrailing(String price) {
		this.priceTrailing = new BigDecimal(price);
		return this;
	}
	
	@Deprecated
	public BitfinexOrderBuilder withPriceAuxLimit(final double price) {
		this.priceAuxLimit = BigDecimal.valueOf(price);
		return this;
	}
	
	public BitfinexOrderBuilder withPriceAuxLimit(BigDecimal price) {
		this.priceAuxLimit = price;
		return this;
	}
	
	public BitfinexOrderBuilder withPriceAuxLimit(String price) {
		this.priceAuxLimit = new BigDecimal(price);
		return this;
	}
	
	public BitfinexOrderBuilder withGroupId(final int groupId) {
		this.groupid = groupId;
		return this;
	}
	
	public BitfinexOrder build() {
		return new BitfinexOrder(symbol, type, price, 
				amount, priceTrailing, priceAuxLimit, postOnly, hidden, groupid);
	}

}
