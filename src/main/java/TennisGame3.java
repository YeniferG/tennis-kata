
public class TennisGame3 implements TennisGame {
    
    private int scorePlayer2;
    private int scorePlayer1;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String s;
        if (scorePlayer1 < 4 && scorePlayer2 < 4 && !(scorePlayer1 + scorePlayer2 == 6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"}; 
            s = p[scorePlayer1];
            return (scorePlayer1 == scorePlayer2) ? s + "-All" : s + "-" + p[scorePlayer2];
        } else {
            if (scorePlayer1 == scorePlayer2)
                return "Deuce";
            s = scorePlayer1 > scorePlayer2 ? player1Name : player2Name;
            return ((scorePlayer1-scorePlayer2)*(scorePlayer1-scorePlayer2) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }
    
    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.scorePlayer1 += 1;
        else
            this.scorePlayer2 += 1;
        
    }

}
