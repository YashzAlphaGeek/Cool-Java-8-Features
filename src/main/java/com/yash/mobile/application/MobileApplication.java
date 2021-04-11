/**
 *  @author Yashwanth
 */
package com.yash.mobile.application;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.yash.mobile.manufacturer.MobileTester;
import com.yash.mobile.model.Mobile;
import com.yash.mobile.service.MobileDeveloper;
import com.yash.mobile.service.MobileTesters;

/**
 * @author Yashwanth
 *
 */
public class MobileApplication{

	public static void main(String[] args) {
		MobileDeveloper developer= new MobileDeveloper();
		lambdaExpression(developer);
		methodReferencing(developer);
		functionalInterfaces(developer);
	}

	/**
	 * Functional Interfaces
	 * 
	 * @param developer
	 */
	private static void functionalInterfaces(MobileDeveloper developer) {
		System.out.println("Functional Interface");
		//Predicate - Provides True or False based on the Argument[Takes A Input] -> return (boolean)
		Predicate<Mobile> mobileConditionPredOne = mobile->mobile.getMobileName().equals("Huawei Enjoy 20 5G");
		developer.checkForHuaweiEnjoyMobile(mobileConditionPredOne);
		//BiPredicate - Provides True or False based on the Argument[Takes Two Input] -> return (boolean)
		BiPredicate<Mobile, Mobile> mobileConditionPredTwo=(mobileName,mobilePrice)->mobileName.getMobileName().equals("Huawei Enjoy 20 5G") && mobilePrice.getMobilePriceInEUR()==6000;
		developer.checkForHuaweiEnjoyMobileAndPrice(mobileConditionPredTwo);
		//Consumer - Performs an Operations by taking single input - Doesn't return anything (void)
		Consumer<Mobile> mobileConsumer=(mob)->System.out.println("Mobile Name:"+mob.getMobileName(
				)+"|"+"Mobile Battery Capacity:"+mob.getMobileBatteryCapacity()); 
		developer.getAllMobileNameWithBatteryCapacity(mobileConsumer, developer.getAllMobile());
		//BiConsumer - Performs an Operations by taking two input - Doesn't return anything (void)
		BiConsumer<Mobile, Long> mobileBiConsumer=(mob,mobBattery)->System.out.println(mob.getMobileName()+"|"+mob.getMobileBatteryCapacity());
		developer.getAllMobileNameWithIncreasedBatteryCapacity(mobileBiConsumer, developer.getAllMobile());
		//Function - Performs an Operation with single input and provides expected result Function<T,R> T-Input & R-Result
		Function<Mobile,Boolean> mobilePriceCheck=(mob)->mob.getMobilePriceInEUR()>1000;
		developer.checkMobilePriceGreaterThan1K(developer.getAllMobile(),mobilePriceCheck);
		//BiFunction - Performs an Operation with multiple input and provides expected result Function<T,R> T-Input & R-Result
        BiFunction<Mobile, Mobile, Boolean> mobilePriceAndStatusCheck=(mobPrice,mobStatus)->mobPrice.getMobilePriceInEUR()<5000 && mobStatus.getMobileStatus().equalsIgnoreCase("Available");
        developer.checkMobilePriceLessThan5kAndStatus(developer.getAllMobile(),mobilePriceAndStatusCheck);
		//Suppiler - Returns a value without any input
		Supplier<String> mobiles=()->MobileDeveloper.getDeveloperName();
		System.out.println(mobiles.get());
		System.out.println();
	}

	/**
	 * Lambda Expressions 
	 * 
	 * @param developer - Developer
	 */
	private static void lambdaExpression(MobileDeveloper developer) {
		developer.createMobiles(developer);
		developer.getAllMobileNames(developer);
		System.out.println();
		developer.appendingOfMobileNameAndColor(developer);
		System.out.println();
		developer.getAllMobileNamesInOrder(developer);
		System.out.println();
		developer.getAllMobilesNameBasedOnPrice(developer);
		System.out.println();
	}

	/**
	 * 
	 * Method Referencing
	 * 
	 * @param developer - Developer
	 */
	private static void methodReferencing(MobileDeveloper developer) {
		System.out.println("Reference to Static Method");
		developer.getAllMobile().forEach(MobileDeveloper::getAllMobileBasedOnStatus);
		System.out.println();
		System.out.println("Reference to Instance Method(Non-Static Method)");
		developer.getAllMobile().forEach(developer::getAllMobileBasedOnBatteryCapacity);
		System.out.println();
		System.out.println("Reference to Constructor");
		MobileTester tester=MobileTesters::new;
		tester.getCountOfMobilesToBeTestedBasedOnStatus(developer);
		System.out.println();
	}

}
