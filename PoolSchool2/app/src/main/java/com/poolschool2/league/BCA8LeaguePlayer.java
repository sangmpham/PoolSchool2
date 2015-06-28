package com.poolschool2.league;

/**
 * Created by OWNER-PC on 5/19/2015.
 */
public class BCA8LeaguePlayer {
    private int Ave;
    private String playerName;
    private int score1,score2, score3;
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }



    public BCA8LeaguePlayer(){
        Ave =0;
        playerName=null;
        score1=0;
        score2=0;
        score3=0;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public void setScore3(int score3) {
        this.score3 = score3;
    }



    public String getPlayerName() {
        return playerName;
    }



    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public int getScore3() {
        return score3;
    }

    public int getAve() {
        return Ave;
    }

    public void setAve(int ave) {
        Ave = ave;
    }


}
