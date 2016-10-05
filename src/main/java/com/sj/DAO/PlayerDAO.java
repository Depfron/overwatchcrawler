package com.sj.DAO;

import com.sj.DTO.PlayerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerDAO extends JpaRepository<PlayerDTO, Integer>{

    PlayerDTO findByNickName(String nickName);
}
