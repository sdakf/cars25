package pl.sda.cars25;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdasTest {

    List<String> animals = Arrays.asList("hamster", "pig", " dog ", " pig", null);

    Predicate<String> notNullPredicate = e -> e != null;
    Predicate<String> notNullPredicateAnonymousClass = new Predicate<String>() {
        @Override
        public boolean test(String s) {
            return s != null;
        }
    };
    Function<String, String> trimFunction = e -> e.trim();
    Function<String, String> trimFunctionAnonymous = new Function<String, String>() {
        @Override
        public String apply(String s) {
            return s.trim();
        }
    };

    Comparator<String> naturalOrderSorter = (a, b) -> a.compareTo(b);

    Function<String, Integer> stringToInteger = text -> Integer.parseInt(text);

    @Test
    void basicLambdas() {
        animals.stream()
                .filter(notNullPredicate)
                .map(trimFunction)
                .sorted(naturalOrderSorter)
                .forEach(System.out::println);
        animals.stream()
                .filter(notNullPredicate)
                .map(trimFunction)
                .sorted(naturalOrderSorter.reversed())
                .forEach(System.out::println);
    }

    @FunctionalInterface
    public interface MathOperation<T, U, R> {
        R calculate(T a, U b);

        default <X extends Number> Double addAnotherOne(X c) {
            return c.doubleValue() + 1;
        }

    }
//    public interface MathOperation2 {
//        double calculate(long a, long b);
//    }

    MathOperation<Integer, Long, Double> adder = (a, b) -> Double.valueOf(a + b);
    MathOperation<Integer, Integer, Integer> adder2 = (a, b) -> a + b;

    List<Integer> list;

    @Test
    void calulateTest() {
        double result = adder.addAnotherOne(adder.calculate(1, 2L));
    }

    @Test
    void kamilTest() {
        Function<String, String> addDot = a -> a + ".";
        Function<String, String> addParenthesis = a -> "(" + a + ")";
        System.out.println(decorateText("aaa", addDot));
        System.out.println(decorateText("aaa", addParenthesis));

    }

    private String decorateText(String text, Function<String, String> decorateTextFunction) {
        return decorateTextFunction.apply(text);
    }
}
