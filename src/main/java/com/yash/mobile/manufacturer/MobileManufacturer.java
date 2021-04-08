/**
 * 
 */
package com.yash.mobile.manufacturer;

import java.util.List;
import com.yash.mobile.model.Mobile;
import com.yash.mobile.service.MobileDeveloper;

/**
 * @author Yashwanth
 *
 */
public interface MobileManufacturer {

	public void addMobile(Mobile mobile);
	
	public List<Mobile> getAllMobile();
	
	public void getAllMobileNames(MobileDeveloper developer);
	
	public void getAllMobileNamesInOrder(MobileDeveloper developer);
	
	public void getAllMobilesNameBasedOnPrice(MobileDeveloper developer);
	
	
}
