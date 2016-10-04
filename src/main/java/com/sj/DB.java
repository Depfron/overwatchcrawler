package com.sj;

import com.sj.DTO.Player;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DB {
    private Map<String, Player> players = new HashMap<String, Player>();

    public boolean isPlayerExisted(String nickName) {
        boolean isFind = false;

        for(Map.Entry<String, Player> player : players.entrySet()) {
            if(player.getKey().equals(nickName)) {
                isFind = true;
                break;
            }
        }

        return isFind;
    }

    public Player getPlayer(String key) {
        return players.get(key);
    }

    public void addPlayer(String key, Player player) {
        players.put(key, player);
    }
}
