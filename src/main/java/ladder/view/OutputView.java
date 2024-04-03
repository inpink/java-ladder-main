package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.User;
import ladder.domain.Users;

import java.util.stream.IntStream;

public class OutputView {
    private static final String existentLine = "-----";
    private static final String nonExistentLine = "     ";
    private static final String dividingLine = "|";

    public void outputResult(Users users, Ladder ladder) {
        outputUsers(users);
        outputLadder(users, ladder);
    }

    private static void outputLadder(Users users, Ladder ladder) {
        for (int x = 0; x < ladder.getRowSize(); x++) {
            System.out.print(dividingLine);
            outputRow(users, ladder, x);
            System.out.println();
        }
    }

    private static void outputRow(Users users, Ladder ladder, int rowIndex) {
        for (int lineIndex = 0; lineIndex < users.getUserLength() - 1; lineIndex++) {
            Line line = ladder.getLine(rowIndex, lineIndex);
            outputLine(line);
        }
    }

    private static void outputLine(Line line) {
        outputExistentLine(line);
        outputNonExistentLine(line);
    }

    private static void outputNonExistentLine(Line line) {
        if (!line.isExistent()) {
            System.out.print(nonExistentLine + dividingLine);
        }
    }

    private static void outputExistentLine(Line line) {
        if (line.isExistent()) {
            System.out.print(existentLine + dividingLine);
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
