/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2.student;

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
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.ListSelectionModel;
import oop2.lecture.Course;
import oop2.main.User;

/**
 *
 * @author 장준혁,변정빈
 */
public class Application_Frame extends javax.swing.JFrame{
    String nowId;
    String nowName; 
    ArrayList<Course> cleclist = new ArrayList<>(); //개설된 강의 배열
    ArrayList<Course> sleclist = new ArrayList<>(); //수강 신청한 강의
    ArrayList<Course> sel_sleclist = new ArrayList<>(); //수강 신청한 파일에 저장할 배열
    StudentAdapter a;
    String file = "lecturelist.txt";
    int sumCredit = 0;//신청 총 학점
    User u= new User();
    File f;
    
    /**
     * Creates new form Application_For_Classes
     */
    
    public Application_Frame(String nowId) throws UnsupportedEncodingException, IOException {//생성자
        initComponents();
        a = new StudentAdapter();
        String s = String.format("%s.txt", nowId);
        f = new File(s);
        a.getCLecList(cleclist);
        Course_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//행단일선택모드
        stu_lec.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.nowId = nowId;
        nowName = u.searchName('S',nowId);
        stu_name.setText(nowName);
        if(f.exists()){//학번으로 된 파일이 있다면
            a.getSleclist(sel_sleclist, sleclist, nowId);//파일에서 수강내역을 불러와서 리스트에 담기
            a.cheackList(sleclist, cleclist); //수강신청 가능 내역과 수강내역 비교
            for(int i = 0; i<sleclist.size(); i++){
                sumCredit += Integer.parseInt(sleclist.get(i).getGrade()); //학점 계산
            }
        }
        Credit_Total.setText(Integer.toString(sumCredit));
        a.clec_addList(Course_Table, cleclist); //신청 가능 내역
        a.slec_addList(stu_lec, sleclist); //내가 수강신청한 내역
    }
    
