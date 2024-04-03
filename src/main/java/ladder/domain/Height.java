package ladder.domain;

public class Height {
    private static final int MIN_HEIGHT=1;
    private static final String OUT_OF_RANGE_HEIGHT = String.format("%d이상의 높이 값이 필요합니다.",MIN_HEIGHT);

    private final int height;

    public Height(int height) {
        validate(height);
        this.height = height;
    }

    private void validate(int height) {
        validateHeight(height);
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(OUT_OF_RANGE_HEIGHT);
        }
    }

    public int getValue() {
        return height;
    }
}
