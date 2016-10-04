package com.sj.Controller;

import com.google.gson.Gson;
import com.sj.Service.OverwatchService;
import com.sj.DTO.PlayerDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OverwatchController {

    @Autowired
    private OverwatchService overwatchService;

    private Gson gson = new Gson();

    private Logger logger = Logger.getLogger(OverwatchController.class);

    @RequestMapping("/")
    public String home(Model model) {
        return "home";
    }

    @RequestMapping("/players")
    @ResponseBody
    public String getPlayers() {
        List<PlayerDTO> playerDTOs = overwatchService.getPlayers();

        Map<String, List<PlayerDTO>> map = new HashMap<String, List<PlayerDTO>>();

        map.put("players", playerDTOs);
        String jsonData = gson.toJson(map);

        logger.info(jsonData);

        return jsonData;
    }
}
