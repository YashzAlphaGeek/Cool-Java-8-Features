/**
 * 
 */
package com.yash.mobile.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import com.yash.mobile.manufacturer.MobileDesigner;
import com.yash.mobile.manufacturer.MobileManufacturer;
import com.yash.mobile.model.Mobile;

/**
 * @author Yashwanth
 *
 */
public class MobileDeveloper implements MobileManufacturer {

	List<Mobile> mobileList= new ArrayList<>();


	@Override
	public void addMobile(Mobile mobile) {
		mobileList.add(mobile);
	}

	@Override
	public List<Mobile> getAllMobile() {
		return mobileList;
	}

	@Override
	public void getAllMobileNamesInOrder(MobileDeveloper developer) {
		sortingOfMobileNames(developer);
	}
	
	
	/**
	 * Creation of Mobiles
	 * 
	 * @param developer 
	 * 
	 */
	public void createMobiles(MobileDeveloper developer) {
		developer.addMobile(new Mobile("Huawei Mate 40E", "GSM / CDMA / HSPA / CDMA2000 / LTE / 5G", "Available. Released 2021, March 18", 
				"Li-Po 4200 mAh, non-removable", "Android 10, EMUI 11, no Google Play Services", "Kirin 990E 5G (7 nm+)", 600));
		developer.addMobile(new Mobile("Huawei P40 4G", "GSM / HSPA / LTE", "Available. Released 2021, February 26", 
				"Li-Po 4200 mAh, non-removable", "Android 10, EMUI 11, no Google Play Services", "Kirin 990E 5G (7 nm+)", 500));
		developer.addMobile(new Mobile("Huawei Mate 40 RS Porsche Design", "GSM / HSPA / LTE / 5G", "Available. Released 2020, November 04", 
				"Li-Po 4200 mAh, non-removable", "Android 10, EMUI 11, no Google Play Services", "Kirin 990E 5G (7 nm+)", 300));
		developer.addMobile(new Mobile("Huawei Enjoy 20 5G", "GSM / CDMA / HSPA / CDMA2000 / LTE / 5G", "Available. Released 2021, March 18", 
				"Li-Po 4200 mAh, non-removable", "Android 10, EMUI 11, no Google Play Services", "Kirin 990E 5G (7 nm+)", 800));
		developer.addMobile(new Mobile("Huawei Enjoy Tablet 2", "GSM / CDMA / HSPA / CDMA2000 / LTE / 5G", "Available. Released 2021, March 18", 
				"Li-Po 4200 mAh, non-removable", "Android 10, EMUI 11, no Google Play Services", "Kirin 990E 5G (7 nm+)", 700));
	}




	/**
	 * Sorting Based on Mobile Name
	 * 
	 * Comparator Using Lambda Expression
	 * 
	 * @param developer
	 * @return 
	 */
	private  void sortingOfMobileNames(MobileDeveloper developer) {
		System.out.println("Comparator Using Lambda Expression");
		List<Mobile> allMobile = developer.getAllMobile();
		Collections.sort(allMobile, (firstMobile,secondMobile)->
		{
			return firstMobile.getMobileName().compareTo(secondMobile.getMobileName());	
		}
				);
		allMobile.forEach(mobile->System.out.println(mobile.getMobileName()));
	}



	@Override
	public void getAllMobileNames(MobileDeveloper developer) {
		getAllMobileName(developer);
	}
	
	
	/**
	 * Get All Mobiles
	 * 
	 * Iterable For Each with Lambda Expression
	 * 
	 * @param developer 
	 * @return 
	 */
	public void getAllMobileName(MobileDeveloper developer) {
		System.out.println("Iterable For Each Using Lambda Expression");
		developer.getAllMobile().forEach(mobile->System.out.println(mobile.getMobileName()));
	}

	/**
	 * Appending of Mobile Name And Color
	 * 
	 * Passing multiple Statement Using Lambda Expression
	 */
	public void appendingOfMobileNameAndColor(MobileDeveloper developer) {
		System.out.println("Passing multiple Statement Using Lambda Expression");
		String mobileName=developer.getAllMobile().get(0).getMobileName();
		MobileDesigner designer = (color)->
		{
			return mobileName+" "+color;
		};
		System.out.println(designer.appendMobileNameAndColor("Black"));
	}

	@Override
	public void getAllMobilesNameBasedOnPrice(MobileDeveloper developer) {
		filterMobileNamesBasedOnPrice(developer);
	}

	/**
	 * Filtering of Mobile Names Based on Price
	 * 
	 * Filtering Of Collection Data Using Lambda Expression
	 * 
	 * @param developer
	 */
	private void filterMobileNamesBasedOnPrice(MobileDeveloper developer) {
		System.out.println("Filtering Using Lambda Expression");
		Stream<Mobile> filterMobiles = developer.getAllMobile().stream().filter(mobile->mobile.getMobilePriceInEUR()>600);
		filterMobiles.forEach(mobile->System.out.println("Mobile Name:"+mobile.getMobileName() +" " +"Mobile Price:"+mobile.getMobilePriceInEUR()));
	}

}
