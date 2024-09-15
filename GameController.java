import java.util.Arrays;
import java.util.Comparator;

public class GameController {
    private BowlingGame game;
    private GameView view;

    public GameController(BowlingGame game, GameView view) {
        this.game = game;
        this.view = view;
    }

    public void startGame() {
        Cow[] newCows = {
            new Cow("white", 1),
            new Cow("black", 1),
            new Cow("brown", 1),
            new Cow("white", 2),
            new Cow("black", 2),
            new Cow("brown", 2),
            new Cow("white", 3),
            new Cow("black", 3),
            new Cow("brown", 3)
        };
        game = new BowlingGame(newCows);

        while (!game.isGameOver()) {
            view.displayRound(game.getCows());
            game.playRound();
        }
        rankAndDisplayResults();
    }

    public void rankAndDisplayResults() {
        Cow[] cows = game.getCows();
        Arrays.sort(cows, Comparator.comparingInt(Cow::getScore).reversed());
        view.displayResults(cows);
        view.displayWinningTeam(cows);
    }
}
