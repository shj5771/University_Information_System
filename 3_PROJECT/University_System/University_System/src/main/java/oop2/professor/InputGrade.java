/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2.professor;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oop2.lecture.Course;
import oop2.main.User;
import oop2.student.Student;

/**
 * InputGrade.java -학생 성적 입력하는 클래스
 *
 * @author 장준혁,변정빈
 */


// try/catch -> 성공메시지 / 오류 메시지 출력 
// 오류 메시지 (1) 성적 입력 실패 or 값 입력 실패
// 오류 메시지 (2) 해당되는 테이블(값)이 없습니다. 
// 오류 메시지 (3) 이미 성적 부여 완료되었습니다. 수정하시겠습니까? -> 확인 or 취소 버튼 생성
// 오류 메시지 (4) 값 불일치(강좌번호와 강좌명 불일치/학번과 이름 불일치)
// 자바 파일에서 문자열 찾기 -> 저장된 값 찾기

public class InputGrade extends javax.swing.JFrame {
    User u = new User();
    String nowId;
    String nowNum;
    String lecName;
    String nowName;
    String stuId;
    ArrayList<Student> bookList = new ArrayList<>();//출석부
    ArrayList<Course> stuList = new ArrayList<>();//학생 성적 확인
    /**
     * Creates new form InputGrade
     */
    public InputGrade(String lecName, String nowNum, String nowId, String stuId) throws UnsupportedEncodingException, IOException {
        initComponents();
        this.lecName = lecName; //강좌 이름
        this.nowNum = nowNum; //강좌 번호
        this.nowId = nowId; // 교수iD
        this.nowName = u.searchName('S', stuId); //학생 이름
        this.stuId = stuId; //학번
        getList();
        causeNum.setText(nowNum);
        causeName.setText(lecName);
        studentNum.setText(stuId);
        studentName.setText(nowName);
    }
    
    public int getStu(){
        int index = 0;
        for(int i = 0 ; i<stuList.size();i++){
            if(stuList.get(i).getCourseNum().equals(nowNum))
                index = i;
        }
        return index;
    }
    
    public int getBook(){
        int index = 0;
        for(int i = 0 ; i<bookList.size();i++){
            if(bookList.get(i).getId().equals(stuId))
                index = i;
        }
        return index;
    }
    
