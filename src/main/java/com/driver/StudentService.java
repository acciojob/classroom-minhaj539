package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public String addStudent(Student student){
        return studentRepository.addStudentToDb(student);
    }
    public String addTeacher(Teacher teacher){
        return studentRepository.addTeacherToDb(teacher);
    }
    public String pairing(String studentName,String teacherName){
        return studentRepository.pairing(studentName,teacherName);
    }
    public Student getStudentByName(String studentName){
        return studentRepository.getStudentFromDb(studentName);
    }

    public Teacher getTeacherByName(String teacherName){
        return studentRepository.getTeacherFromDb(teacherName);
    }
    public List<String> getStudentsByTeacherName(String teacherName){
        return studentRepository.listOfStudentsByTeacherName(teacherName);
    }
    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }
    public String deleteTeacherByName(String teacherName){
        return studentRepository.deleteTeacherFromDb(teacherName);
    }
    public String deleteAllTeachers(){
        return studentRepository.deleteAllTeachers();
    }

}
