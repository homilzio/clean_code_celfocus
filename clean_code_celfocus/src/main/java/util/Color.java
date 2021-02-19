package util;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public enum Color {

    WHITE("WHITE"),
    BLUE("BLUE"),
    RED("RED");
    private final String value;


    Color(String value){
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static Optional<Color> fromValue(String s) {
        return Arrays.stream(Color.values())
                .filter(Objects::nonNull)
                .filter(value -> s.equalsIgnoreCase(value.value()))
                .findFirst();
    }
}
