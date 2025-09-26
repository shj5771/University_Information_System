/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2.student;

import oop2.main.User;


/**
 *
 * @author 장준혁
 */
public class Student extends User { //User클래스를 상속 받은 학생 클래스
    String sGrade; //학점   
    String score; //성적
    public Student (String peoplenum, String name, String department){//객체 생성을 위한 생성자
        this.name = name;
        this.peopleNum = peoplenum;
        this.departMent = department;
        int random = (int)(Math.random()*(1000-100))+100;
        this.id = "S"+ Integer.toString(random);
        this.passWord = peoplenum.substring(6);
    }
    public Student (String id, String name, String department, String sGrade, String score){//출석부 용
        this.id = id;
        this.name = name;
        this.departMent = department;
        this.sGrade = sGrade;
        this.score = score;
    }

    public String getsGrade() {
        return sGrade;
    }

    public void setsGrade(String sGrade) {
        this.sGrade = sGrade;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
    public Student (String num, String name, String peoplenum, String department){
        this.name = name;
        this.peopleNum = peoplenum;
        this.departMent = department;
        this.id = "S"+ num;
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
