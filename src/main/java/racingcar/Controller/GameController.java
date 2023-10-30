package racingcar.Controller;

import java.util.HashMap;
import java.util.List;
import racingcar.Model.CarRaceModel;
import racingcar.Model.CarTextModel;
import racingcar.View.GamePlayView;

public class GameController {

    CarRaceModel carRaceModel = new CarRaceModel();
    CarTextModel carTextModel = new CarTextModel();
    GamePlayView gamePlayView = new GamePlayView();

    public void gameStart() {

        String carNames = gamePlayView.inputCarName();
        HashMap<String, String> carList = carTextModel.parseCarNames(carNames);

        int attempts = gamePlayView.inputAttemptsCount();

        System.out.println();
        System.out.println("실행 결과");

        for(int i=0; i<attempts; i++) {
            carList = carRaceModel.saveCarMovement(carList);
            gamePlayView.showTurnResult(carList);
            System.out.println();
        }

        List<String> winnerList = carRaceModel.findWinner(carList);

        gamePlayView.showGameWinner(winnerList);
    }

}
