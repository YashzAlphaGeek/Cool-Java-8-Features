/**
 * 
 */
package com.yash.mobile.service;

import java.util.stream.Stream;

import com.yash.mobile.model.Mobile;

/**
 * @author Yashwanth
 *
 */
public class MobileTesters {

	/**
	 * Providing the count of tested mobiles
	 */
	public MobileTesters(MobileDeveloper developer) {
		Stream<Mobile> filterMobiles = developer.getAllMobile().stream().filter(mobile->mobile.getMobileStatus().equalsIgnoreCase("Available"));
		System.out.println("Tested Mobile Count:"+filterMobiles.count());
	}

}
