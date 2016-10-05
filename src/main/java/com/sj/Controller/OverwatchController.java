package com.sj.Controller;

import com.google.gson.Gson;
import com.sj.DAO.BattleTagDAO;
import com.sj.DAO.PlayerDAO;
import com.sj.DTO.BattleTagDTO;
import com.sj.Service.OverwatchService;
import com.sj.DTO.PlayerDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.net.URLEncoder;

@Controller
public class OverwatchController {

    @Autowired
    private OverwatchService overwatchService;

    @Autowired
    private PlayerDAO playerDAO;

    @Autowired
    private BattleTagDAO battleTagDAO;

    private Gson gson = new Gson();

    private Logger logger = Logger.getLogger(OverwatchController.class);

    @RequestMapping("/")
    public String home(Model model) {
        return "home";
    }

    @RequestMapping("/players")
    @ResponseBody
    public String getPlayers() {
        List<PlayerDTO> playerDTOs = playerDAO.findAll();

        Map<String, List<PlayerDTO>> map = new HashMap<String, List<PlayerDTO>>();

        map.put("players", playerDTOs);
        String jsonData = gson.toJson(map);

        logger.info(jsonData);

        return jsonData;
    }

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public @ResponseBody String write(@RequestBody String jsonData) {

        try {
            URLDecoder.decode(jsonData , "EUC_KR");
            logger.info(jsonData);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List<Object> list = gson.fromJson(jsonData, List.class);
        BattleTagDTO battleTagDTO = new BattleTagDTO();

        BattleTagDTO existBattleTagDTO = battleTagDAO.findByNickName(battleTagDTO.getNickName());

        if(existBattleTagDTO == null)
            battleTagDAO.save(battleTagDTO);

        return "home";
    }

}
