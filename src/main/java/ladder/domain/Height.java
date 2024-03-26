package ladder.domain;

public class Height {
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
            throw new IllegalArgumentException();
        }
    }
}