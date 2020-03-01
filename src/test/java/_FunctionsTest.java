import declarative_imperative._Functions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class _FunctionsTest {

    @Test
    public void incremention_returns_correct_values() {
        assertEquals(1, _Functions.incrementByOne(0));
        assertEquals(1, _Functions.incrementByOneFunction.apply(0));
        assertEquals(-2, _Functions.incrementByOne(-3));
        assertEquals(-2, _Functions.incrementByOneFunction.apply(-3));
    }

    @Test
    public void multiply_returns_correct_value(){
        assertEquals(25,_Functions.multiplyBy5.apply(5));
        assertEquals(50,_Functions.multiplyBy5.apply(10));
    }

    @Test
    public void incrementation_and_multiply_returns_correct_value(){
        assertEquals(5,_Functions.incrementBy1AndMultiplyBy5.apply(0));
        assertEquals(0,_Functions.incrementByOneAndMultiply.apply(10,0));
        assertEquals(5, _Functions.incrementByOneAndMultiply.apply(0,5));
        assertEquals(50,_Functions.incrementByOneAndMultiply.apply(4,10));
    }
}
