package com.shuxiaoli.chess.controller;

import com.shuxiaoli.chess.entity.FightMessage;
import com.shuxiaoli.chess.entity.User;
import com.shuxiaoli.chess.entity.UserAllFight;
import com.shuxiaoli.chess.service.IFightMessageService;
import com.shuxiaoli.chess.service.IUserAllFightService;
import com.shuxiaoli.chess.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

import static com.shuxiaoli.chess.controller.UserController.USER_ID;


@Controller
public class FightMessageController {

    @Autowired
    IFightMessageService ifms;

    @Autowired
    IUserAllFightService iuafs;
    @Autowired
    IUserService iUserService;
    private static UserAllFight USER_ALL_FIGHT = null;

    //保存走法坐标与走法信息
    @RequestMapping(value = "/testAjaxUrlJson", method = RequestMethod.POST)
    public void  svaSizeAndText(@RequestBody Map<String, String> map) {
        String fightSize = map.get("size").toString();
        String fightText = map.get("text").toString();
        String isMy = map.get("man_my").toString();
        FightMessage fightMessage = new FightMessage();
        fightMessage.setIsMy(isMy);
        fightMessage.setMessageSize(fightSize);
        fightMessage.setMessageText(fightText);
//        fightMessage.setUserAllFightId(USER_ALL_FIGHT);
//        UserAllFight userAllFight = GetAllFight.getUserAllFight(USER_ID);
//        UserAllFight userAllFight = USER_ALL_FIGHT;
//        fightMessage.setUserAllFightId(userAllFight);
//        fightMessage.setUser_id(USER_ALL_FIGHT.getId());
        fightMessage.setUserAllFightId(USER_ALL_FIGHT.getId());


        System.out.println(fightMessage.toString());
        ifms.save(fightMessage);
    }

    //确认对战等级后，保存信息
    @RequestMapping(value = "/savePlayAjaxJson", method = RequestMethod.POST)
    public void saveUserStartFight(@RequestBody Map<String, String> map) {
        String startTime = map.get("startTime").toString();
        String fightLevel = map.get("fightLevel").toString();
        UserAllFight userAllFight = new UserAllFight();
        userAllFight.setFightLevel(fightLevel);
        userAllFight.setStartTime(startTime);
        User user = iUserService.findUserById(USER_ID);
        userAllFight.setUser(user);
        USER_ALL_FIGHT = userAllFight;

        System.out.println(" startTime:" + startTime + "   对战等级：" + fightLevel + "  Id : " +
                user + "  userAllFightId : "+ userAllFight.getId());
        iuafs.save(userAllFight);
    }
    //当一方胜利后更新战局
    @RequestMapping(value = "/setWin", method = RequestMethod.POST)
    public void setWin(@RequestBody Map<String, String> map) {
        String stopTime = map.get("stopTime").toString();
        String isWin = map.get("isWin").toString();
        USER_ALL_FIGHT.setStopTime(stopTime);
        USER_ALL_FIGHT.setIsWin(isWin);
        iuafs.save(USER_ALL_FIGHT);
    }
}
