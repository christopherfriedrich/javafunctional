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

    public static void main(String[] args) {
        // Imperative approach
        System.out.println(isEmailValid("test@test.de"));
        System.out.println(isEmailValid("test@test.com"));
        // Declarative approach
        System.out.println(isEmailValidPredicate.test("test@test.de"));
        System.out.println(isEmailValidPredicate.test("test@test.com"));

        /*-------------------------------------|
        | Predicates can be chained up with    |
        | and, or and can be negated.          |
        |--------------------------------------*/

        System.out.println(isEmailValidPredicate.and(doesntStartsWithDot).test("test@test.de"));
        System.out.println(isEmailValidPredicate.or(doesntStartsWithDot).test(".test@test.de"));
        System.out.println(isEmailValidPredicate.negate().test("test@test.de"));

    }

    /**
     * Method to check whether an email has a valid format with an imperative approach
     * @param email to be verified
     * @return if the email is valid
     */
    static boolean isEmailValid(String email) {
        return email.contains("@") && email.endsWith(".de");
    }

    /*-------------------------------------|
    | Predicates take one input parameter. |
    | They return a boolean value.         |
    |--------------------------------------*/

    /**
     * Check whether an email has a valid format with an declarative approach using {@link Predicate}
     */
    static Predicate<String> isEmailValidPredicate = email -> email.contains("@") && email.endsWith(".de");

    /**
     *  Check whether an email starts with a dot with an declarative approach using {@link Predicate}
     */
    static Predicate<String> doesntStartsWithDot = email -> !email.startsWith(".");

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
        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.getGender());
        List<Person> females_declarative = people.stream()
                // Using your Predicate in a Stream
                .filter(personPredicate)
                .collect(Collectors.toList());
    }


}
