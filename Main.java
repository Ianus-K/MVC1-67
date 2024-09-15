public class Main {
    public static void main(String[] args) {
        Cow[] cows = {
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

        BowlingGame game = new BowlingGame(cows);
        GameView view = new GameView(null);
        GameController controller = new GameController(game, view);
        view.setController(controller);
        controller.startGame();
    }
}
