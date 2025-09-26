/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2.professor;

import oop2.main.User;

/**
 *
 * @author 장준혁
 */
public class Professor extends User { //User클래스를 상속 받은 교수 클래스
    public Professor (String peoplenum, String name, String department){//객체 생성을 위한 생성자
        this.name = name;
        this.peopleNum = peoplenum;
        this.departMent = department;
        int random = (int)(Math.random()*(1000-100))+100;
        this.id = "P"+ Integer.toString(random);
        this.passWord = peoplenum.substring(6);
    }
    
     public Professor (String num,String name,String peoplenum,  String department){//객체 생성을 위한 생성자
        this.name = name;
        this.peopleNum = peoplenum;
        this.departMent = department;
        this.id = "P"+ num;
        this.passWord = peoplenum.substring(6);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(String peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getDepartMent() {
        return departMent;
    }

    public void setDepartMent(String departMent) {
        this.departMent = departMent;
    }
}
