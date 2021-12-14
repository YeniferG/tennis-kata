
public class TennisGame1 implements TennisGame {
    
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            scorePlayer1 += 1;
        else
            scorePlayer2 += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        if (scorePlayer1==scorePlayer2)
            score = equalsScorePlayers();
        else if (scorePlayer1>=4 || scorePlayer2>=4)
            score = scoreGreaterThan4();
        else
            score = getScoreWhenIsZeroToThree();
        return score;
    }

    private String equalsScorePlayers(){
        switch (scorePlayer1)
        {
            case 0: return "Love-All";
            case 1: return "Fifteen-All";
            case 2: return "Thirty-All";
            default: return "Deuce";
        }
    }

    private String advantageScore(int minusResult){
        return minusResult ==1 ? "Advantage player1" : "Advantage player2";
    }

    private String winScore(int minusResult){
        return minusResult >= 2 ? "Win for player1": "Win for player2";
    }

    private String scoreGreaterThan4(){
        int minusResult = scorePlayer1 - scorePlayer2;
        switch(minusResult){
            case 1: case -1: return advantageScore(minusResult);
            default: return winScore(minusResult);
        }
    }

    private Boolean isLastScorePlayer(Integer scorePlayer){
        return scorePlayer == 1;
    }

    private String assignScoreByPlayer(Integer scoreByPlayer){
        String score = "";
        switch(scoreByPlayer)
        {
            case 0: return score+="Love";
            case 1: return score+="Fifteen";
            case 2: return score+="Thirty";
            default: return score+="Forty";
        }
    }

    private String getScoreWhenIsZeroToThree(){
        String score = "";
        Integer scorePlayers[] = {scorePlayer1,scorePlayer2};
        for (int scorePlayer = 0;scorePlayer <scorePlayers.length;scorePlayer++){ if(isLastScorePlayer(scorePlayer)) score += "-";
            score += assignScoreByPlayer(scorePlayers[scorePlayer]);
        }
        return score;
    }
}
