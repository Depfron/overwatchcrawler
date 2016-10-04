package com.sj.Service;

import com.sj.DB;
import com.sj.DTO.Player;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

@Service
public class OverwatchService {

    @Autowired
    private DB db;
    private static String urlPath = "https://playoverwatch.com/ko-kr/career/pc/kr/";

    public List getPlayers() {
        List<Player> players = new ArrayList<Player>();
        Map<String, String> battleTags = getBattleTags();

        for(Map.Entry<String, String> battleTag : battleTags.entrySet()) {
            try{
                Player player = getPlayer(battleTag);
                players.add(player);
            }catch(Exception e) {

            }
        }

        return players;
    }

    public Map getBattleTags() {
        Map<String, String> battleTags = new HashMap<String, String>();

        // https://playoverwatch.com/ko-kr/career/pc/kr/Tuna-3927
        battleTags.put("Tuna", "3927");
        battleTags.put("버미", "31735");

        return battleTags;
    }

    //@Cacheable(value="playerFindCache", key="#battleTag")
    public Player getPlayer(Map.Entry<String, String> battleTag) throws IOException {

        if(db.isPlayerExisted(battleTag.getKey())) {
            return db.getPlayer(battleTag.getKey());
        }

        System.out.println("Call getPlayerInfo()");

        String url = urlPath;
        url = url + URLEncoder.encode(battleTag.getKey(), "UTF-8");
        url = url + "-" + battleTag.getValue();

        System.out.println("url : " + url);
        Document doc = Jsoup.connect(url).timeout(5000).get();
        String rank =  doc.select("div.competitive-rank").select(".h6").first().text();
        String name =  doc.select("h1.header-masthead").text();

        System.out.println("name = " + name);
        System.out.println("rank = " + rank);

        Player player = new Player();
        player.setNickName(battleTag.getKey());
        player.setBattleTag(battleTag.getValue());
        player.setCompetitivePoint(Integer.parseInt(rank));

        db.addPlayer(battleTag.getKey(), player);

        return player;
    }

}
