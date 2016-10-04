package com.sj.Controller;

import com.google.gson.Gson;
import com.sj.Service.OverwatchService;
import com.sj.DTO.Player;
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

    @RequestMapping("/")
    public String home(Model model) {
        return "home";
    }

    @RequestMapping("/players")
    @ResponseBody
    public String getPlayers() {
        List<Player> players = overwatchService.getPlayers();

        Map<String, List<Player>> map = new HashMap<String, List<Player>>();

        map.put("players", players);
        String jsonData = gson.toJson(map);

        System.out.println(jsonData);

        return jsonData;
    }
}
