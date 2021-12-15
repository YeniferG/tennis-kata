import java.util.Arrays;
import java.util.List;

public class TennisGame2 implements TennisGame
{
    public int p1Point = 0;
    public int p2Point = 0;

    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){

        String score = "";
        if (isTie()){
            score = getScoreWhenTie();
        }else if(isGameLove(p1Point, p2Point)){
            score = getLove();
        }else if(isGameWinning(p1Point, p2Point)){
            score = getPlayerWinning();
        }else if(isGameAdvantage(p1Point, p2Point)){
            score = getPlayerAdvantage();
        }
        if(isGameWon(p1Point, p2Point)){
            score = getPlayerWon();
        }
        return score;
    }

    public String getScoreWhenTie(){
        String[] scores = {"Love-All","Fifteen-All","Thirty-All","Deuce","Deuce"};
        return scores[p1Point];
    }

    public String getScorePlayer(Integer pointsPlayer){
        switch (pointsPlayer){
            case 0:
                return "Love";
            case  1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }

    public String getScoreWhenLovePlayer2(Integer p1Point){
        return getScorePlayer(TennisGame2.this.p1Point) + "-" + "Love";
    }

    public String getScoreWhenLovePlayer1(Integer p2Point){
        return "Love" + "-" + getScorePlayer(TennisGame2.this.p2Point);
    }

    public String getScoreWhenPlayerIsWinning(){
        return getScorePlayer(p1Point) + "-" + getScorePlayer(p2Point);
    }

    public String getLove(){
        if (checkPlayerLove(p1Point,p2Point)){
            return getScoreWhenLovePlayer2(p1Point);
        }
        return getScoreWhenLovePlayer1(p2Point);
    }

    public String getPlayerWinning(){
        String score = "";
        if (checkPlayerWinning(p1Point, p2Point)){
            score = getScoreWhenPlayerIsWinning();
        }
        if (checkPlayerWinning(p2Point, p1Point)){
            score = getScoreWhenPlayerIsWinning();
        }
        return score;
    }

    public String getPlayerAdvantage(){
        String score = "";
        if (checkPlayerAdvantage(p1Point, p2Point)){
            score = "Advantage player1";
        }
        if (checkPlayerAdvantage(p2Point, p1Point)){
            score = "Advantage player2";
        }
        return score;
    }

    public String getPlayerWon(){
        String score = "";
        if (checkPlayerWon(p1Point, p2Point)){
            score = "Win for player1";
        }
        if (checkPlayerWon(p2Point, p1Point)){
            score = "Win for player2";
        }
        return score;
    }

    public void wonPoint(String player) {
        if (player == "player1") p1Point++;
        else p2Point++;
    }

    public Boolean checkPlayerLove(Integer points1, Integer points2){
        return points1 > 0 && points2==0;
    }

    public Boolean checkPlayerWinning(Integer points1, Integer points2){
        return points1 > points2 && points1 < 4;
    }

    public Boolean checkPlayerAdvantage(Integer points1, Integer points2){
        return points1 > points2 && points2 >= 3;
    }

    public Boolean isGameLove(Integer points1,Integer points2){
        return checkPlayerLove(points1,points2) || checkPlayerLove(points2, points1) ;
    }

    public Boolean isGameWinning(Integer points1, Integer points2){
        return checkPlayerWinning(points1, points2) || checkPlayerWinning(points2, points1);
    }

    public Boolean isGameAdvantage(Integer points1,Integer points2){
        return checkPlayerAdvantage(points1,points2) || checkPlayerAdvantage(points2, points1);
    }

    public Boolean isGameWon(Integer points1,Integer points2){
        return checkPlayerWon(points1, points2) || checkPlayerWon(points2, points1);
    }

    public Boolean isTie(){
        return p1Point == p2Point;
    }

    public Boolean checkPlayerWon(Integer points1, Integer points2){
        return points1 >=4 && points2 >=0 && (points1-points2) >= 2;
    }
}