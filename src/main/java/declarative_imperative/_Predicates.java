package declarative_imperative;

import lib.Gender;
import lib.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Class to demonstrate the usage of the {@link FunctionalInterface} {@link Predicate}
 * @author Christopher Friedrich
 */
public class _Predicates {

    /**
     * Method to filter all {@link Person} with female gender in imperative way
     * @param people to filter
     */
    public static void filterImperative(List<Person> people){
        List<Person> females_imperative = new ArrayList<>();
        for (Person person: people) {
            if(Gender.FEMALE.equals(person.getGender())){
                females_imperative.add(person);
            }
        }
    }

    /**
     * Method to filter all {@link Person} with female gender in declarative way
     * @param people to filter
     */
    public static void filterDeclarative(List<Person> people) {
        /*-------------------------------------|
        | Predicates take one input parameter. |
        | They return a boolean value.         |
        |--------------------------------------*/
        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.getGender());
        List<Person> females_declarative = people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
    }


}
