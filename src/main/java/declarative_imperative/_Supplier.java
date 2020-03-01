package declarative_imperative;

import java.util.List;
import java.util.function.Supplier;

/**
 * Class to demonstrate the usage of the {@link FunctionalInterface} {@link Supplier}
 * @author Christopher Friedrich
 */
public class _Supplier {

    private static final String API_URL = "http://www.test.de/api/v1";

    public static void main(String[] args) {
        // Imperative Approach
        System.out.println(getAPIUrl());
        // Declarative Approach
        System.out.println(getAPIUrlSupplier.get());
        System.out.println(greetingsSupplier.get());
    }

    /**
     * Method to get an API URL using an imperative approach
     * @return the API URL
     */
    public static String getAPIUrl(){
        return API_URL;
    }

    /**
     * Declarative approach to get the API Url using a {@link Supplier}
     */
    public static Supplier<String> getAPIUrlSupplier = () -> API_URL;

    /*------------------------------------------|
     | Suppliers can return any type / object   |
     -------------------------------------------*/

    /**
     * Declarative approach to get a {@link List} of greetings in different languages
     * using a {@link Supplier}
     */
    public static Supplier<List<String>> greetingsSupplier = () -> List.of(
      "Hello", "Hallo", "Bonjour"
    );
}
