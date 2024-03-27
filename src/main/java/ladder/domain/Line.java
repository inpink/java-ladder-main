package ladder.domain;

import java.util.Arrays;

public enum Line {
    EXIST(true, "-----"),
    NOT_EXIST(false, "     ");

    private final boolean value;

    private final String descript;

    Line(boolean value, String descript) {
        this.value = value;
        this.descript = descript;
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

    public String getDescript() {
        return descript;
    }
}
