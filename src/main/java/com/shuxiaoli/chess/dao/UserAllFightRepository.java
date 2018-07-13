package com.shuxiaoli.chess.dao;

import com.shuxiaoli.chess.entity.UserAllFight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserAllFightRepository  extends JpaRepository<UserAllFight,Integer>,JpaSpecificationExecutor<UserAllFight>{
}
