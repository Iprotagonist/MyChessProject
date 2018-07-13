package com.shuxiaoli.chess.service;

import com.shuxiaoli.chess.dao.UserRepository;
import com.shuxiaoli.chess.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    UserRepository ur;


    @Override
    public List<User> findOne(String userName) {
        List<User> result = ur.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> userList = new ArrayList<>();
                userList.add(criteriaBuilder.like(root.get("user_name").as(String.class), userName));
                Predicate[] p = new Predicate[userList.size()];
                return criteriaBuilder.and(userList.toArray(p));
            }
        });
        return result;
    }

    @Override
    public void saveUser(User user) {
        ur.save(user);
    }

    @Override
    public List<User> findAll() {
        return ur.findAll();
    }

    @Override
    public User findUserById(Integer id) {
        return ur.findOne(id);
    }


}
