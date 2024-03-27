package ladder.domain;

public class User {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public User(String candidateName) {
        validate(candidateName);
        this.name = candidateName;
    }

    private void validate(String candidateName) {
        validateNameLength(candidateName);
    }

    private void validateNameLength(String candidateName) {
        int nameLength = candidateName.length();

        if (nameLength < MIN_NAME_LENGTH || nameLength > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }
}
