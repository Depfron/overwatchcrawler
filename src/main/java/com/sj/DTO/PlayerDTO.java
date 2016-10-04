package com.sj.DTO;

import org.springframework.stereotype.Component;

@Component
public class PlayerDTO {
    private String name;
    private String nickName;
    private String battleTag;
    private int competitivePoint;
    private int level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getBattleTag() {
        return battleTag;
    }

    public void setBattleTag(String battleTag) {
        this.battleTag = battleTag;
    }

    public int getCompetitivePoint() {
        return competitivePoint;
    }

    public void setCompetitivePoint(int competitivePoint) {
        this.competitivePoint = competitivePoint;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
