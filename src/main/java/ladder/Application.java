package ladder;

import ladder.controller.GameController;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(
                new InputView(),
                new OutputView()
        );

        gameController.start();
    }
}
