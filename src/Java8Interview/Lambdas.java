package Java8Interview;

/**
 * @author jakadam on 2020-09-25
 * <p>
 * https://www.javatpoint.com/java-lambda-expressions
 * <p>
 * Lambda expression provides implementation of functional interface. An interface which has only one abstract method is called functional interface.
 * Java provides an annotation @FunctionalInterface, which is used to declare an interface as functional interface.
 * <p>
 * https://www.javatpoint.com/java-lambda-expressions
 * <p>
 * Lambda expression provides implementation of functional interface. An interface which has only one abstract method is called functional interface.
 * Java provides an annotation @FunctionalInterface, which is used to declare an interface as functional interface.
 * <p>
 * https://www.javatpoint.com/java-lambda-expressions
 * <p>
 * Lambda expression provides implementation of functional interface. An interface which has only one abstract method is called functional interface.
 * Java provides an annotation @FunctionalInterface, which is used to declare an interface as functional interface.
 */

/**
 * https://www.javatpoint.com/java-lambda-expressions
 * <p>
 * Lambda expression provides implementation of functional interface. An interface which has only one abstract method is called functional interface.
 * Java provides an annotation @FunctionalInterface, which is used to declare an interface as functional interface.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Why use Lambda Expression
 * -To provide the implementation of Functional interface.
 * -Less coding.
 *
 * Java Lambda Expression Syntax
 * (argument-list) -> {body}
 *
 * Java lambda expression is consisted of three components.
 *
 * 1) Argument-list: It can be empty or non-empty as well.
 *
 * 2) Arrow-token: It is used to link arguments-list and body of expression.
 *
 * 3) Body: It contains expressions and statements for lambda expression.
 *
 * No Parameter Syntax
 *
 * () -> {
 * //Body of no parameter lambda
 * }
 *
 * One Parameter Syntax
 *
 * (p1) -> {
 * //Body of single parameter lambda
 * }
 *
 * Two Parameter Syntax
 *
 * (p1,p2) -> {
 * //Body of multiple parameter lambda
 * }
 *
 *
 * Let's see a scenario where we are not implementing Java lambda expression. Here, we are implementing an interface
 * without using lambda expression.
 */

@FunctionalInterface
interface Drawable {
    public void draw();
}

@FunctionalInterface
interface Sayable {
    public String say(String name);
}

@FunctionalInterface
interface Addable {
    public int add(int a, int b);
}

@FunctionalInterface
interface Messagable {
    public String message(String message);
}

public class Lambdas {
    public static void main(String[] args) {
        System.out.println("This is a Lambda Tutorial");

        //Implementing Interface with Anonymous innerclass w/o lambdas
        System.out.println("\n+++++ Implementing Interface with Anonymous innerclass w/o lambdas +++++");

        Drawable obj1 = new Drawable() {
            @Override
            public void draw() {
                System.out.println("overriden draw() without lamdas!\n");
            }
        };

        obj1.draw();

        //Implementing Interface w/o Anonymous innerclass with lambdas
        System.out.println("\n+++++ Implementing Interface w/o Anonymous innerclass with lambdas +++++");

        Drawable obj2 = () -> {
            System.out.println("overriden draw() with lamdas!\n");
        };

        obj2.draw();

        /*
        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         */

        //Implementing no parameter lambda

        System.out.println("\n+++++ Implementing no parameter lambda +++++");

        // since the implementation contains single statement, we can omit the curly braces
        Drawable obj3 = () -> System.out.println("Implementing no parameter lambda");


        obj3.draw();

        /*
        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         */
        //Implementing single parameter lambda

        System.out.println("\n+++++ Implementing single parameter lambda +++++");


        Sayable obj4 = (name) -> {
            return "Hello" + name;
        };

        System.out.println(obj4.say("Jay!"));

        //we can rewrite the same lambda expression with  omit function  parenthesis

        Sayable obj5 = name -> {
            return "Hello" + name;
        };

        System.out.println(obj5.say("Jay!"));

        /*
        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         */
        System.out.println("\n+++++ Implementing multiple parameter lambda +++++");

        Addable obj6 = (a, b) -> {
            return a + b;
        };

        System.out.println(obj6.add(5, 9));


        /*
        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         */
        /*
        Note:   In Java lambda expression, if there is only one statement, you may or may not use return keyword.
                You must use return keyword when lambda expression contains multiple statements.
         */
        System.out.println("\n+++++ Implementing lambda with or without lambda +++++");

        Addable obj7 = (a, b) -> (a + b);

        System.out.println(obj7.add(5, 9));

        //same lambda has been implemented with return in previous example.

        /*
        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         */
        System.out.println("\n+++++ Implementing lambda in forEach loop +++++");

        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("pqr");
        list.add("lmn");
        list.add("xyz");

        list.forEach((str) -> System.out.println(str));

        /*
        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         */
        System.out.println("\n+++++ Implementing lambda with multiple statements +++++");

        Messagable obj8 = (msg) -> {
            System.out.println("Implementing Messagable interface with lambda");
            return msg + " Jay!";
        };

        System.out.println(obj8.message("Hello"));

        /*
        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         */

        /*
        You can use lambda expression to run thread. In the following example, we are implementing run method by using
        lambda expression.
         */
        System.out.println("\n+++++ Implementing Thread with and without lambda +++++");

        //Thread without lambda
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread_1 is Running...");
            }
        };

        Thread t1 = new Thread(r1);
        t1.run();

        //Thread with lambda
        Runnable r2 = () -> System.out.println("Thread_2 is Running...");
        Thread t2 = new Thread(r2);
        t2.run();

         /*
        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         */

        /*
        Java lambda expression can be used in the collection framework. It provides efficient and concise way to iterate,
        filter and fetch data. Following are some lambda and collection examples provided.
         */
        System.out.println("\n+++++ Implementing Comparator with and without lambda +++++");

        //inner class
        class Product {
            int id;
            String name;
            float price;

            public Product(int id, String name, float price) {
                super();
                this.id = id;
                this.price = price;
                this.name = name;
            }
        }

        List<Product> list2 = new ArrayList<>();
        list2.add(new Product(3, "Three", 3.0f));
        list2.add(new Product(1, "One", 1.0f));
        list2.add(new Product(2, "Two", 2.0f));

        //Comparator without lambda
        //sort ascending on price
        System.out.println("\nsort ascending on price\n");
        Collections.sort(list2, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.price < o2.price)
                    return -1;
                else if (o1.price > o2.price)
                    return 1;
                return 0;
            }
        });

        list2.forEach((o) -> {
            System.out.println(o.id + " " + o.name + " " + o.price);
        });

        //Comparator with lambda
        //sort descending on price
        System.out.println("\nsort descending on price\n");
        Collections.sort(list2, (o1, o2) -> {
            if (o1.price < o2.price)
                return 1;
            else if (o1.price > o2.price)
                return -1;
            return 0;
        });

        list2.forEach((o) -> {
            System.out.println(o.id + " " + o.name + " " + o.price);
        });

         /*
        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         */
        //Filter Collections data using Stream and Lambda
        System.out.println("\n+++++ Filter Collections data using Stream and Lambda +++++");

        //Filtering using stream and lambda
        Stream<Product> filtered_list = list2.stream().filter(product -> (product.price > 1.0f));

        //printing filtered data using lambda
        filtered_list.forEach(product -> System.out.println(product.id + " " + product.name + " " + product.price));

    }
}
