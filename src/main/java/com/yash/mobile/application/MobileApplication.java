/**
 * 
 */
package com.yash.mobile.application;

import com.yash.mobile.service.MobileDeveloper;

/**
 * @author Yashwanth
 *
 */
public class MobileApplication{


	public static void main(String[] args) {
		MobileDeveloper developer= new MobileDeveloper();
		developer.createMobiles(developer);
		developer.getAllMobileNames(developer);
		System.out.println();
		developer.appendingOfMobileNameAndColor(developer);
		System.out.println();
		developer.getAllMobileNamesInOrder(developer);
		System.out.println();
		developer.getAllMobilesNameBasedOnPrice(developer);
	}
	
	
}
