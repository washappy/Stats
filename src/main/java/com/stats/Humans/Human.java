package com.stats.Humans;

import java.util.HashMap;

public class Human {

    private String job;
    private String name;  //사람 이름

    private int strength = 10; //힘
    private int agility = 10;  //민첩
    private int speed = 10;  //신속
    private int health = 10;  //체력
    private int defense = 10;  //내구
    private int luck = 10;  //행운
    private int handicraft = 10;  //손재주
    private int attractive = 10;  //매력
    private int level = 0;  //레벨
    private int morestat = 0;  //추가 스텟
    private int hexp = 0;  //현재 경험치
    private int hNeedForNextL = level * 10;  //다음 레벨까지 필요경험치량
    public HashMap<String, Integer> allStats = new HashMap<>(12);

    public Human(String hname) {  //생성자
        this.name = hname;
    }

    public HashMap<String, Integer> getMap() {
        return this.allStats;
    }

    public void mapSave(){
        allStats.put("strength",this.strength);
        allStats.put("agility",this.agility);
        allStats.put("speed",this.speed);
        allStats.put("health",this.health);
        allStats.put("defense",this.defense);
        allStats.put("luck",this.luck);
        allStats.put("handicraft",this.handicraft);
        allStats.put("attractive",this.attractive);
        allStats.put("level",this.level);
        allStats.put("moreStats",this.morestat);
        allStats.put("exp",this.hexp);
        allStats.put("needed",this.hNeedForNextL);
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getStrength() {
        return this.strength;
    }

    public void addStrength(int strength) {
        if(this.morestat>=strength) {
            this.strength += strength;
            this.setMorestats(this.morestat-strength);
            mapSave();
        }
    }

    public int getAgility() {
        return this.agility;
    }

    public void addAgility(int agility) {
        if(this.morestat>=agility) {
            this.agility += agility;
            this.setMorestats(this.morestat-agility);
            mapSave();
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void addSpeed(int speed) {
        if(this.morestat>=speed) {
            this.speed += speed;
            this.setMorestats(this.morestat-speed);
            mapSave();
        }
    }

    public int getHealth() {
        return health;
    }

    public void addHealth(int health) {
        if(this.morestat>=health) {
            this.health += health;
            this.setMorestats(this.morestat-health);
            mapSave();
        }
    }

    public int getDefense() {
        return defense;
    }

    public void addDefense(int defense) {
        if(this.morestat>=defense) {
            this.defense += defense;
            this.setMorestats(this.morestat-defense);
            mapSave();
        }
    }

    public int getLuck() {
        return luck;
    }

    public void addLuck(int luck) {
        if(this.morestat>=luck) {
            this.luck += luck;
            this.setMorestats(this.morestat-luck);
            mapSave();
        }
    }

    public int getHandicraft() {
        return handicraft;
    }

    public void addHandicraft(int handicraft) {
        if(this.morestat>=handicraft) {
            this.handicraft += handicraft;
            this.setMorestats(this.morestat-handicraft);
            mapSave();
        }
    }

    public int getAttractive() {
        return attractive;
    }

    public void addAttractive(int attractive) {
        if(this.attractive>=attractive) {
            this.attractive += attractive;
            this.setMorestats(this.morestat-attractive);
            mapSave();
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        mapSave();
    }

    public int getMorestats() {
        return morestat;
    }

    public void setMorestats(int morestats) {
        this.morestat = morestats;
        mapSave();
    }

/*    public int getHexp() {
        return hexp;
    }

    public void setHexp(int hexp) {
        this.hexp = hexp;
        mapSave();
    }

    public void addHexp(int aexp) {
        this.hexp += aexp;
        mapSave();
    }

    public int gethNeedForNextL() {
        return hNeedForNextL;
    }

    public void sethNeedForNextL(int hNeedForNextL) {
        this.hNeedForNextL = hNeedForNextL;
        mapSave();
    }*/

    public String getName( ) {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean ifLevelUp() {
        return (this.hexp >= this.hNeedForNextL);
    }

    public Human hLevelUp() {
        this.setLevel(this.getLevel() + 1);
        this.setMorestats(this.getMorestats() + 5);
        mapSave();
        return this;
    }

    public String info() {

        String output = "\n================\n\n" + this.getName() + "\n\n" + this.getLevel() + ".lv\n"
                + "hp : " + this.getHealth() + "\nstrength : " + this.getStrength() + "\nagility : " + this.getAgility() + "\ndefense : " + this.getDefense()
                + "\nspeed : " + this.getSpeed() + "\nluck : " + this.getLuck() + "\nattractiveness : " + this.getAttractive() + "\nhandicraft : " + this.getHandicraft()
                + "\n\nmore : " + this.getMorestats() + "\n================";

        return output;
    }

}
