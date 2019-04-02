package lambdasinaction.myowndemo;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * lambda实体属性去重，对实体的某个属性进行去重
 *
 * Collectors.collectingAndThen
 */
public class TestCollectingAndThen {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            Person person = new Person();
            person.setAge(i);
            person.setName("xiaoming" + i);
            //待会儿筛选属性用到
            if (i % 10 == 0) {
                person.setAddress("shanghai10村");
            } else {
                person.setAddress("shanghai" + i + "村");
            }
            person.setCountry("中国" + i + "区");
            personList.add(person);
        }

        List<Person> distinctList = personList.stream().collect(
                Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getAddress()))),
                        ArrayList::new));

        distinctList.stream().forEach(System.out::println);
    }
}
