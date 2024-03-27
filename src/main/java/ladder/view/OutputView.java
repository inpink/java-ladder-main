package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.User;
import ladder.domain.Users;

import java.util.stream.IntStream;

public class OutputView {
    public void outputResult(Users users, Ladder ladder) {
        outputUsers(users);
        outputLadder(users, ladder);
    }

    private static void outputLadder(Users users, Ladder ladder) {
        for (int x = 0; x < ladder.getRowSize(); x++) {
            System.out.print("|");
            outputRow(users, ladder, x);
            System.out.println();
        }
    }

    private static void outputRow(Users users, Ladder ladder, int x) {
        for (int y = 0; y < users.getUserLength() - 1; y++) {
            Line cellLine = ladder.getCell(x, y);
            System.out.print(cellLine.getDescription() + "|");
        }
    }

    private static void outputUsers(Users users) {
        users.getUsers().stream()
                .forEach(user -> outputUser(user));
        System.out.println();
    }

    private static void outputUser(User user) {
        String userName = user.getName();
        System.out.print(userName + " ");
        IntStream.range(0, 5 - userName.length())
                .forEach(index -> System.out.print(" "));
    }
}
