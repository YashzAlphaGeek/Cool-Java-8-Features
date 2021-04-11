/**
 * 
 */
package com.yash.mobile.manufacturer;

import java.util.List;
import java.util.function.Predicate;

import com.yash.mobile.model.Mobile;
import com.yash.mobile.service.MobileDeveloper;

/**
 * @author Yashwanth
 *
 */
public interface MobileManufacturer {

	
	/**
	 * Create Mobiles
	 * 
	 * @param mobile
	 */
	public void addMobile(Mobile mobile);
	
	/**
	 * Get All Mobiles
	 * 
	 * @return
	 */
	public List<Mobile> getAllMobile();
	
	/**
	 * Get All Mobile Names
	 * 
	 * @param developer
	 */
	public void getAllMobileNames(MobileDeveloper developer);
	
	/**
	 * Get All Mobile Names In Order - Ascending
	 * 
	 * @param developer
	 */
	public void getAllMobileNamesInOrder(MobileDeveloper developer);
	
	/**
	 * Get All Mobiles Names Based on Price
	 * 
	 * @param developer
	 */
	public void getAllMobilesNameBasedOnPrice(MobileDeveloper developer);
	
	/**
	 * Check For Huawai Enjoy Mobile
	 * 
	 * @param mobile
	 */
	public void checkForHuaweiEnjoyMobile(Predicate<Mobile> mobile);
	
	/**
	 * Get All Details Of A Mobile
	 * 
	 * @param mobile
	 */
	public void getAllDetailsOfMobile(Mobile mobile);
	
}
