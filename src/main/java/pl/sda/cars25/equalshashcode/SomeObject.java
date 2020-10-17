package pl.sda.cars25.equalshashcode;

import java.util.Objects;

public class SomeObject {

    private String text;

    public SomeObject(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o.getClass().equals(this.getClass()))) {
            return false;
        }
        SomeObject otherObject = (SomeObject) o;
        if (text.equals(otherObject.getText())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    public String getText() {
        return text;
    }
}
