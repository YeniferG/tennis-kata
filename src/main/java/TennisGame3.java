
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
        String score;
        if (notIsDeuce()) {
            String[] scores = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            score = scores[scorePlayer1];
            return getScoreByPlayer(score,scores);
        }
        if (isTie())
            return "Deuce";
        score = highestScore();
        return getScoreWhenAdvantageOrWin(score) ;

    }

    public String getScoreWhenAdvantageOrWin(String score){
        return (getPointsDifference() * getPointsDifference() == 1) ? "Advantage " + score : "Win for " + score;
    }

    public Integer getPointsDifference(){
        return scorePlayer1 - scorePlayer2;
    }

    public String highestScore(){
        return scorePlayer1 > scorePlayer2 ? player1Name : player2Name;
    }

    public String getScoreByPlayer(String score, String[] scores){
        return isTie() ? score + "-All" : score + "-" + scores[scorePlayer2];
    }

    public Boolean notIsDeuce(){
        return scorePlayer1 < 4 && scorePlayer2 < 4 && !(scorePlayer1 + scorePlayer2 == 6);
    }

    public Boolean isTie(){
        return scorePlayer1 == scorePlayer2;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.scorePlayer1 += 1;
        else
            this.scorePlayer2 += 1;

    }

}
