public class Cow {
    private String teamColor;
    private int number;
    private int score;
    private int firstRoll;
    private int secondRoll;

    public Cow(String teamColor, int number) {
        this.teamColor = teamColor;
        this.number = number;
        this.score = 0;
    }

    public String getTeamColor() {
        return teamColor;
    }

    public int getNumber() {
        return number;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public int getFirstRoll() {
        return firstRoll;
    }

    public void setFirstRoll(int firstRoll) {
        this.firstRoll = firstRoll;
    }

    public int getSecondRoll() {
        return secondRoll;
    }

    public void setSecondRoll(int secondRoll) {
        this.secondRoll = secondRoll;
    }

    public void cowStrike(Cow[] cows, int currentCowIndex) {
        this.addScore(10);
        System.out.println(this.teamColor + " Cow #" + this.number + " got a Cow Strike!");
        if (currentCowIndex < cows.length - 2) {
            this.addScore(cows[currentCowIndex + 1].getFirstRoll() + cows[currentCowIndex + 2].getFirstRoll());
        }
    }

    public void cowSpare(Cow[] cows, int currentCowIndex) {
        this.addScore(10);
        System.out.println(this.teamColor + " Cow #" + this.number + " got a Cow Spare!");
        if (currentCowIndex < cows.length - 1) {
            this.addScore(cows[currentCowIndex + 1].getFirstRoll());
        }
    }

    public void cowOpen() {
        int roundScore = this.firstRoll + this.secondRoll;
        this.addScore(roundScore);
        System.out.println(this.teamColor + " Cow #" + this.number + " got a Cow Open with " + roundScore + " points.");
    }
}
