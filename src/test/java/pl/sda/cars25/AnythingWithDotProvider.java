package pl.sda.cars25;

public class AnythingWithDotProvider implements TextProvider {

    private TextProvider textProvider;

    public AnythingWithDotProvider(TextProvider textProvider) {
        this.textProvider = textProvider;
    }

    @Override
    public String getText() {
        return textProvider.getText() + ".";
    }
}