    public void getList(){ //성적 입력을 위한 리스트 받아오기
        bookList.clear(); //학번, 이름, 학과, 학점, 성적
        stuList.clear(); //강좌번호, 강좌 제목, 교수 ,학점,성적
        String bfile = String.format("%s.txt", nowNum);
        String sfile = String.format("%s.txt", stuId);
        String str;
        String[] key;
        try {
            BufferedReader bread = new BufferedReader(new InputStreamReader(new FileInputStream(bfile), "euc-kr"));
            while((str = bread.readLine())!=null){
                key = str.split("/");
                bookList.add(new Student(key[0],key[1],null,key[2],key[3]));
            }
             BufferedReader sread = new BufferedReader(new InputStreamReader(new FileInputStream(sfile), "euc-kr"));
            while((str = sread.readLine())!=null){
                key = str.split("/");
                stuList.add(new Course(key[0],key[1],key[2],key[3],key[4],key[5]));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InputGrade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(InputGrade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InputGrade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertList(){
        String bfile = String.format("%s.txt", nowNum);
        String sfile = String.format("%s.txt", stuId);
        FileOutputStream file;
        try {
            file = new FileOutputStream(bfile);//강좌 파일 열기
            OutputStreamWriter output1 = new OutputStreamWriter(file, "euc-kr");
            BufferedWriter writer1 = new BufferedWriter(output1);
            for(int i =0; i<bookList.size();i++){
                String str = String.format("%s/%s/%s/%s%n", bookList.get(i).getId(),bookList.get(i).getName(),bookList.get(i).getsGrade(),bookList.get(i).getScore());
                writer1.write(str);
            }
            writer1.close();
            file = new FileOutputStream(sfile);//학생 파일 열기
            OutputStreamWriter output2 = new OutputStreamWriter(file, "euc-kr");
            BufferedWriter writer2 = new BufferedWriter(output2);
            for(int i =0; i<stuList.size();i++){
                String str = String.format("%s/%s/%s/%s/%s/%s%n", stuList.get(i).getCourseNum(),stuList.get(i).getCourseName(),stuList.get(i).getProfessor(), stuList.get(i).getGrade(),stuList.get(i).getsGrade(),stuList.get(i).getScore());
                writer2.write(str);
            }
            writer2.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InputGrade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(InputGrade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InputGrade.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        jDialog2 = new javax.swing.JDialog();
        jOptionPane1 = new javax.swing.JOptionPane();
        jOptionPane2 = new javax.swing.JOptionPane();
        grade = new javax.swing.JComboBox<>();
        OK_Btn = new javax.swing.JButton();
        Cancel_Btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        studentName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        causeName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        causeNum = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        studentNum = new javax.swing.JTextField();

        jDialog1.setTitle("성적 입력 성공");
        jDialog1.setSize(new java.awt.Dimension(200, 200));

        jLabel4.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        jDialog2.setTitle("성적 입력 실패");
        jDialog2.setSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("성적 입력");

        grade.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        grade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "F" }));

        OK_Btn.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        OK_Btn.setText("확인");
        OK_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OK_BtnActionPerformed(evt);
            }
        });

        Cancel_Btn.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        Cancel_Btn.setText("취소");
        Cancel_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancel_BtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 0, 24)); // NOI18N
        jLabel1.setText("성적 입력");

        jLabel2.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel2.setText("학점");

        jLabel3.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel3.setText("이름");

        studentName.setEditable(false);
        studentName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel5.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel5.setText("강좌명");

        causeName.setEditable(false);
        causeName.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel6.setText("강좌번호");

        causeNum.setEditable(false);

        jLabel7.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel7.setText("학번");

        studentNum.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(Cancel_Btn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(OK_Btn))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(studentName, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                    .addComponent(grade, 0, 84, Short.MAX_VALUE)
                                    .addComponent(causeNum)
                                    .addComponent(causeName, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                                .addComponent(studentNum, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(76, 80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(causeNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(causeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(studentNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(studentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(grade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OK_Btn)
                    .addComponent(Cancel_Btn))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        //취소
    private void Cancel_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cancel_BtnActionPerformed
        // TODO add your handling code here:
        AttendanceBook b = new AttendanceBook(nowId, nowNum, lecName);
        b.setVisible(true);
        dispose();
    }//GEN-LAST:event_Cancel_BtnActionPerformed

    private void OK_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OK_BtnActionPerformed
        // 확인 버튼 기능
        int bindex = getBook();
        int sindex = getStu();
        if (causeNum.getText().isEmpty() || causeName.getText().isEmpty() || studentNum.getText().isEmpty()
                || studentName.getText().isEmpty()) {
            // 값이 하나라도 입력되지 않았을 경우
            JOptionPane.showMessageDialog(null, "정보를 모두 입력해 주세요.", "성적 입력 실패", JOptionPane.WARNING_MESSAGE);
        } else {
            // 학점별 학점수 초기화
            if(grade.getSelectedItem()=="A") {//A학점
                bookList.get(bindex).setScore("4.0");
                bookList.get(bindex).setsGrade("A");
                stuList.get(sindex).setScore("4.0");
                stuList.get(sindex).setsGrade("A");
            }else if(grade.getSelectedItem()=="B") {//B학점
                bookList.get(bindex).setScore("3.0");
                bookList.get(bindex).setsGrade("B");
                stuList.get(sindex).setScore("3.0");
                stuList.get(sindex).setsGrade("B");
            }else if(grade.getSelectedItem()=="C") {//C학점
                bookList.get(bindex).setScore("2.0");
                bookList.get(bindex).setsGrade("C");
                stuList.get(sindex).setScore("2.0");
                stuList.get(sindex).setsGrade("C");
            } else if (grade.getSelectedItem() == "D") {//D학점
                bookList.get(bindex).setScore("1.0");
                bookList.get(bindex).setsGrade("D");
                stuList.get(sindex).setScore("1.0");
                stuList.get(sindex).setsGrade("D");
            } else if (grade.getSelectedItem() == "F") {//F학점
                bookList.get(bindex).setScore("0.0");
                bookList.get(bindex).setsGrade("F");
                stuList.get(sindex).setScore("0.0");
                stuList.get(sindex).setsGrade("F");
            }
            insertList();//파일에 저장
            JOptionPane.showMessageDialog(null, "성적 입력이 완료되었습니다.", "성적 입력 성공", JOptionPane.PLAIN_MESSAGE);  // 성적 입력 성공
            AttendanceBook b = new AttendanceBook(nowId, nowNum, lecName);
            b.setVisible(true);
            dispose();
        } // 성적 입력 실패
        
    }//GEN-LAST:event_OK_BtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel_Btn;
    private javax.swing.JButton OK_Btn;
    private javax.swing.JTextField causeName;
    private javax.swing.JTextField causeNum;
    private javax.swing.JComboBox<String> grade;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JOptionPane jOptionPane2;
    private javax.swing.JTextField studentName;
    private javax.swing.JTextField studentNum;
    // End of variables declaration//GEN-END:variables
}
