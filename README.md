## Cool Java-8 Features

Java 8 came out early last year—and Java 7 is now end of life—making Java 8 the only Oracle-supported option until Java 9 comes out at the end of next year. 
However, since organizations value stability over trendiness, many of us are still working with Java 7, or even 6. 

Java 8 introduced a series of ground-breaking features for the language, that proved to be more than useful for the everyday life of Java developers.

## Features:
+ Lambda Expressions
  + Iterable For Each with Lambda Expression
  + Passing multiple Statement Using Lambda Expression
  + Comparator Using Lambda Expression
  + Filtering Of Collection Data Using Lambda Expression

## Lambda Expression:
![](https://github.com/YashzAlphaGeek/cool-java-8-features/blob/master/imgs/Lambda_Expression.png)

Now lets us see about Lambda Expression usage with below examples
Lets develop a Mobile from scratch based on Mobile Manufacturer & Designer needs.
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
 

