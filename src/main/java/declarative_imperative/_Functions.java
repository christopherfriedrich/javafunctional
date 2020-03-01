package declarative_imperative;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Class to demonstrate the usage of the {@link FunctionalInterface} {@link Function}
 * and of the {@link FunctionalInterface} {@link BiFunction}
 * @author Christopher Friedrich
 */
public class _Functions {

    public static void main(String[] args) {
        // Incremention Method (imperative)
        int incremented_imperative = incrementByOne(0);
        System.out.println(incremented_imperative);
        // Incremention Function (declarative)
        int incremented_declarative = incrementByOneFunction.apply(0);
        System.out.println(incremented_declarative);
        // Function Chaining vs. BiFunction
        System.out.println(incrementBy1AndMultiplyBy5.apply(1));
        System.out.println(incrementByOneAndMultiply.apply(1,5));
    }

    /**
     * Imperative method to increment a number by 1
     * @param number to be increased
     * @return the increased number
     */
    static int incrementByOne(int number) {
        return number+1;
    }

    /* --------------------------------------------------------------------------------|
     | Functions take one input parameter.                                             |
     | You have to specify of what type the input parameter and the return value are.  |
     |---------------------------------------------------------------------------------*/

    /**
     * Declarative approach to increment a number by 1
     */
    static Function<Integer, Integer> incrementByOneFunction = number -> number+1;
    /**
     * Declarative approach to multiply a number by 5
     */
    static Function<Integer, Integer> multiplyBy5 = number -> number * 5;

    /* ----------------------------------------------------------------|
     | Functions can be chained up.                                    |
     | The FunctionalInterface provides therefor the Method andThen(). |
     |-----------------------------------------------------------------*/

    /**
     * Declarative approach to first increment a number by 1 and the multiply it by 5
     * using chained {@link Function}
     */
    static Function<Integer, Integer> incrementBy1AndMultiplyBy5 = incrementByOneFunction.andThen(multiplyBy5);

    /* ------------------------------------------------------------------------|
     | Instead of chaining two Functions you also can use a BiFunction.        |
     | BiFunctions take two input parameter. You have to specify of what types |
     | the input parameters and the return value are.                          |
     |-------------------------------------------------------------------------*/

    /**
     * Declarative approach to first increment a number by 1 and the multiply it by any number
     * using a {@link BiFunction}
     */
    static BiFunction<Integer,Integer,Integer> incrementByOneAndMultiply = (inputNumber, multiplier) -> (inputNumber+1) * multiplier;

}
