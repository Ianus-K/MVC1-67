import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameView extends JFrame {
    private JTextArea gameLog;
    private JButton restartButton;
    private GameController controller;

    public GameView(GameController controller) {
        this.controller = controller;
        setTitle("Cow Bowling Game");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        gameLog = new JTextArea();
        gameLog.setEditable(false);
        add(new JScrollPane(gameLog), BorderLayout.CENTER);

        restartButton = new JButton("Restart Game");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });
        add(restartButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void displayRound(Cow[] cows) {
        StringBuilder sb = new StringBuilder();
        for (Cow cow : cows) {
            sb.append("Team ").append(cow.getTeamColor()).append(" - Cow #").append(cow.getNumber()).append(" - Score: ").append(cow.getScore()).append("\n");
        }
        gameLog.append(sb.toString() + "\n");
    }

    public void displayResults(Cow[] cows) {
        gameLog.append("Final Scores:\n");
        for (int i = 0; i < cows.length; i++) {
            gameLog.append((i + 1) + ". Team " + cows[i].getTeamColor() + " - Cow #" + cows[i].getNumber() + " - " + cows[i].getScore() + " points\n");
        }
    }

    public void displayWinningTeam(Cow[] cows) {
        int[] teamScores = new int[3];
        for (Cow cow : cows) {
            if (cow.getTeamColor().equals("white")){
                teamScores[0] += cow.getScore();
            }
            if (cow.getTeamColor().equals("black")){
                teamScores[1] += cow.getScore();
            } 
            if (cow.getTeamColor().equals("brown")){
                teamScores[2] += cow.getScore();
            } 
        }

        int maxScore = Math.max(teamScores[0], Math.max(teamScores[1], teamScores[2]));
        gameLog.append("Team white score : " + teamScores[0] + "\n");
        gameLog.append("Team black score : " + teamScores[1] + "\n");
        gameLog.append("Team brown score : " + teamScores[2] + "\n");
        String winningTeam = (teamScores[0] == maxScore) ? "White" : (teamScores[1] == maxScore) ? "Black" : "Brown";
        gameLog.append("The winning team is: " + winningTeam + " with " + maxScore + " points!\n");
    }
    
    public void setController(GameController controller) {
        this.controller = controller;
    }    

    private void restartGame() {
        gameLog.setText("");
        controller.startGame();
    }
}
