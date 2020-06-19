package util;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public enum Status {

    F("Free"),
    R("Rented"),
    B("Bought"),
    L("Loan");

    private final String value;
    private static String FREE = "F";
    private static String RENTED = "R";
    private static String BOUGHT = "B";
    private static String LOAN = "L";


    Status(String v) {
            value = v;
    }

    public String value() {
        return value;
    }

    public static Optional<Status> fromValue(String s) {
        return Arrays.stream(Status.values())
                .filter(Objects::nonNull)
                .filter(value -> s.equalsIgnoreCase(value.value()))
                .findFirst();
    }
}

