package com.sj.Service;

import com.sj.DAO.BattleTagDAO;
import com.sj.DAO.PlayerDAO;
import com.sj.DTO.BattleTagDTO;
import com.sj.DTO.PlayerDTO;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

@Service
public class OverwatchService {

    private Logger logger = Logger.getLogger(OverwatchService.class);

    private static String urlPath = "https://playoverwatch.com/ko-kr/career/pc/kr/";

    @Autowired
    private PlayerDAO playerDAO;

    @Autowired
    private BattleTagDAO battleTagDAO;

    public List getPlayers() {
        List<PlayerDTO> playerDTOs = playerDAO.findAll();
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

    public PlayerDTO getPlayer(BattleTagDTO battleTag) throws IOException {

        PlayerDTO playerDTO;
        playerDTO = playerDAO.findByNickName(battleTag.getNickName());
        if(playerDTO != null) {
            return playerDTO;
        }

        playerDTO = new PlayerDTO();

        String url = urlPath;
        url = url + URLEncoder.encode(battleTag.getNickName(), "UTF-8");
        url = url + "-" + battleTag.getBattleTag();

        Document doc = Jsoup.connect(url).timeout(5000).get();
        String rank;
        try{
            rank =  doc.select("div.competitive-rank").select(".h6").first().text();
            playerDTO.setCompetitivePoint(Integer.parseInt(rank));
        }catch(Exception e){
            playerDTO.setCompetitivePoint(-1);
            logger.warn("No Competitive rank point. Set -1");
        }
        //String name =  doc.select("h1.header-masthead").text();

        playerDTO.setNickName(battleTag.getNickName());
        playerDTO.setBattleTag(battleTag.getBattleTag());
        playerDTO.setName(battleTag.getName());



        playerDAO.save(playerDTO);

        return playerDTO;
    }

}
