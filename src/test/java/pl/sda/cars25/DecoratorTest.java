package pl.sda.cars25;

import org.junit.jupiter.api.Test;

public class DecoratorTest {

    @Test
    void decorator() {
        TextProvider baseTextProvider = new BaseTextProvider("Adam Nowak");
        TextProvider anythingWithDotProvider = new AnythingWithDotProvider(baseTextProvider);
        TextProvider anythingWithDotProvider2 = new AnythingWithDotProvider(anythingWithDotProvider);



        System.out.println(anythingWithDotProvider2.getText());
    }
}
