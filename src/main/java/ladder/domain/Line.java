package ladder.domain;

import java.security.SecureRandom;

public class Line {
    private final boolean isExistent;

    public Line(boolean isExistent) {
        this.isExistent = isExistent;
    }

    public static Line createRandomLine() {
        SecureRandom random = new SecureRandom();
        Boolean randomValue = random.nextBoolean();
        return new Line(randomValue);
    }

    public static Line createExistentLine() {
        return new Line(false);
    }

    public static Line createNonExistentLine() {
        return new Line(false);
    }

    public boolean isExistent() {
        return isExistent;
    }
}
