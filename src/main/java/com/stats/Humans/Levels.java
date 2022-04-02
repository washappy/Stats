package com.stats.Humans;

public class Levels {

    private int needForNextLev;
    private int nowlevel;
    private int exp;

    public int getNeedForNextLev() {
        return needForNextLev;
    }

    public void setNeedForNextLev(int needForNextLev) {
        this.needForNextLev = needForNextLev;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getNowlevel() {
        return nowlevel;
    }

    public void setNowlevel(int nowlevel) {
        this.nowlevel = nowlevel;
    }

    public void addNowlevel(int aadd) {
        this.nowlevel += aadd;
    }

    public Levels(int levle,int expp) {
        this.nowlevel = levle;
        this.exp = expp;
        this.needForNextLev = levle*10;
    }

    public void levelUp() {
        this.nowlevel += 1;
        this.exp = this.exp - this.needForNextLev;
        this.needForNextLev = this.nowlevel*10;
    }

}
