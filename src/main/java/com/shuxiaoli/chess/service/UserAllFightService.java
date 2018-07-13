package com.shuxiaoli.chess.service;

import com.shuxiaoli.chess.dao.UserAllFightRepository;
import com.shuxiaoli.chess.entity.UserAllFight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAllFightService implements IUserAllFightService{
    @Autowired
    UserAllFightRepository uafr;
    @Override
    public void save(UserAllFight userAllFight) {
        uafr.save(userAllFight);
    }

    @Override
    public UserAllFight findOne(Integer id) {
        return uafr.findOne(id);

    }
}
