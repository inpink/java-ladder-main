package ladder.domain;

public class Height {
    private static final String OUT_OF_RANGE_HEIGHT = "적절한 범위의 높이 값이 필요합니다.";
    private final int height;

    public Height(int candidateHeight) {
        validate(candidateHeight);
        this.height = candidateHeight;
    }

    private void validate(int candidateHeight) {
        validateHeight(candidateHeight);
    }

    private void validateHeight(int candidateHeight) {
        if (candidateHeight < 1) {
            throw new IllegalArgumentException(OUT_OF_RANGE_HEIGHT);
        }
    }

    public int getHeight() {
        return height;
    }
}