    public void CreateFile() throws FileNotFoundException, UnsupportedEncodingException, IOException{ //수강신청한 정보를 담는 파일 생성
        String str;
        String filename = String.format("%s.txt", nowId);
        FileOutputStream file = new FileOutputStream(filename);//파일 열기          
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(file,"euc-kr"));
        for(int i = 0; i<sel_sleclist.size();i++){
            str = String.format("%s/%s/%s/%s/%s/%s%n",sel_sleclist.get(i).getCourseNum(),sleclist.get(i).getCourseName(),sleclist.get(i).getProfessor(),sleclist.get(i).getGrade(),sleclist.get(i).getsGrade(),sleclist.get(i).getScore());
            writer.write(str);
        }
        writer.close();  
    }
    
    public void insertLecture(){ //강의마다 학생이름 추가
        String file = null;
        BufferedWriter writer;
        String str;
        try {
            for(int i = 0; i < sel_sleclist.size(); i++) {
                file = String.format("%s.txt", sel_sleclist.get(i).getCourseNum());
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "euc-kr"));
                str = String.format("%s/%s/%s/%s%n", nowId, nowName,sel_sleclist.get(i).getsGrade(),sel_sleclist.get(i).getScore());
                writer.write(str);
                writer.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Application_Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Application_Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Application_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Course_Table = new javax.swing.JTable();
        goback = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Credit_Total = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        create = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        stu_name = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        stu_lec = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        insert = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        lec_info = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        lec_name = new javax.swing.JTextField();
        pro_name = new javax.swing.JTextField();
        lec_num = new javax.swing.JTextField();
        lec_grade = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel1.setText("수강신청 강의 리스트");

        Course_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "번호", "강의이름", "담당교수", "학점"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Course_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Course_TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Course_Table);

        goback.setText("수강신청 페이지 나가기");
        goback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gobackActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        jLabel2.setText("수강 신청한 강의");

        Credit_Total.setEditable(false);

        jLabel3.setText("신청 학점");

        create.setText("수강신청 완료");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });

        jLabel4.setText("/18");

        stu_name.setText("StudentName");

        stu_lec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "강의 번호", "강의 이름", "담당 교수", "학점"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        stu_lec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stu_lecMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(stu_lec);

        jLabel5.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        jLabel5.setText("강의 설명");

        jLabel6.setText("강의 이름");

        jLabel7.setText("담당 교수");

        jLabel8.setText("학점");

        jLabel9.setText("점");

        jLabel10.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        jLabel10.setText("선택강의 정보");

        insert.setText("강의 선택");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });

        delete.setText("강의 삭제");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        lec_info.setEditable(false);

        jLabel11.setText("강의 번호");

        lec_name.setEditable(false);
        lec_name.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        pro_name.setEditable(false);

        lec_num.setEditable(false);

        lec_grade.setEditable(false);
        lec_grade.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                        .addComponent(jScrollPane1))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lec_info)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(create, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(insert, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(goback, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(stu_name, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Credit_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(lec_num, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(jLabel8))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lec_grade, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9))))
                            .addComponent(jLabel10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(pro_name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                .addComponent(lec_name, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1))
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(5, 5, 5)
                        .addComponent(lec_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(1, 1, 1)
                        .addComponent(pro_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lec_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lec_grade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lec_info, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Credit_Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(stu_name))))
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(insert)
                            .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(create, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(goback, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //뒤로가기
    private void gobackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gobackActionPerformed
        // TODO add your handling code here:
        Student_Main_Frame stu;
        try {
            stu = new Student_Main_Frame(nowId,'S');
            stu.setVisible(true);
            dispose();
        } catch (IOException ex) {
            Logger.getLogger(Application_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_gobackActionPerformed
    //수강 정보 학생 개인 파일에 저장
    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        // TODO add your handling code here:
        try {
            
            sel_sleclist.clear();
            for(int i=0; i<sleclist.size(); i++){ //학생이 수강신청 성공한 배열에 저장
                sel_sleclist.add(new Course(sleclist.get(i).getCourseNum(), sleclist.get(i).getCourseName(), sleclist.get(i).getProfessor(),sleclist.get(i).getGrade(), sleclist.get(i).getsGrade(),sleclist.get(i).getScore() ));
            }
            CreateFile();
            insertLecture();
            showMessageDialog(null, "수강신청에 성공하였습니다.");
            Student_Main_Frame stu = new Student_Main_Frame(nowId,'S');
            stu.setVisible(true);
            dispose();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Application_Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Application_Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Application_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_createActionPerformed
    
    //클릭시 선택한 강의정보 출력
    private void Course_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Course_TableMouseClicked
        String str;
        String[] key;
        String num = a.getkey(Course_Table);
        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(file), "euc-kr"));
            while((str=read.readLine())!=null){
                key = str.split("/");
                if(key[0].equals(num)){
                    lec_num.setText(key[0]);
                    lec_name.setText(key[1]);
                    pro_name.setText(key[4]);
                    lec_grade.setText(key[3]);
                    lec_info.setText(key[7]);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Application_Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Application_Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Application_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Course_TableMouseClicked
    //수강신청 취소
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        try {
            //선택한 강의 수강신청할 강의 배열에서 제거
            for (int i = 0; i < sleclist.size(); i++) {
                if (sleclist.get(i).getCourseNum().equals(lec_num.getText())) {
                    sleclist.remove(i);
                }
            }
            //선택된 강의 수강신청 가능한 강의 배열에 추가
            cleclist.add(new Course(lec_num.getText(), lec_name.getText(), pro_name.getText(), lec_grade.getText()));
            //강의 리스트 테이블 업데이트
            a.clec_ex_addList(Course_Table, cleclist);
            //수강신청한 강의 테이블 업데이트
            a.slec_addList(stu_lec, sleclist);
            //삭제한 학점 빼기
            sumCredit -= Integer.parseInt(lec_grade.getText());
            Credit_Total.setText(Integer.toString(sumCredit));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Application_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteActionPerformed
    
    //선택시 선택한 강의 정보 출력
    private void stu_lecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stu_lecMouseClicked
     // TODO add your handling code here:
        String str;
        String[] key;
        String num = a.getkey(stu_lec);
        
        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(file), "euc-kr"));
            while((str=read.readLine())!=null){
                key = str.split("/");
                if(key[0].equals(num)){
                    lec_num.setText(key[0]);
                    lec_name.setText(key[1]);
                    pro_name.setText(key[4]);
                    lec_grade.setText(key[3]);
                    lec_info.setText(key[7]);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Application_Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Application_Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Application_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_stu_lecMouseClicked
    
    //클릭시 수강신청 강의 리스트에서 수강신청한 강의 목록으로 이동
    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        // TODO add your handling code here:
        //if 현재 신청학점 + 추가할 강의 학점 >18
        boolean maxcheck;
        try {
            maxcheck = a.maxCheck(lec_num.getText());
            if ((sumCredit + Integer.parseInt(lec_grade.getText())) > 18) {
                //강의를 신청할 수 없습니다.
                showMessageDialog(null, "신청할 수 있는 학점이 초과되었습니다.");
            } else if (maxcheck) {
                showMessageDialog(null, "수강 가능 인원이 초과되었습니다.");
            } else {
                //강의 리스트에서 선택한 강의 배열에서 삭제
                for (int i = 0; i < cleclist.size(); i++) {
                    if (cleclist.get(i).getCourseNum().equals(lec_num.getText())) {
                        cleclist.remove(i);
                    }
                }
                //선택된 강의 수강신청한 강의 배열에 추가
                sleclist.add(new Course(lec_num.getText(), lec_name.getText(), pro_name.getText(), lec_grade.getText()));
                //강의 리스트 테이블 업데이트
                a.clec_ex_addList(Course_Table, cleclist);
                //수강신청한 강의 테이블 업데이트
                a.slec_addList(stu_lec, sleclist);
                //수강신청한 강의 배열의 학점 수 만큼 신청학점 추가
                sumCredit += Integer.parseInt(lec_grade.getText());
                Credit_Total.setText(Integer.toString(sumCredit));
            }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Application_Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Application_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_insertActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Course_Table;
    private javax.swing.JTextField Credit_Total;
    private javax.swing.JButton create;
    private javax.swing.JButton delete;
    private javax.swing.JButton goback;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField lec_grade;
    private javax.swing.JTextField lec_info;
    private javax.swing.JTextField lec_name;
    private javax.swing.JTextField lec_num;
    private javax.swing.JTextField pro_name;
    private javax.swing.JTable stu_lec;
    public javax.swing.JLabel stu_name;
    // End of variables declaration//GEN-END:variables
}
