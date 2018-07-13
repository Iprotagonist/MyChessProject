package com.shuxiaoli.chess.entity;


import javax.persistence.*;

@Entity
@Table(name = "user_all_fight")
public class UserAllFight {
    @Id
    @GeneratedValue
    private Integer id;
    private String fightLevel; //对战等级
    private String startTime;     //开始时间
    private String stopTime;     //结束时间

    private String isWin;//输赢情况

//    @ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY,optional = true)
    @ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL,fetch=FetchType.LAZY,optional = true)
    @JoinColumn(name="UserId")
    private User user;    //用户

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserAllFight() {
        this.isWin = "暂无输赢";
        this.stopTime = "0000";
    }

    public String getFightLevel() {
        return fightLevel;
    }

    public void setFightLevel(String fightLevel) {
        this.fightLevel = fightLevel;
    }


    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    public String getIsWin() {
        return isWin;
    }

    public void setIsWin(String isWin) {
        this.isWin = isWin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
