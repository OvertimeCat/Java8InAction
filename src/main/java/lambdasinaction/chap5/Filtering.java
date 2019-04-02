package lambdasinaction.chap5;

import lambdasinaction.chap4.*;

import java.util.stream.*;
import java.util.*;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static lambdasinaction.chap4.Dish.menu;

public class Filtering {

    public static void main(String... args) {

        // Filtering with predicate
        System.out.println("**************Filtering with predicate****************");
        List<Dish> vegetarianMenu =
                menu.stream()
                        .filter(Dish::isVegetarian)
                        .collect(toList());

        vegetarianMenu.forEach(System.out::println);

        System.out.println("**************Filtering unique elements****************");
        // Filtering unique elements
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        System.out.println("**************Truncating a stream****************");
        // Truncating a stream
        List<Dish> dishesLimit3 =
                menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .limit(3)
                        .collect(toList());

        dishesLimit3.forEach(System.out::println);

        System.out.println("**************toSet Truncating a stream****************");
        // Truncating a stream

        final Set<Dish> collect = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(toSet());

        dishesLimit3.forEach(System.out::println);

        System.out.println("**************old elements****************");

        menu.forEach(System.out::println);
        System.out.println("**************Skipping elements****************");
        // Skipping elements
        List<Dish> dishesSkip2 =
                menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .skip(3)
                        .collect(toList());

        dishesSkip2.forEach(System.out::println);
    }
}
