package com.sj;

import com.sj.DTO.PlayerDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DB {
    private Map<String, PlayerDTO> players = new HashMap<String, PlayerDTO>();

    public boolean isPlayerExisted(String nickName) {
        boolean isFind = false;

        for(Map.Entry<String, PlayerDTO> player : players.entrySet()) {
            if(player.getKey().equals(nickName)) {
                isFind = true;
                break;
            }
        }

        return isFind;
    }

    public PlayerDTO getPlayer(String key) {
        return players.get(key);
    }

    public void addPlayer(String key, PlayerDTO playerDTO) {
        players.put(key, playerDTO);
    }
}
