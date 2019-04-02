package lambdasinaction.myowndemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {

    public static void main(String[] args) {

        System.out.println("********************** n*n ************************");
        final List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        final List<Integer> collect = integers.stream().map(n -> n * n).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("********************** print i j  ************************");

        final List<Integer> integers1 = Arrays.asList(1, 2, 3);
        final List<Integer> integers2 = Arrays.asList(3, 4, 5);
        final List<int[]> collect1 =
                integers1.stream()
                        .flatMap(i -> integers2.stream().map(j -> new int[]{i, j}))
                        .collect(Collectors.toList());


        collect1.forEach(ints -> {
            for (int i = 0; i < collect1.size(); i++) {
                System.out.println(ints[i]);
            }
        });

    }
}
