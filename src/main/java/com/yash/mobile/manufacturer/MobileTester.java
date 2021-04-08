/**
 * 
 */
package com.yash.mobile.manufacturer;

import com.yash.mobile.service.MobileDeveloper;
import com.yash.mobile.service.MobileTesters;

/**
 * @author Yashwanth
 *
 */
@FunctionalInterface
public interface MobileTester {

	public MobileTesters getCountOfMobilesToBeTestedBasedOnStatus(MobileDeveloper developer);
	
}
