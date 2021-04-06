/**
 * 
 */
package com.yash.mobile.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Yashwanth
 *
 */
@Getter
@Setter
@AllArgsConstructor
public class Mobile {

	private String mobileName;
	
	private String mobileNetworkTechnology;
	
	private String mobileLaunchStatus;

	private String mobileBatteryType;
	
	private String mobilePlatformOS;
	
	private String mobilePlatformChipSet;
	
	private long mobilePriceInEUR;
	
}
