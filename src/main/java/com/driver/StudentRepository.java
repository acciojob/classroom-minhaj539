package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentDb=new HashMap<>();
    HashMap<String,Teacher> teacherDb=new HashMap<>();
    HashMap<String, List<String>> pair=new HashMap<>();

    public String addStudentToDb(Student student){
        String key=student.getName();
        studentDb.put(key,student);
        return "New student added successfully";
    }
    public String addTeacherToDb(Teacher teacher){
        teacherDb.put(teacher.getName(),teacher);
        return "added teacher";
    }
    public String pairing(String studentName,String teacherName){
        if(studentDb.containsKey(studentName)&&teacherDb.containsKey(teacherName)){
            if(!pair.containsKey(teacherName)){
                List<String> l=new ArrayList<>();
                l.add(studentName);
                pair.put(teacherName,l);

            }
            else{
                List<String> l=pair.get(teacherName);
                l.add(studentName);
                pair.put(teacherName,l);
            }


            return "paired sucessfully";
        }
        return "param does not exist";
    }
    public Student getStudentFromDb(String studentName){
        if(studentDb.containsKey(studentName)) return studentDb.get(studentName);
        return null;
    }


   public Teacher getTeacherFromDb(String teacherName){
        if(teacherDb.containsKey(teacherName)) return teacherDb.get(teacherName);
        return null;
   }
   public List<String> listOfStudentsByTeacherName(String teacherName){
        if(pair.containsKey(teacherName)) return pair.get(teacherName);
        return null;
   }
   public List<String> getAllStudents(){
        List<String> l=new ArrayList<>();
        for(String st:studentDb.keySet()){
            l.add(st);
        }
        return l;
   }
   public String deleteTeacherFromDb(String teacherName){
        if(teacherDb.containsKey(teacherName)) {
            if (pair.containsKey(teacherName)) {
                List<String> students = pair.get(teacherName);
                for (String st : students) {
                    if (studentDb.containsKey(st)) studentDb.remove(st);
                }
                pair.remove(teacherName);

            }
            teacherDb.remove(teacherName);
            return "deleted sucessfully";
        }

        return "teacher does not exist";
   }
   public String deleteAllTeachers(){
        for(String teacher:pair.keySet()){
            List<String> studentList=pair.get(teacher);
            for(String student:studentList){

                if(studentDb.containsKey(student)) studentDb.remove(student);
            }
        }
        teacherDb.clear();
        pair.clear();

        return "all teachers deleted sucessfully";
   }


}
