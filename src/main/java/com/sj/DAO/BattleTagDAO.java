package com.sj.DAO;

import com.sj.DTO.BattleTagDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BattleTagDAO extends JpaRepository<BattleTagDTO, Integer>{
    BattleTagDTO findByNickName(String nickName);
}
