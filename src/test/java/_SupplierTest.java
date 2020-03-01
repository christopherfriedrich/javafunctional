import declarative_imperative._Supplier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class _SupplierTest {

    private static String api_url;
    private static List<String> greetings;

    @BeforeAll
    public static void setup() {
        api_url = "http://www.test.de/api/v1";
        greetings = List.of("Hello", "Hallo", "Bonjour");
    }

    @Test
    public void correct_url_is_returned() {
        assertEquals(api_url, _Supplier.getAPIUrlSupplier.get(), "Supplier returns wrong API Url.");
        assertEquals(api_url, _Supplier.getAPIUrl(), "Imperative Method returns wrong API Url.");
    }

    @Test
    public void supplier_and_imperative_function_return_equal_val(){
        assertEquals(_Supplier.getAPIUrl(), _Supplier.getAPIUrlSupplier.get(), "Missmatch between Supplier and imperative method");
    }

    @Test
    public void greeting_supplier_return_value_is_correct() {
        assertEquals(3,_Supplier.greetingsSupplier.get().size(), "Greetings Supplier returns wrong number of list elements");
        assertEquals(greetings,_Supplier.greetingsSupplier.get(), "Greetings Supplier returns wrong result");
    }

}
