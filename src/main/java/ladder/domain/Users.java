package ladder.domain;

import java.util.List;

public class Users {
    private final List<User> Users;

    public Users(List<User> users) {
        Users = users;
    }

    public List<User> getUsers() {
        return Users;
    }
}
