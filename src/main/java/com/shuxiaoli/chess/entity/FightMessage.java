package com.shuxiaoli.chess.entity;

import javax.persistence.*;

@Entity
@Table(name = "fightMessage")
public class FightMessage {
    @Id
    @GeneratedValue
    private Integer id;
    private String messageSize;
    private String messageText;
    private String isMy;

//    @ManyToOne
//    @JoinColumn(name="UserAllFightId")
//    private UserAllFight userAllFightId;
    private Integer userAllFightId;
    @Override
    public String toString() {
        return "FightMessage{" +
                "id=" + id +
                ", messageSize='" + messageSize + '\'' +
                ", messageText='" + messageText + '\'' +
                ", isMy='" + isMy + '\'' +
                ", userAllFightId=" + userAllFightId +
                '}';
    }

    public Integer getUserAllFightId() {
        return userAllFightId;
    }

    public void setUserAllFightId(Integer userAllFightId) {
        this.userAllFightId = userAllFightId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessageSize() {
        return messageSize;
    }

    public void setMessageSize(String messageSize) {
        this.messageSize = messageSize;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getIsMy() {
        return isMy;
    }

    public void setIsMy(String isMy) {
        this.isMy = isMy;
    }
}
