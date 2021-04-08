/**
 *  @author Yashwanth
 */
package com.yash.mobile.application;

import com.yash.mobile.manufacturer.MobileTester;
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
	}

}
