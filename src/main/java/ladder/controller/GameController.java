package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.RandomRowGenerator;
import ladder.domain.Users;
import ladder.view.InputView;
import ladder.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {

        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Users users = inputView.inputUsers();
        Height height = inputView.inputHeight();

        Ladder ladder = generateLadder(users, height);

        outputView.outputResult(users,ladder);
    }

    private static Ladder generateLadder(Users users, Height height) {
        int userLength = users.getUserLength();
        Ladder ladder = new Ladder(userLength, height, new RandomRowGenerator());

        return ladder;
    }
}
