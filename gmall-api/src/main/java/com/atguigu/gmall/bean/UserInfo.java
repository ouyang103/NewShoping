package com.atguigu.gmall.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author yufei
 * @create 2018-07-30 17:54
 */
public class UserInfo implements Serializable {
    /**
    *用户id
    */
    @Id
    private  String id;
    /**
    *用户姓名
    */
    @Column
    private  String loginName;
    /**
    *用户描述 
    */
    @Column
    private  String nickName;
    /**
    *登记id
    */
    @Column
    private  String passwd;
    /**
    *tm_id
    */
    @Column
    private  String name;
    
    /**
    *phone_num
    */
    @Column
    private  String phone_num;
    
    /**
    *email
    */
    @Column
    private  String email;
    /**
    *head_img
    */
    @Column
    private  String head_img;
    /**
    *user_level
    */
    @Column
    private  String user_level;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHead_img() {
        return head_img;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }

    public String getUser_level() {
        return user_level;
    }

    public void setUser_level(String user_level) {
        this.user_level = user_level;
    }
}
