/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2.student;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import oop2.lecture.Course;

/**
 *
 * @author 장준혁
 */
public class StudentAdapter {

    public void clec_addList(JTable tableList, ArrayList<Course> cleclist) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        // 개설된 강의 테이블에 출력
        DefaultTableModel table = (DefaultTableModel) tableList.getModel();
        table.setNumRows(0);
        for (int i = 0; i < cleclist.size(); i++) {
            Object[] list = {cleclist.get(i).getCourseNum(), cleclist.get(i).getCourseName(), cleclist.get(i).getProfessor(), cleclist.get(i).getGrade()};
            table.addRow(list);//행추가
        }
    }

    public void getCLecList(ArrayList<Course> cleclist) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        //수강신청 화면 테이블에 출력할 배열 불러오기
        String str;
        String[] key;
        cleclist.clear();
        String file = "lecturelist.txt";
        BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(file), "euc-kr"));
        while ((str = read.readLine()) != null) {
            key = str.split("/");
            cleclist.add(new Course(key[0], key[1], key[4], key[3]));//강좌 번호, 강좌 이름, 담당교수, 학점
        }
    }

    public void getStuLecList(ArrayList<Course> sel_sleclist, String id) {
        //학생이 수강신청한 강좌 불러오기(학생 개인의 수강정보)
        String str;
        String[] key;
        sel_sleclist.clear();
        String file = String.format("%s.txt", id);
        BufferedReader read;
        try {
            read = new BufferedReader(new InputStreamReader(new FileInputStream(file), "euc-kr"));
            while ((str = read.readLine()) != null) {
                key = str.split("/");
                sel_sleclist.add(new Course(key[0], key[1], key[2], key[3], key[4], key[5]));
                System.out.println(str);
            }
            //강좌 번호, 강좌 이름, 담당 교수, 강의 학점,학점, 성적
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StudentAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(StudentAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StudentAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getkey(JTable tablelist) {
        //테이블의 키값을 반환하는 함수
        String key = null;
        DefaultTableModel model = (DefaultTableModel) tablelist.getModel();
        int row = tablelist.getSelectedRow();
        key = (String) model.getValueAt(row, 0);
        return key;
    }

    public void slec_addList(JTable tablelist, ArrayList<Course> sleclist) throws UnsupportedEncodingException { //수강신청한 강의 리스트 출력
        DefaultTableModel table = (DefaultTableModel) tablelist.getModel();
        table.setNumRows(0);
        for (int i = 0; i < sleclist.size(); i++) {
            Object[] list = {sleclist.get(i).getCourseNum(), sleclist.get(i).getCourseName(), sleclist.get(i).getProfessor(), sleclist.get(i).getGrade()};
            table.addRow(list);//행추가
        }
    }

    public void clec_ex_addList(JTable tablelist, ArrayList<Course> cleclist) throws UnsupportedEncodingException {
        //변경된 수강신청할 수 있는 리스트 출력
        DefaultTableModel table = (DefaultTableModel) tablelist.getModel();
        table.setNumRows(0);
        for (int i = 0; i < cleclist.size(); i++) {
            Object[] list = {cleclist.get(i).getCourseNum(), cleclist.get(i).getCourseName(), cleclist.get(i).getProfessor(), cleclist.get(i).getGrade()};
            table.addRow(list);//행추가
        }
    }

    public void getSleclist(ArrayList<Course> sel_sleclist, ArrayList<Course> sleclist, String id) {
        //학생 개인의 수강 정보에 들어있는 수강 정보를 비교하여 수강신청 배열에 넣는다  
        sleclist.clear();
        getStuLecList(sel_sleclist, id);
        for (int i = 0; i < sel_sleclist.size(); i++) {
            sleclist.add(new Course(sel_sleclist.get(i).getCourseNum(), sel_sleclist.get(i).getCourseName(), sel_sleclist.get(i).getProfessor(), sel_sleclist.get(i).getGrade()));
        }
    }

    public void cheackList(ArrayList<Course> sleclist, ArrayList<Course> cleclist) {
        //만약 이미 수강신청 폴더가 있다면 수강 신청 할 수 있는 배열 정보 변경
        for (int i = 0; i < sleclist.size(); i++) {
            for (int j = 0; j < cleclist.size(); j++) {
                if (sleclist.get(i).getCourseNum().equals(cleclist.get(j).getCourseNum())) {
                    cleclist.remove(j);
                }
            }
        }
    }
    
    public boolean maxCheck(String lec_num) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        boolean check = false;
        String str;
        String[] key;
        BufferedReader read;
        BufferedReader read2;
        String max = null;
        int num = 0;
        String file = String.format("%s.txt", lec_num);
        read = new BufferedReader(new InputStreamReader(new FileInputStream("lecturelist.txt"), "euc-kr"));
        while ((str = read.readLine()) != null) {
            key = str.split("/");
            if (lec_num.equals(key[0])) {
                max = key[5];
            }
        }
        read.close();
        read2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "euc-kr"));
        while ((str = read2.readLine()) != null) {
            num++;
        }
        if (max.equals(Integer.toString(num))) {
            check = true;
        }
        return check;
    }
}
