import org.junit.jupiter.api.Test;

import static declarative_imperative._Predicates.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class _PredicatesTest {

    @Test
    public void correct_values_are_returned_for_imperative_and_supplier(){
        assertEquals(true,isEmailValid("test@test.de"));
        assertEquals(false,isEmailValid("test@test.com"));
        assertEquals(true,isEmailValidPredicate.test("test@test.de"));
        assertEquals(false,isEmailValidPredicate.test("test@test.com"));
        assertEquals(true,doesntStartsWithDot.test("test@test.de"));
        assertEquals(false,doesntStartsWithDot.test(".test@test.de"));
    }

    @Test
    public void predicate_chaining_returns_correct_values(){
        assertEquals(true,isEmailValidPredicate.and(doesntStartsWithDot).test("test@test.de"));
        assertEquals(true,isEmailValidPredicate.or(doesntStartsWithDot).test(".test@test.de"));
    }

    @Test
    public void predicate_negotiation_returns_correct_values(){
        assertEquals(false,isEmailValidPredicate.negate().test("test@test.de"));
    }
}
