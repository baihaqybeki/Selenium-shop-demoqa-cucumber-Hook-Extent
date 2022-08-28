package com.shop.demoqa.cucumber.driver.strategies;

import com.shop.demoqa.cucumber.utils.Constants;

public class DriverStrategyImplementer {
	
	public static DriverStrategy chooseStrategy(String strategy) {
		switch(strategy) {
		case Constants.Chrome :
			return new Chrome();
		
		case Constants.Firefox :
			return new Firefox();
		
		default :
			return null;
		}
	}
	
}
