package ladder.view;

import ladder.domain.Height;
import ladder.domain.User;
import ladder.domain.Users;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_USERS_DESCRIPTION
            = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT_DESCRIPTION
            = "최대 사다리 높이는 몇 개인가요?";

    private final Scanner scanner = new Scanner(System.in);

    public Users inputUsers() {
        System.out.println(INPUT_USERS_DESCRIPTION);
        String input = scanner.nextLine();

        input.replace(" ", "");
        List<User> candidateUsers = Arrays.stream(input.split(","))
                .map(user -> new User(user))
                .toList();

        return new Users(candidateUsers);
    }

    public Height inputHeight() {
        System.out.println(INPUT_HEIGHT_DESCRIPTION);
        int input = scanner.nextInt();

        return new Height(input);
    }
}
