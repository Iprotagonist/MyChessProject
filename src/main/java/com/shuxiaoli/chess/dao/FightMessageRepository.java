package com.shuxiaoli.chess.dao;

import com.shuxiaoli.chess.entity.FightMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FightMessageRepository  extends JpaRepository<FightMessage,Integer>,JpaSpecificationExecutor<FightMessage>{
}
