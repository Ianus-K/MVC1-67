import java.util.Random;

public class BowlingGame {
    private Cow[] cows;
    private int currentRound;
    private int totalRounds = 11;

    public BowlingGame(Cow[] cows) {
        this.cows = cows;
        this.currentRound = 0;
    }

    public void playRound() {
        Random random = new Random();
        for (int i = 0; i < cows.length; i++) {
            Cow cow = cows[i];
            int firstRoll = random.nextInt(11);

            if (cow.getTeamColor().equals("white") && random.nextDouble() < 0.1 && firstRoll > 0) {
                System.out.println(cow.getTeamColor() + " Cow #" + cow.getNumber() + " claims no pins knocked down!");
                if (firstRoll > 0) {
                    System.out.println("But actually, pins were knocked down! Adjusting to Cow Strike.");
                    firstRoll = 10;
                }
            }

            if (cow.getTeamColor().equals("black") && random.nextDouble() < 0.2 && firstRoll < 10) {
                System.out.println(cow.getTeamColor() + " Cow #" + cow.getNumber() + " falsely claims all pins knocked down!");
                if (firstRoll < 10) {
                    System.out.println("But it's a lie! The score for this round will be 0.");
                    cow.setFirstRoll(0);
                    cow.setSecondRoll(0);
                    continue;
                }
            }

            cow.setFirstRoll(firstRoll);

            if (firstRoll == 10) {
                cow.cowStrike(cows, i);
                continue;
            }

            int secondRoll = random.nextInt(11 - firstRoll);

            if (cow.getTeamColor().equals("white") && random.nextDouble() < 0.1 && secondRoll > 0) {
                System.out.println(cow.getTeamColor() + " Cow #" + cow.getNumber() + " claims no pins knocked down on second roll!");
                if (secondRoll > 0) {
                    System.out.println("But actually, pins were knocked down! Adjusting to Cow Spare.");
                    secondRoll = 10 - firstRoll;
                }
            }

            if (cow.getTeamColor().equals("black") && random.nextDouble() < 0.2 && secondRoll < (10 - firstRoll)) {
                System.out.println(cow.getTeamColor() + " Cow #" + cow.getNumber() + " falsely claims all pins knocked down on second roll!");
                if (secondRoll < (10 - firstRoll)) {
                    System.out.println("But it's a lie! The score for this round will be 0.");
                    cow.setFirstRoll(0);
                    cow.setSecondRoll(0);
                    continue;
                }
            }

            cow.setSecondRoll(secondRoll);

            if (firstRoll + secondRoll == 10) {
                cow.cowSpare(cows, i);
            } else {
                cow.cowOpen();
            }
        }
        currentRound++;
    }

    public boolean isGameOver() {
        return currentRound >= totalRounds;
    }

    public Cow[] getCows() {
        return cows;
    }
}