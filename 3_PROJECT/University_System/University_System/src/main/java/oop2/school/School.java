/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2.school;

import oop2.main.User;

/**
 *
 * @author 신홍재
 */
public class School extends User { //User 클래스를 상속 받은 학사 관리자 클래스
    public School(String peoplenum, String name){//객체 생성을 위한생성자
        this.name = name;
        this.peopleNum = peoplenum;
        int random = (int)(Math.random()*(1000-100))+100;
        this.id = "H"+ Integer.toString(random);
        this.passWord = peoplenum.substring(6);
    }
}
