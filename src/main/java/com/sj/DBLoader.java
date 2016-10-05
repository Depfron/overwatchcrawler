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

    @PostConstruct
    private void genBattleTagTable() {

        battleTagDAO.save(new BattleTagDTO("홍석진", "Tuna", "3927"));
        battleTagDAO.save(new BattleTagDTO("강은범", "버미", "31735"));
         /*
        battleTags.add(new BattleTagDTO("김재면", "Apple", "3580"));
        battleTags.add(new BattleTagDTO("성열민", "리자몽", "31628"));
        battleTags.add(new BattleTagDTO("이기찬", "아이휴", "3739"));
        //battleTags.add(new BattleTagDTO("전익수", "Sundrops", "3572"));
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
        */
    }
}
