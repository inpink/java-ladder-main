package ladder.domain;

import java.util.Arrays;

public enum Line {
    EXIST(true, "-----"),
    NOT_EXIST(false, "     ");

    private final boolean value;
    private final String description;

    Line(boolean value, String description) {
        this.value = value;
        this.description = description;
    }

    public static Line getLine(Boolean line) {
        return Arrays.stream(Line.values())
                .filter(value -> value.getValue() == line)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public boolean getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
