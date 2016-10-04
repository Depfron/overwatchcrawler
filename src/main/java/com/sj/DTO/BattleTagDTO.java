package com.sj.DTO;

public class BattleTagDTO {
    private String name;
    private String nickName;
    private String battleTag;

    public BattleTagDTO() {

    }

    public BattleTagDTO(String name, String nickName, String battleTag) {
        this.name = name;
        this.nickName = nickName;
        this.battleTag = battleTag;
    }

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
}
