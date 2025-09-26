/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2.school;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import oop2.professor.Professor;
import oop2.student.Student;

/**
 *
 * @author 신홍재
 */
public class SchoolAdapter {
    public void sp_AddList(JTable tableList, String file) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        //테이블에 학생 교수 리스트 출력
        String str;
        String[] key ;
        BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(file), "euc-kr"));
        DefaultTableModel table = (DefaultTableModel)tableList.getModel();
        table.setNumRows(0);
        while((str = read.readLine()) != null){
            key = str.split("/");
            Object[] list = { key[0], key[1], key[4], key[3]};
            table.addRow(list);//행추가
        }
    }
    
    public String getKey(JTable tablelist){ //테이블에 선택된 키값 전달 
        String key = null;
        DefaultTableModel model = (DefaultTableModel)tablelist.getModel();
        int row = tablelist.getSelectedRow();
        key = (String) model.getValueAt(row, 0);
        return key;
    }
    
    public void getStuList(ArrayList<Student> stulist) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        //학생의 내용을 배열에 저장
        String str;
        String[] key;
        stulist.clear();
        BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream("student.txt"), "euc-kr"));
        while((str = read.readLine()) != null ){
            key = str.split("/");
            stulist.add(new Student(key[0].substring(1),key[1],key[3],key[4]));
        }
    }
    
    public void getProList(ArrayList<Professor> prolist) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        //교수의 내용을 배열에 저장
        String str;
        String[] key;
        prolist.clear();
        BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream("professor.txt"), "euc-kr"));
        while((str = read.readLine()) != null ){
            key = str.split("/");
            prolist.add(new Professor(key[0].substring(1),key[1],key[3],key[4]));
        }
    }
    
    public void getSearch(int index, String info, JTable tablelist,String job, String file) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        //검색
        String str;
        String[] key;
        DefaultTableModel model = (DefaultTableModel)tablelist.getModel();
        BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(file), "euc-kr"));
        model.setNumRows(0);
        info = job+info; //찾아야하는 정보
        while((str=read.readLine())!=null){
            key = str.split("/");
            if(key[index].equals(info)){
                Object[] list = {key[0],key[1],key[4],key[3]};
                model.addRow(list);
            }
        }
    }
    
    public void getExlist(String nowId, ArrayList<String> exlist) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        //회원 정보 변경시 강의를 듣는 학생이 들어있는 파일도 변경을 하기위해 정보 변경을 위한 학생의 강의 목록을 불러온다
        String[] key;
        String str;
        String file = String.format("%s.txt",nowId);
         BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(file), "euc-kr"));
        while((str = read.readLine()) != null){
            key = str.split("/");
            exlist.add(key[0]);
        }
    }
    
    public void exList(String nowId, String num, String name, String department,String peoplenum) throws UnsupportedEncodingException, IOException{
        String file;
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Student> stulist = new ArrayList<>();
        getExlist(nowId, list);//학생이 듣는 강의 번호 받아오기
        String str;
        String[] key;
        for(int i=0; i<list.size(); i++){
            file = String.format("%s.txt", list.get(i));
            BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(file), "euc-kr"));
            while((str = read.readLine())!=null){
                key = str.split("/");
                stulist.add(new Student(key[0],key[1],null,key[2],key[3]));
            }
            insertExList(file,stulist, num, name,department,peoplenum);
        }
    }
    
    public void insertExList(String file, ArrayList<Student> list, String num, String name, String department,String peoplenum) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        BufferedWriter writer = null;
        String str;
        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "euc-kr"));
        for(int i=0; i<list.size();i++){
            if(num.equals(list.get(i).getId())){
                list.get(i).setName(name);
            }
            str = String.format("%s/%s/%s/%s%n",list.get(i).getId(),list.get(i).getName(),list.get(i).getsGrade(),list.get(i).getScore());
            writer.write(str);
        }
        writer.close();
    }
    
    public void createFile(String id) throws IOException{
        File f;
        String filename = String.format("%s.txt", id);
        f = new File(filename);
        f.createNewFile();
    }
}
