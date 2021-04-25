## Cool Java-8 Features

Java 8 introduced a series of ground-breaking features for the language, that proved to be more than useful for the everyday life of Java developers.It improves application performance without any specific work or tuning.

## Features:
+ Lambda Expressions :scream: 
  + Iterable For Each with Lambda Expression
  + Passing multiple Statement Using Lambda Expression
  + Comparator Using Lambda Expression
  + Filtering Of Collection Data Using Lambda Expression
 + Method References :grinning:
   + Reference to a static method
   + Reference to instance method
   + Reference to constructor
 + Functional Interfaces :hushed:
 + Stream API's and Filter :grinning:


## Lambda Expression: :scream:
![](https://github.com/YashzAlphaGeek/cool-java-8-features/blob/master/imgs/Lambda_Expression.png)

Now lets us see about Lambda Expression usage with below examples
Lets develop a Mobile from scratch based on Mobile Manufacturer & Designer & Tester needs.
![](https://github.com/YashzAlphaGeek/cool-java-8-features/blob/master/imgs/Mobile_Development.png)

# When to use Lambda Expression :eyes:

## Iterable For each with Lambda Expression

As shown in the above image we have Mobile Manufacturer, Mobile Designer and Mobile Developer !

Now assume like Mobile Manufacturer comes to Mobile Developer and asks the Developer to <b>list out all the mobiles</b> created already.

<pre><code>
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
      <b>developer.getAllMobile().forEach(mobile->System.out.println(mobile.getMobileName()));</b>
    }
</code></pre>
  
#### Outcome : :smiley:
![](https://github.com/YashzAlphaGeek/cool-java-8-features/blob/master/imgs/Iterable_Lambda_Expression.png) 

 ## Passing multiple Statement Using Lambda Expression
 
 Now assume like Mobile Designer comes to Mobile Developer and asks the Developer <b>to append Mobile Name and Color for a single mobile</b>.
 
 <pre><code>
     /**
     * @author Yashwanth
     *
     */
    <b>@FunctionalInterface</b>
    public interface MobileDesigner {

    public String appendMobileNameAndColor(String color);

    }

    /**
     * Appending of Mobile Name And Color
     * 
     * Passing multiple Statement Using Lambda Expression
     */
    private static void appendingOfMobileNameAndColor(MobileDeveloper developer) {
    System.out.println("Passing multiple Statement Using Lambda Expression");
    String mobileName=developer.getAllMobile().get(0).getMobileName();
    <b>MobileDesigner designer = (color)->
    {
    return mobileName+" "+color;
    };
    System.out.println(designer.appendMobileNameAndColor("Black"));
    </b>
    }
 </code></pre>
 
 #### Outcome : :smiley:
 ![](https://github.com/YashzAlphaGeek/cool-java-8-features/blob/master/imgs/Appending_Mobile_Name_And_Color.png) 
 
 ## Comparator Using Lambda Expression
  
 Now assume like Mobile Manufacturer comes to Mobile Developer and asks the Developer <b>to list all mobiles names in ascending order</b>.
 
 <pre><code>
     /**
     * Sorting Based on Mobile Name
     * 
     * Comparator Using Lambda Expression
     * 
     * @param developer
     */
    private static void sortingOfMobileNames(MobileDeveloper developer) {
    System.out.println("Comparator Using Lambda Expression");
    List<Mobile> allMobile = developer.getAllMobile();
    <b>Collections.sort(allMobile, (firstMobile,secondMobile)->
    {
    return firstMobile.getMobileName().compareTo(secondMobile.getMobileName());
    }
    );
    allMobile.forEach(mobile->System.out.println(mobile.getMobileName()));</b>
    }
  </code></pre>
  
 #### Outcome : :smiley:
 ![](https://github.com/YashzAlphaGeek/cool-java-8-features/blob/master/imgs/Comparator_Sorting.png) 
 
 ## Filtering Of Collection Data Using Lambda Expression
  
 Now assume like Mobile Manufacturer comes to Mobile Developer and asks the Developer <b>to list all mobiles names and prices based on their price greater than 600EU</b>.
 
 <pre><code>
     /**
     * Filtering of Mobile Names Based on Price
     * 
     * Filtering Of Collection Data Using Lambda Expression
     * 
     * @param developer
     */
    private void filterMobileNamesBasedOnPrice(MobileDeveloper developer) {
    System.out.println("Filtering Using Lambda Expression");
    <b>Stream<Mobile> filterMobiles = developer.getAllMobile().stream().filter(mobile->mobile.getMobilePriceInEUR()>600);
    filterMobiles.forEach(mobile->System.out.println("Mobile Name:"+mobile.getMobileName() +" " +"Mobile Price:"+mobile.getMobilePriceInEUR()));</b>
    }
  </code></pre>
  
 #### Outcome : :smiley:
 ![](https://github.com/YashzAlphaGeek/cool-java-8-features/blob/master/imgs/Filtering_List.png) 
 
 
 ## Method References: :grinning:
![](https://github.com/YashzAlphaGeek/cool-java-8-features/blob/master/imgs/Method_References.png)

Now lets us see about Method References usage with below examples

# When to use Method References :eyes:

## Reference to Static Method

As shown in the above image we have Mobile Manufacturer, Mobile Designer, Mobile Tester and Mobile Developer !

Now assume like Mobile Manufacturer comes to Mobile Developer and asks the Developer to <b>list out all the mobiles based on status</b> created already.

### Syntax
  <pre><code>
  <b>ContainingClass::staticMethodName</b>
  </code></pre>
  
  Here is my code :
  <pre><code>
    /**
     * Filtering of Mobile Names Based on Status
     * 
     * Static Method Referencing
     * 
     * @param developer
     */
     public <b>static</b> void getAllMobileBasedOnStatus(Mobile mobile) {
     if(mobile.getMobileStatus().equalsIgnoreCase("Available"))
      {
      System.out.println("Mobile Name:"+mobile.getMobileName()+" "+"Status:"+mobile.getMobileStatus());
      }
      }
  </code></pre>
  
  Invoking of Static Method Reference
  
  <pre><code>
  developer.getAllMobile().forEach(<b>MobileDeveloper::getAllMobileBasedOnStatus</b>);
  </code></pre>

  #### Outcome : :smiley:
  ![](https://github.com/YashzAlphaGeek/cool-java-8-features/blob/master/imgs/ReferencingToStaticMethods.png)
  
  
  ## Reference to Instance Method
  
  Now assume like Mobile Manufacturer comes to Mobile Developer and asks the Developer to <b>list out all the mobiles based on battery capacity</b>.
  
  ### Syntax
  <pre><code>
  <b>ContainingObject::InstanceMethodName</b>
  </code></pre>
  
  Here is my code :
  <pre><code>
    /**
    * Filtering of Mobile Names Based on Battery Capacity
    *   
    * Static Method Referencing
    * 
    * @param developer
    */
    public <b>void</b> getAllMobileBasedOnBatteryCapacity(Mobile mobile) {
    if(mobile.getMobileBatteryCapacity()>4100)
    {
    System.out.println("Mobile Name:"+mobile.getMobileName()+"|"+"Mobile Battery Capacity:"+mobile.getMobileBatteryCapacity());
    }
    }
  </pre></code>
  
  Invoking of Instance Method Reference
  
  <pre><code>
  developer.getAllMobile().forEach(<b>developer::getAllMobileBasedOnBatteryCapacity</b>);
  </code></pre>
  
   #### Outcome : :smiley:
   ![](https://github.com/YashzAlphaGeek/cool-java-8-features/blob/master/imgs/ReferencingToInstanceMethods.png)
   
   
  ## Reference to Constructor
  
  Now assume like Mobile Tester comes to Mobile Developer and asks the Developer to <b>list out all the mobiles to test based on their status (Availability in Market)</b>.
  
  ### Syntax
  <pre><code>
  <b>className::new</b>
  </code></pre>
  
  Here is my code :
  <pre><code>
      /**
      * @author Yashwanth
      *
      */
      <b>@FunctionalInterface</b>
      public interface MobileTester {
      public MobileTesters getCountOfTestedMobiles(MobileDeveloper developer);
      }

      /**
      * @author Yashwanth
      *
      */
      public class MobileTesters {

      /**
      * Providing the count of tested mobiles
      */
      <b>public MobileTesters(MobileDeveloper developer)</b> {
      Stream<Mobile> filterMobiles = developer.getAllMobile().stream().filter(mobile->mobile.getMobileStatus().equalsIgnoreCase("Available"));
      System.out.println("Tested Mobile Count:"+filterMobiles.count());
      }
      }
  </code></pre>
  
  Invoking of Constructor 
  
  <pre><code>
    MobileTester tester=<b>MobileTesters::new</b>;
    tester.getCountOfTestedMobiles(developer);
  </code></pre>
  
   #### Outcome : :smiley:
   ![](https://github.com/YashzAlphaGeek/cool-java-8-features/blob/master/imgs/ReferencingToConstructor.png)

## Functional Interfaces: :hushed:
   ![](https://github.com/YashzAlphaGeek/cool-java-8-features/blob/master/imgs/Functional_Interfaces.png)
   
   # When to use Functional Interfaces :eyes:
   
   ## Predicate
   
   Now assume like Mobile Manufacturer comes to Mobile Developer and asks the Developer to <b>check for Huawei Enjoy 20 5G Mobile to increase the cost of the mobile</b>. 
  
   <pre><code>
       /**
       * Check For Huawai Enjoy Mobile
       *
       */
      @Override
      public void checkForHuaweiEnjoyMobile(<b>Predicate< Mobile > mobileCondition</b>) {
        System.out.println("Functional Interface - Predicate");
        for(Mobile mob:getAllMobile())
        {
          if(<b>mobileCondition.test(mob)</b>)
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
   </code></pre>
   
   Invoking of Predicate
   
   <pre><code>
      //Predicate - Provides True or False based on the Argument[Takes A Input] -> return (boolean) 
      <b>Predicate< Mobile > mobileConditionPredOne = mobile->mobile.getMobileName().equals("Huawei Enjoy 20 5G");</b>
      developer.checkForHuaweiEnjoyMobile(mobileConditionPredOne);
   </code></pre>
   
   #### Outcome : :smiley:
   ![](https://github.com/YashzAlphaGeek/cool-java-8-features/blob/master/imgs/Functional_Interfaces_Predicate.png)
   
   
   ## BiPredicate
   
   Now assume like Mobile Manufacturer comes to Mobile Developer and asks the Developer to <b>check for Huawei Enjoy 20 5G Mobile and Price equals 6000</b>. 
   
   <pre><code>
       /**
       * Check For Huawai Enjoy Mobile Name and Price Matching or Not
       * 
       * @param mobileConditionPredTwo
       */
      public void checkForHuaweiEnjoyMobileAndPrice(<b>BiPredicate< Mobile, Mobile > mobileCondition</b>) {
        System.out.println("Functional Interface - BiPredicate");
        for(Mobile mob:getAllMobile())
        {
          if(<b>mobileCondition.test(mob, mob)</b>)
          {
            System.out.println("BiPredicate returns "+mobileCondition.test(mob, mob));
            getAllDetailsOfMobile(mob);
            break;
          }
          else
          {
            //If Mobile Doesn't Exist - Return False
            System.out.println("BiPredicate returns "+mobileCondition.test(mob, mob));
          }
        }
        System.out.println();
      }
   </code></pre>
   
   Invoking of BiPredicate
   
   <pre><code>
     //BiPredicate - Provides True or False based on the Argument[Takes Two Input] -> return (boolean)
     <b>BiPredicate< Mobile, Mobile > mobileConditionPredTwo=(mobileName,mobilePrice)->mobileName.getMobileName().equals("Huawei Enjoy 20 5G") && mobilePrice.getMobilePriceInEUR()==6000;</b>
     developer.checkForHuaweiEnjoyMobileAndPrice(mobileConditionPredTwo);
   </code></pre>
   
   #### Outcome : :smiley:
   ![](https://github.com/YashzAlphaGeek/cool-java-8-features/blob/master/imgs/Functional_Interfaces_BiPredicate.png)
   
   
   ## Consumer
   
   Now assume like Mobile Manufacturer comes to Mobile Developer and asks the Developer to <b>list all mobile names with battery capacity</b>. 
   
   <pre><code>
      public void getAllMobileNameWithBatteryCapacity(<b>Consumer< Mobile > mobilesConsumer</b>,List<Mobile> mobileList)
      {
        System.out.println("Functional Interface - Consumer");
        getAllMobile().stream().forEach(mobile-><b>mobilesConsumer.accept(mobile)</b>);
        System.out.println();
      }
   </code></pre>
   
   Invoking of Consumer
   
   <pre><code>
       //Consumer - Performs an Operations by taking single input - Doesn't return anything (void)
        <b>Consumer< Mobile > mobileConsumer=(mob)->System.out.println("Mobile Name:"+mob.getMobileName(
            )+"|"+"Mobile Battery Capacity:"+mob.getMobileBatteryCapacity());</b> 
        developer.getAllMobileNameWithBatteryCapacity(mobileConsumer, developer.getAllMobile());
   </code></pre>
   
   #### Outcome : :smiley:
   ![](https://github.com/YashzAlphaGeek/cool-java-8-features/blob/master/imgs/Functional_Interfaces_Consumer.png)
   
   ## BiConsumer
   
   Now assume like Mobile Manufacturer comes to Mobile Developer and asks the Developer to <b>list all mobile names with increased battery capacity</b>. 
   
   <pre><code>
        /**
       * Get All Mobile Names With Increased Battery Capacity with 10
       * 
       * @param mobileBiConsumer
       * @param allMobile
       */
      public void getAllMobileNameWithIncreasedBatteryCapacity(<b>BiConsumer< Mobile, Long > mobileBiConsumer</b>,
          List<Mobile> allMobile) {
        System.out.println("Functional Interface - BiConsumer");
        Long increasedBat=Long.parseLong("10");
        getAllMobile().stream().forEach(mobile->
        {
        mobile.setMobileBatteryCapacity(mobile.getMobileBatteryCapacity()+increasedBat);
        <b>mobileBiConsumer.accept(mobile,increasedBat)</b>;
        });
        System.out.println();
      }
   </code></pre>
   
   Invoking of BiConsumer
   
   <pre><code>
     //BiConsumer - Performs an Operations by taking two input - Doesn't return anything (void)
      <b>BiConsumer< Mobile, Long > mobileBiConsumer=(mob,mobBattery)->System.out.println(mob.getMobileName()+"|"+mob.getMobileBatteryCapacity());</b>
      developer.getAllMobileNameWithIncreasedBatteryCapacity(mobileBiConsumer, developer.getAllMobile());   
    </code></pre>
   
   #### Outcome : :smiley:
   ![](https://github.com/YashzAlphaGeek/cool-java-8-features/blob/master/imgs/Functional_Interfaces_BiConsumer.png)
   
   ## Function
   
   Now assume like Mobile Manufacturer comes to Mobile Developer and asks the Developer to <b>check of mobiles for their price greater than 1K</b>. 
   
   <pre><code>
         /**
         * Check For Mobile Price Greater Than 1000K
         * 
         * @param mobileFunction
         * @param mobilePriceCheck
         */
        public void checkMobilePriceGreaterThan1K(List<Mobile> allMobile,
            <b>Function< Mobile, Boolean > mobilePriceCheck</b>) {
          System.out.println("Functional Interface - Function");
          allMobile.stream().forEach(mob->System.out.println("Mobile Name:"+mob.getMobileName()+"---->"+
              "Mobile Price:"+mob.getMobilePriceInEUR()+"---->"+<b>mobilePriceCheck.apply(mob)</b>));
          System.out.println();
        }
   </code></pre>
   
   Invoking of Function
   
   <pre><code>
      //Function - Performs an Operation with single input and provides expected result Function<T,R> T-Input & R-Result
      <b>Function< Mobile,Boolean > mobilePriceCheck=(mob)->mob.getMobilePriceInEUR()>1000;</b>
      developer.checkMobilePriceGreaterThan1K(developer.getAllMobile(),mobilePriceCheck);    
    </code></pre>
   
   #### Outcome : :smiley:
   ![](https://github.com/YashzAlphaGeek/cool-java-8-features/blob/master/imgs/Functional_Interfaces_Function.png)
   
   ## BiFunction
   
   Now assume like Mobile Manufacturer comes to Mobile Developer and asks the Developer to <b>check of mobiles for their price less than 5K and Status(Availability)</b>. 
   
   <pre><code>
       **
       * Check For Mobile Price Greater Than 5000K & Status - Availability
       * 
       * @param allMobile
       * @param mobilePriceAndStatusCheck
       */
      public void checkMobilePriceLessThan5kAndStatus(List<Mobile> allMobile,
          <b>BiFunction< Mobile, Mobile, Boolean > mobilePriceAndStatusCheck</b>) {
        System.out.println("Functional Interface - BiFunction");
        allMobile.stream().forEach(mob->System.out.println("Mobile Name:"+mob.getMobileName()+"---->"+
            "Mobile Price:"+mob.getMobilePriceInEUR()+"---->"+"Mobile Status:"+mob.getMobileStatus()+"---->"+<b>mobilePriceAndStatusCheck.apply(mob,mob)</b>));
        System.out.println();
      }
   </code></pre>
   
   Invoking of BiFunction
   
   <pre><code>
        //BiFunction - Performs an Operation with multiple input and provides expected result Function<T,R> T-Input & R-Result
        <b>BiFunction< Mobile, Mobile, Boolean > mobilePriceAndStatusCheck=(mobPrice,mobStatus)->mobPrice.getMobilePriceInEUR()<5000 && mobStatus.getMobileStatus().equalsIgnoreCase("Available");</b>
        developer.checkMobilePriceLessThan5kAndStatus(developer.getAllMobile(),mobilePriceAndStatusCheck);
    </code></pre>
   
   #### Outcome : :smiley:
   ![](https://github.com/YashzAlphaGeek/cool-java-8-features/blob/master/imgs/Functional_Interfaces_BiFunction.png)
   
   
   ## Supplier
   
   Now assume like Mobile Manufacturer comes to Mobile Developer and asks the Developer to <b>get Developer Name</b>. 
   
   <pre><code>
       /**
       * Returns Developer Name
       * 
       * @return
       */
      public static String <b>getDeveloperName()</b>
      {
        System.out.println("Functional Interface - Supplier");
        return "Developer::>Yashwanth";
      }
   </code></pre>
   
   Invoking of Supplier
   
   <pre><code>
      //Suppiler - Returns a value without any input
      <b>Supplier< String > mobiles=()->MobileDeveloper.getDeveloperName();</b>
      System.out.println(<b>mobiles.get()</b>);
    </code></pre>
    
   #### Outcome : :smiley:
   ![](https://raw.githubusercontent.com/YashzAlphaGeek/Cool-Java-8-Features/master/imgs/Functional_Interfaces_Supplier.png) 
    
## Stream API's and Filter: :scream:
![](https://github.com/YashzAlphaGeek/cool-java-8-features/blob/master/imgs/Stream_API's_And_Filters.png)

 ## Stream API and Filtering
  
 Now assume like Mobile Manufacturer comes to Mobile Developer and asks the Developer <b>to get top 1 maximum and minimum priced mobile name and price alone</b>.

<pre><code>
       /**
       * Get Max and Min Price Mobile
       */
      @Override
      public void getMaxPriceAndMinPriceMobile(MobileDeveloper developer) {
        getMaxAndMinPriceMobileDetail(developer.getAllMobile());
      }
      /**
       * Get Max and Min Price Mobile Details
       * 
       * @param allMobile
       */
        private void getMaxAndMinPriceMobileDetail(List<Mobile> allMobile) {
        Mobile maxPricedMobile =  allMobile.stream(). <b> max((firstMob,secondMob)->firstMob.getMobilePriceInEUR()>secondMob.getMobilePriceInEUR()?1:-1).get();<\b>
        Mobile minPricedMobile =  allMobile.stream(). <b> max((firstMob,secondMob)->firstMob.getMobilePriceInEUR()<secondMob.getMobilePriceInEUR()?1:-1).get();<\b>
        System.out.println("Highest Priced Mobile:");
        System.out.println("Mobile Name:"+maxPricedMobile.getMobileName()+"|"+"Mobile Price:"+maxPricedMobile.getMobilePriceInEUR());
        System.out.println("Lowest Priced Mobile:");
        System.out.println("Mobile Name:"+minPricedMobile.getMobileName()+"|"+"Mobile Price:"+minPricedMobile.getMobilePriceInEUR());
        System.out.println();
      }
</code></pre>

In the other hand, if you wanna filter see the mobile prices greater than 5000EU in map means

<pre><code>
  /**
     * Get Mobile Price & Name in Map
     * 
     * @param developer
     */
    public void getMaxMobliePriceAndNameInMap(MobileDeveloper developer) {
      Map<Long,String> productPriceMap =developer.getAllMobile().stream().<b> filter(mob->mob.getMobilePriceInEUR()>5000)</b>.collect(Collectors.<b>toMap(mob->mob.mobilePriceInEUR, mob->mob.mobileName) </b> );
      System.out.println(productPriceMap);
    }
</code></pre>

   #### Outcome : :smiley:
   ![](https://raw.githubusercontent.com/YashzAlphaGeek/Cool-Java-8-Features/master/imgs/Stream_API_And_Stream_Filter.png) 
