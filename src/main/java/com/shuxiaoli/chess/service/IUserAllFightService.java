package com.shuxiaoli.chess.service;

import com.shuxiaoli.chess.entity.UserAllFight;

public interface IUserAllFightService {
    void  save(UserAllFight userAllFight);
    UserAllFight findOne(Integer id);
}
