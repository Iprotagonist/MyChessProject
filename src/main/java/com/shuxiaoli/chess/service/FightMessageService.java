package com.shuxiaoli.chess.service;

import com.shuxiaoli.chess.dao.FightMessageRepository;
import com.shuxiaoli.chess.entity.FightMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FightMessageService implements IFightMessageService{
    @Autowired
    FightMessageRepository fmr;
    @Override
    public void save(FightMessage fightMessage) {
        fmr.save(fightMessage);
    }
}
