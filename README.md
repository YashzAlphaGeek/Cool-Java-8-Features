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
  
  Calling of Static Method in Main Application
  
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
  
  Calling of Instance Method in Main Application
  
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
  
  Calling of Constructor in Main Application
  
  <pre><code>
    MobileTester tester=<b>MobileTesters::new</b>;
    tester.getCountOfTestedMobiles(developer);
  </code></pre>
  
   #### Outcome : :smiley:
   ![](https://github.com/YashzAlphaGeek/cool-java-8-features/blob/master/imgs/ReferencingToConstructor.png)
