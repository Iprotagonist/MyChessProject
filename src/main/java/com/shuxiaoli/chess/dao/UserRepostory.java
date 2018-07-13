package com.shuxiaoli.chess.dao;

import com.shuxiaoli.chess.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepostory extends JpaRepository<User,Integer>,JpaSpecificationExecutor<User> {
}
