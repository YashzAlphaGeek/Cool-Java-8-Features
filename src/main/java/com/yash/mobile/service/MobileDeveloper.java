/**
 * 
 */
package com.yash.mobile.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
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

	/**
	 * Mobile Developer EmptyConstructor
	 */
	public MobileDeveloper() {
		//Empty Constructor
	}

	/**
	 * Mobile Developer Constructor
	 */
	public MobileDeveloper(String message) {
		System.out.println("Mobile Development is in Progress");
	}

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
		developer.addMobile(new Mobile("Huawei Mate 40E", "GSM / CDMA / HSPA / CDMA2000 / LTE / 5G", "Available", 
				4200, "Android 10, EMUI 11, no Google Play Services", "Kirin 990E 5G (7 nm+)", 600));
		developer.addMobile(new Mobile("Huawei P40 4G", "GSM / HSPA / LTE", "Available", 
				5100, "Android 10, EMUI 11, no Google Play Services", "Kirin 990E 5G (7 nm+)", 500));
		developer.addMobile(new Mobile("Huawei Mate 40 RS Porsche Design", "GSM / HSPA / LTE / 5G", "Available", 
				5100, "Android 10, EMUI 11, no Google Play Services", "Kirin 990E 5G (7 nm+)", 300));
		developer.addMobile(new Mobile("Huawei Enjoy 20 5G", "GSM / CDMA / HSPA / CDMA2000 / LTE / 5G", "Available", 
				4000, "Android 10, EMUI 11, no Google Play Services", "Kirin 990E 5G (7 nm+)", 800));
		developer.addMobile(new Mobile("Huawei Enjoy Tablet 2", "GSM / CDMA / HSPA / CDMA2000 / LTE / 5G", "Not-Available", 
				3100, "Android 10, EMUI 11, no Google Play Services", "Kirin 990E 5G (7 nm+)", 700));
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
		});
		allMobile.forEach(mobile->System.out.println(mobile.getMobileName()));
	}



	/**
	 * Get All Mobile Names
	 */
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
		filterMobiles.forEach(mobile->System.out.println("Mobile Name:"+mobile.getMobileName() +"|" +"Mobile Price:"+mobile.getMobilePriceInEUR()));
	}

	/**
	 * Filtering of Mobile Names Based on Status
	 * 
	 * Static Method Referencing
	 * 
	 * @param developer
	 */
	public static void getAllMobileBasedOnStatus(Mobile mobile) {
		if(mobile.getMobileStatus().equalsIgnoreCase("Available"))
		{
			System.out.println("Mobile Name:"+mobile.getMobileName()+"|"+"Status:"+mobile.getMobileStatus());
		}
	}


	/**
	 * Filtering of Mobile Names Based on Battery Capacity
	 * 
	 * Static Method Referencing
	 * 
	 * @param developer
	 */
	public  void getAllMobileBasedOnBatteryCapacity(Mobile mobile) {
		if(mobile.getMobileBatteryCapacity()>4100)
		{
			System.out.println("Mobile Name:"+mobile.getMobileName()+"|"+"Mobile Battery Capacity:"+mobile.getMobileBatteryCapacity());
		}
	}
	

	/**
	 * Check For Huawai Enjoy Mobile
	 *
	 */
	@Override
	public void checkForHuaweiEnjoyMobile(Predicate<Mobile> mobileCondition) {
		System.out.println("Functional Interface - Predicate");
		for(Mobile mob:getAllMobile())
		{
			if(mobileCondition.test(mob))
			{
				System.out.println("Predict returns "+mobileCondition.test(mob));
				increaseTheCostOfMobile();
				break;
			}
			else
			{
				//If Mobile Doesn't Exist - Return False
				System.out.println("Predict returns "+mobileCondition.test(mob));
			}
		}
		System.out.println();
	}
	
	/**
	 * Check For Huawai Enjoy Mobile Name and Price Matching or Not
	 * 
	 * @param mobileConditionPredTwo
	 */
	public void checkForHuaweiEnjoyMobileAndPrice(BiPredicate<Mobile, Mobile> mobileCondition) {
		System.out.println("Functional Interface - BiPredicate");
		for(Mobile mob:getAllMobile())
		{
			if(mobileCondition.test(mob, mob))
			{
				System.out.println("BiPredict returns "+mobileCondition.test(mob, mob));
				getAllDetailsOfMobile(mob);
				break;
			}
			else
			{
				//If Mobile Doesn't Exist - Return False
				System.out.println("BiPredict returns "+mobileCondition.test(mob, mob));
			}
		}
		System.out.println();
	}

	/**
	 * Increase the cost of the first mobile
	 */
	private void increaseTheCostOfMobile() {
		Mobile mobile = getAllMobile().stream().findFirst().get();
		mobile.setMobilePriceInEUR(6000);
		getAllDetailsOfMobile(mobile);
	}

	@Override
	public void getAllDetailsOfMobile(Mobile mobile) {
		System.out.println("Mobile Name:"+mobile.getMobileName());
		System.out.println("Mobile Network Technology:"+mobile.getMobileNetworkTechnology());
		System.out.println("Mobile Platform Chipset:"+mobile.getMobilePlatformChipSet());
		System.out.println("Mobile PlatformOS:"+mobile.getMobilePlatformOS());
		System.out.println("Mobile Battery Capacity(maH):"+mobile.getMobileBatteryCapacity());
		System.out.println("Mobile Status:"+mobile.getMobileStatus());
		System.out.println("Mobile Price(in EUR):"+mobile.getMobilePriceInEUR());
	}

	public void getAllMobileNameWithBatteryCapacity(Consumer<Mobile> mobilesConsumer,List<Mobile> mobileList)
	{
		System.out.println("Functional Interface - Consumer");
		getAllMobile().stream().forEach(mobile->mobilesConsumer.accept(mobile));
		System.out.println();
	}

	
	/**
	 * Get All Mobile Names With Increased Battery Capacity with 10
	 * 
	 * @param mobileBiConsumer
	 * @param allMobile
	 */
	public void getAllMobileNameWithIncreasedBatteryCapacity(BiConsumer<Mobile, Long> mobileBiConsumer,
			List<Mobile> allMobile) {
		System.out.println("Functional Interface - BiConsumer");
		Long increasedBat=Long.parseLong("10");
		getAllMobile().stream().forEach(mobile->
		{
		mobile.setMobileBatteryCapacity(mobile.getMobileBatteryCapacity()+increasedBat);
		mobileBiConsumer.accept(mobile,increasedBat);
		});
		System.out.println();
	}

	/**
	 * Check For Mobile Price Greater Than 1000K
	 * 
	 * @param mobileFunction
	 * @param mobilePriceCheck
	 */
	public void checkMobilePriceGreaterThan1K(List<Mobile> allMobile,
			Function<Mobile, Boolean> mobilePriceCheck) {
		System.out.println("Functional Interface - Function");
		allMobile.stream().forEach(mob->System.out.println("Mobile Name:"+mob.getMobileName()+"---->"+
				"Mobile Price:"+mob.getMobilePriceInEUR()+"---->"+mobilePriceCheck.apply(mob)));
		System.out.println();
	}


	/**
	 * Returns Developer Name
	 * 
	 * @return
	 */
	public static String getDeveloperName()
	{
		System.out.println("Functional Interface - Supplier");
		return "Developer::>Yashwanth";
	}

	/**
	 * Check For Mobile Price Greater Than 5000K & Status - Availability
	 * 
	 * @param allMobile
	 * @param mobilePriceAndStatusCheck
	 */
	public void checkMobilePriceLessThan5kAndStatus(List<Mobile> allMobile,
			BiFunction<Mobile, Mobile, Boolean> mobilePriceAndStatusCheck) {
		System.out.println("Functional Interface - BiFunction");
		allMobile.stream().forEach(mob->System.out.println("Mobile Name:"+mob.getMobileName()+"---->"+
				"Mobile Price:"+mob.getMobilePriceInEUR()+"---->"+"Mobile Status:"+mob.getMobileStatus()+"---->"+mobilePriceAndStatusCheck.apply(mob,mob)));
		System.out.println();
	}



}
