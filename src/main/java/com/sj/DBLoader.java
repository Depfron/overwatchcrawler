package com.sj;

import com.sj.DAO.BattleTagDAO;
import com.sj.DTO.BattleTagDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DBLoader {

    @Autowired
    private BattleTagDAO battleTagDAO;

    //@PostConstruct
    private void genBattleTagTable() {

        battleTagDAO.save(new BattleTagDTO("홍석진", "Tuna", "3927"));
        battleTagDAO.save(new BattleTagDTO("강은범", "버미", "31735"));
        battleTagDAO.save(new BattleTagDTO("김재면", "Apple", "3580"));
        battleTagDAO.save(new BattleTagDTO("성열민", "리자몽", "31628"));
        battleTagDAO.save(new BattleTagDTO("이기찬", "아이휴", "3739"));
        //battleTags.add(new BattleTagDTO("전익수", "Sundrops", "3572"));
        battleTagDAO.save(new BattleTagDTO("강명우", "맹이맹이", "3462"));
        battleTagDAO.save(new BattleTagDTO("공병국", "API", "3411"));
        battleTagDAO.save(new BattleTagDTO("이상록", "kwk", "3409"));
        battleTagDAO.save(new BattleTagDTO("김만수", "akakakakakaa", "3285"));
        battleTagDAO.save(new BattleTagDTO("김병우", "겐쥐", "31175"));
        battleTagDAO.save(new BattleTagDTO("김진욱", "Gleam", "31149"));
        battleTagDAO.save(new BattleTagDTO("나영환", "Lord", "3957"));
        battleTagDAO.save(new BattleTagDTO("나영환", "윤수짱", "31426"));
        battleTagDAO.save(new BattleTagDTO("김형률", "류리", "31929"));
        battleTagDAO.save(new BattleTagDTO("김형률", "률이", "31439"));
        battleTagDAO.save(new BattleTagDTO("김민호", "미친인간", "3718"));
        battleTagDAO.save(new BattleTagDTO("신동걸", "동구르르르", "3697"));
        battleTagDAO.save(new BattleTagDTO("오형민", "무서운거북이", "31124"));
        battleTagDAO.save(new BattleTagDTO("유유진", "고약한개구리", "3513"));
        battleTagDAO.save(new BattleTagDTO("윤승우", "아슷우", "3652"));
        battleTagDAO.save(new BattleTagDTO("이세구", "젖치기젖치기", "3710"));
        battleTagDAO.save(new BattleTagDTO("조영제", "gunghi", "3419"));
        battleTagDAO.save(new BattleTagDTO("오영택", "태기", "31271"));
        battleTagDAO.save(new BattleTagDTO("한진원", "Nowniz", "3951"));
        battleTagDAO.save(new BattleTagDTO("홍철민", "근질근질", "3282"));
    }
}
