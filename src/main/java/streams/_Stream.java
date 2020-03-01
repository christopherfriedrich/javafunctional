package streams;

import lib.Gender;
import lib.Person;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class to demonstrate the usage of a {@link FunctionalInterface}
 * within a Java {@link java.util.stream.Stream}
 *
 * @author Christopher Friedrich
 */
public class _Stream {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Patrik", Gender.MALE),
                new Person("Patrica", Gender.FEMALE),
                new Person("Lili", Gender.FEMALE),
                new Person("Simon", Gender.MALE),
                new Person("Mark", Gender.MALE),
                new Person("Nicole", Gender.FEMALE)
        );
        getAllNames(people);
    }

    /**
     * Method to print all names of a {@link List} of {@link Person}
     * with the Java Stream API using <i>method reference</i> <br>
     * <b>Alternative</b>: <code>name ->System.out.println(name)</code>
     * @param people to print the names of
     */
    static void getAllNames(List<Person> people){
        people.stream()
                .map(person -> person.getName())
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

}
