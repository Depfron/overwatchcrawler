package com.sj.DTO;

import javax.persistence.*;

@Entity
public class PlayerDTO {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    private String nickName;

    @Column
    private String battleTag;

    @Column
    private int competitivePoint;

    @Column
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
