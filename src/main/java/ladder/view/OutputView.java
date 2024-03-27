package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Row;
import ladder.domain.Users;

import java.util.stream.IntStream;

public class OutputView {

    public void outputLadder(Users users, Ladder ladder) {
        users.getUsers().stream()
                .forEach(user -> {
                    String userName = user.getName();
                    System.out.print(userName + " ");
                    IntStream.range(0, 5 - userName.length())
                            .forEach(index -> System.out.print(" "));
                });
        System.out.println();

        for (int x = 0; x < ladder.getRowSize(); x++) {
            System.out.print("|");
            for (int y = 0; y < users.getUserLength() - 1; y++) {
                Line cellLine = ladder.getCell(x, y);
                System.out.print(cellLine.getDescript() + "|");
            }
            System.out.println();
        }
    }
}
