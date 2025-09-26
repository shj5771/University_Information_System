/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;


/**
 *
 * @author 하태형
 */
public class User {
    

    //학사 담당자, 수업 담당자, 학생, 교수의 상위 클래스
    protected String name; //개인의 이름
    protected String id;  //개인 아이디
    protected String passWord; //개인 비밀번호
    protected String peopleNum; //주민번호
    protected String departMent; //학과
    
     public User(){}
     public User(String id, String name, String passWord, String peopleNum, String departMent){//학생,교수 객체 받기용
         this.id = id;
         this.name = name;
         this.passWord =passWord;
         this.peopleNum = peopleNum;
         this.departMent = departMent;
     }
     
     public User(String id, String name, String passWord, String peopleNum){//수업, 학사관리자 객체 받기용
         this.id = id;
         this.name = name;
         this.passWord =passWord;
         this.peopleNum = peopleNum;
     }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
    public void setName(String name){
        this.name = name;
    }
        
    public String getName() {
        return name;
    }
    
    public String getId() {
        return id;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getPeopleNum() {
        return peopleNum;
    }

    public String getDepartMent() {
        return departMent;
    }
    
    public String searchName(char a, String id) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        //ID에 대한 사용자 이름 찾기
        String filename = null;
        String name = null;
        String text = null;
        switch (a) {
            case 'P':
                filename = "professor.txt";
                text = "euc-kr";
                break;
            case 'H':
                filename = "school.txt";
                text = "utf-8";
                break;
            case 'G':
                filename = "lecture.txt";
                text = "euc-kr";
                break;
            case 'S':
                filename = "student.txt";
                text = "euc-kr";
                break;
        }
        String str;
        String[] key;
        BufferedReader read;
        read = new BufferedReader(new InputStreamReader(new FileInputStream(filename), text));
        while ((str = read.readLine()) != null) {
            if (str.contains(id)) {
                key = str.split("/");
                name = key[1];
            }
        }
        return name;
    }
}
