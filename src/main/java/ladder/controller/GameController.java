package ladder.controller;

import ladder.domain.Height;
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
        System.out.println(users.getUsers());

        Height height = inputView.inputHeight();
    }
}
