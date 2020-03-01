package declarative_imperative;

import lib.Customer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Class to demonstrate the usage of the {@link FunctionalInterface} {@link Consumer}
 * and of the {@link FunctionalInterface} {@link BiConsumer}
 * @author Christopher Friedrich
 */
public class _Consumer {

    public static void main(String[] args) {
        Customer pascal = new Customer("Pascal", 12345678);
        // Imperative
        greetCustomer(pascal);
        // Declarative
        greetCustomerConsumer.accept(pascal);
    }

    /**
     * Imperative approach to take an {@link Customer} and print a sentence based on the customers parameters
     */
    static void greetCustomer(Customer customer){
        System.out.println("Hello "+customer.getName()+", thanks for registering phone number "+customer.getPhoneNumber());
    }

    /*------------------------------------------------------------------|
     | Consumer take one input parameter. It does not return a result,  |
     | but is expected to have side-effects.                            |
     |------------------------------------------------------------------*/

    /**
     * Declarative approach to take an {@link Customer} and print a sentence based on the customers parameters
     */
    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello "+customer.getName()+", thanks for registering phone number "+customer.getPhoneNumber());

    /*------------------------------------------------------------------|
     | BIConsumer take two input parameter.                             |
     |------------------------------------------------------------------*/

    /**
     * Declarative approach to take an {@link Customer} and print a sentence based on the customers parameters but
     * only print the Phone Number when the second input parameter is true.
     */
    static BiConsumer<Customer, Boolean> greetCustomerOptinalPhoneNumberConsumer = (customer, showPhoneNumber) ->
            System.out.println("Hello "+customer.getName()+", thanks for registering phone number "+(showPhoneNumber ? customer.getPhoneNumber() : "******"));


}
