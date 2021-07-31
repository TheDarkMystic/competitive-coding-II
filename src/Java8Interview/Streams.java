package Java8Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author jakadam on 2020-09-25
 * https://www.javatpoint.com/java-8-stream
 */
public class Streams {
    public static void main(String[] args) {
        //inner class Product
        class Product {
            int id;
            String name;
            float price;

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public float getPrice() {
                return price;
            }

            public Product(int id, String name, float price) {
                this.id = id;
                this.name = name;
                this.price = price;
            }
        }

        //Populate a List with Products
        List<Product> prodList = new ArrayList<>();
        prodList.add(new Product(1, "HP Laptop", 25000f));
        prodList.add(new Product(2, "Dell Laptop", 30000f));
        prodList.add(new Product(3, "Lenevo Laptop", 28000f));
        prodList.add(new Product(4, "Sony Laptop", 28000f));
        prodList.add(new Product(5, "Apple Laptop", 90000f));

        /*
        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        */

        //Filtering the data without Stream
        System.out.println("\nFiltering the data without Stream");
        for (Product p : prodList) {
            if (p.price < 30000f) {
                System.out.println(p.price);
            }
        }

        //Filtering the data with Stream
        System.out.println("\nFiltering the data with Stream");
        List<Float> priceProdList = prodList.stream()//generate stream
                .filter(p -> p.price < 30000f) //filter the data
                .map(p -> p.price) //map product to price
                .collect(Collectors.toList()); //convert to list

        System.out.println(priceProdList);

        /*
        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        */

        /*
        Iterating using Stream

        You can use stream to iterate any number of times. Stream provides predefined methods to deal with the logic you
        implement. In the following example, we are iterating, filtering and passed a limit to fix the iteration.
        */
        System.out.println("\nIterating using Stream");
        Stream.iterate(1, i -> i + 1)
                .filter(ele -> ele % 5 == 0)
                .limit(6)
                .forEach(System.out::println);

         /*
        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        */

        // filtering and Iterating data
        System.out.println("\nFiltering and Iterating Collection");
        prodList.stream()
                .filter(p -> p.price > 30000)
                .forEach(p -> System.out.println(p.name + " " + p.price));


        /*
        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        */

        //Reduce operation with Stream

        /*
        This method takes a sequence of input elements and combines them into a single summary result by repeated operation.
        For example, finding the sum of numbers, or accumulating elements into a list.
        In the following example, we are using reduce() method, which is used to sum of all the product prices.
        */

        System.out.println("\nReduce Operation");
        float priceSum = prodList.stream()
                .map(p -> p.price)
                .reduce(0.0f, (sum, price) -> (sum + price));

        System.out.println("Price sum using reduce = " + priceSum);


        System.out.println("\nReduce Operation with method reference");
        priceSum = prodList.stream()
                .map(p -> p.price)
                .reduce(0.0f, Float::sum);

        System.out.println("Price sum using reduce = " + priceSum);

        /*
        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        */
        // Using Collectors's method to sum the prices.

        /*
        We can also use collectors to compute sum of numeric values. In the following example, we are using Collectors
        class and it?s specified methods to compute sum of all the product prices.
        */

        System.out.println("Using Collectors's method to sum the prices.");
        double priceSumDouble = prodList.stream()
                .collect(Collectors.summingDouble(product -> product.price));

        System.out.println(priceSumDouble);

        /*
        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        */

        //Count method using Streams

        System.out.println("\nCounting using Streams");

        float count = prodList.stream()
                .filter(p -> p.price > 30000)
                .count();

        System.out.println("Count of Products having prices greater than 30000 = " + count);

        /*
        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        */

        //Finding min max using streams
        System.out.println("\nFinding min and max using streams");

        Product minValProd = prodList.stream()
                .min((p1, p2) -> (p1.price < p2.price ? -1 : 1))
                .get();

        System.out.println("Product with min value = " + minValProd.name);
        Product maxValProd = prodList.stream()
                .max((p1, p2) -> (p1.price > p2.price ? 1 : -1))
                .get();
        System.out.println("Product with max value = " + maxValProd.name);

        /*
        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        */

        //List to Map using Streams
        System.out.println("\nList to Map using Streams");

        Map<Integer,String> map= prodList.stream()
                .collect(Collectors.toMap(p->p.id, p->p.name));
        System.out.println(map);

        /*
        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        */
        //Using method reference in Streams

        System.out.println("\nPrinting all product prices using Stream and Method references");
        prodList.stream()
                .map(Product::getPrice)
                .forEach(System.out::println);
    }
}
