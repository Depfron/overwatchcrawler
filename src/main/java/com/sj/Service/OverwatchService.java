package com.sj.Service;

import com.sj.DB;
import com.sj.DTO.BattleTagDTO;
import com.sj.DTO.PlayerDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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
        List<PlayerDTO> playerDTOs = new ArrayList<PlayerDTO>();
        List<BattleTagDTO> battleTags = getBattleTags();

        for(BattleTagDTO battleTag: battleTags) {
            try{
                PlayerDTO playerDTO = getPlayer(battleTag);
                playerDTOs.add(playerDTO);
            }catch(Exception e) {

            }
        }

        Collections.sort(playerDTOs, new RankDescCompare());

        return playerDTOs;
    }

    static class RankDescCompare implements Comparator<PlayerDTO> {

        @Override
        public int compare(PlayerDTO o1, PlayerDTO o2) {
            return o1.getCompetitivePoint() > o2.getCompetitivePoint() ? -1 :
                    o1.getCompetitivePoint() < o2.getCompetitivePoint() ? 1 : 0;
        }
    }

    public List getBattleTags() {
        List<BattleTagDTO> battleTags = new ArrayList<BattleTagDTO>();

        // https://playoverwatch.com/ko-kr/career/pc/kr/Tuna-3927
        battleTags.add(new BattleTagDTO("홍석진", "Tuna", "3927"));
        battleTags.add(new BattleTagDTO("강은범", "버미", "31735"));
        battleTags.add(new BattleTagDTO("김재면", "Apple", "3580"));
        battleTags.add(new BattleTagDTO("성열민", "리자몽", "31628"));
        battleTags.add(new BattleTagDTO("이기찬", "아이휴", "3739"));
        battleTags.add(new BattleTagDTO("전익수", "Sundrops", "3572"));
        battleTags.add(new BattleTagDTO("강명우", "맹이맹이", "3462"));
        battleTags.add(new BattleTagDTO("공병국", "API", "3411"));
        battleTags.add(new BattleTagDTO("이상록", "kwk", "3409"));
        battleTags.add(new BattleTagDTO("김만수", "akakakakakaa", "3285"));
        battleTags.add(new BattleTagDTO("김병우", "겐쥐", "31175"));
        battleTags.add(new BattleTagDTO("김진욱", "Gleam", "31149"));
        battleTags.add(new BattleTagDTO("나영환", "Lord", "3957"));
        battleTags.add(new BattleTagDTO("나영환", "윤수짱", "31426"));
        battleTags.add(new BattleTagDTO("김형률", "류리", "31929"));
        battleTags.add(new BattleTagDTO("김형률", "률이", "31439"));
        battleTags.add(new BattleTagDTO("김민호", "미친인간", "3718"));
        battleTags.add(new BattleTagDTO("신동걸", "동구르르르", "3697"));
        battleTags.add(new BattleTagDTO("오형민", "무서운거북이", "31124"));
        battleTags.add(new BattleTagDTO("유유진", "고약한개구리", "3513"));
        battleTags.add(new BattleTagDTO("윤승우", "아슷우", "3652"));
        battleTags.add(new BattleTagDTO("이세구", "젖치기젖치기", "3710"));
        battleTags.add(new BattleTagDTO("조영제", "gunghi", "3419"));
        battleTags.add(new BattleTagDTO("오영택", "태기", "31271"));
        battleTags.add(new BattleTagDTO("한진원", "Nowniz", "3951"));
        battleTags.add(new BattleTagDTO("홍철민", "근질근질", "3282"));

        return battleTags;
    }

    //@Cacheable(value="playerFindCache", key="#battleTag")
    public PlayerDTO getPlayer(BattleTagDTO battleTag) throws IOException {

        if(db.isPlayerExisted(battleTag.getNickName())) {
            return db.getPlayer(battleTag.getNickName());
        }

        System.out.println("Call getPlayerInfo()");

        String url = urlPath;
        url = url + URLEncoder.encode(battleTag.getNickName(), "UTF-8");
        url = url + "-" + battleTag.getBattleTag();

        System.out.println("url : " + url);
        Document doc = Jsoup.connect(url).timeout(5000).get();
        String rank =  doc.select("div.competitive-rank").select(".h6").first().text();
        String name =  doc.select("h1.header-masthead").text();

        System.out.println("name = " + name);
        System.out.println("rank = " + rank);

        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setNickName(battleTag.getNickName());
        playerDTO.setBattleTag(battleTag.getBattleTag());
        playerDTO.setCompetitivePoint(Integer.parseInt(rank));
        playerDTO.setName(battleTag.getName());

        db.addPlayer(battleTag.getNickName(), playerDTO);

        return playerDTO;
    }

}
