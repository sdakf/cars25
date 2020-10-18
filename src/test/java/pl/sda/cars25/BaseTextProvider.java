package pl.sda.cars25;

public class BaseTextProvider implements TextProvider {

    private String textValue;

    public BaseTextProvider(String textValue) {
        this.textValue = textValue;
    }

    @Override
    public String getText() {
        return textValue;
    }
}
