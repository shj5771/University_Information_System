/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2.lecture;

/**
 *
 * @author 이민우
 */
public class Course {//강좌 객체 강좌 정보를 저장
    private String courseNum; //강좌 번호
    private String courseName; //강좌 이름
    private String professor; //담당 교수
    private String department; // 담당 학과
    private String grade; //학점
    private String course_content; //강의 설명
    private String max; //최대 인원
    private String min; //최저 인원
    private String open; //개설 여부
    private String sGrade =" ";//학생 학점
    private String score=" "; //학생 점수

    public Course(){}
   
    public Course(String courseNum, String courseName, String professor, String department, String grade, String course_content, String max, String min, String open) {
        this.courseNum = courseNum;
        this.courseName = courseName;
        this.professor = professor;
        this.department = department;
        this.grade = grade;
        this.course_content = course_content;
        this.max = max;
        this.min = min;
        this.open = open;
    }

    public Course(String num, String name, String professor,String grade,String sGrade, String score){//학생의 성적 확인용
        this.courseNum = num;
        this.courseName = name;
        this.professor = professor;
        this.grade = grade;
        this.sGrade = sGrade;
        this.score = score;
    }


    public String getsGrade() {
        return sGrade;
    }

    public void setsGrade(String sGrade) {
        this.sGrade = sGrade;
    }
    
    public Course(String num, String name, String professor, String grade){//수강신청 비교용
        this.courseNum = num;
        this.courseName=name;
        this.professor = professor;
        this.grade = grade;
    }
    
    
    
    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }
    
    public String getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCourse_content() {
        return course_content;
    }

    public void setCourse_content(String course_content) {
        this.course_content = course_content;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }
    
    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
