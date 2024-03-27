package ladder.view;

import ladder.domain.Height;
import ladder.domain.User;
import ladder.domain.Users;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public Users inputUsers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        input.replace(" ", "");
        List<User> candidateUsers = Arrays.stream(input.split(","))
                .map(user -> new User(user))
                .toList();

        return new Users(candidateUsers);
    }


}
