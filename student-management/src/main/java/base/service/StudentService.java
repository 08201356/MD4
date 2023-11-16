package base.service;

import base.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IStudentService<Student>{
    private List<Student> studentList = new ArrayList<>();
    @Override
    public List<Student> findAll(){
        return studentList;
    }
    @Override
    public int findById(int id){
        for(int i = 0; i < studentList.size(); i++){
            if(id == studentList.get(i).getId())
                return i;
        }
        return -1;
    }
    @Override
    public List<Student> findByName(String name){
        List<Student> students = new ArrayList<>();
        for(Student student: studentList){
            if(student.getName().toUpperCase().contains(name.toUpperCase()))
                students.add(student);
        }
        return students;
    }
    @Override
    public void add(Student student){
        studentList.add(student);
    }
    @Override
    public void update(int id, Student student){
        int index = findById(id);
        studentList.set(index, student);
    }
    @Override
    public void remove(int id){
        int index = findById(id);
        studentList.remove(index);
    }
    public Student findStudentById(int id){
        return this.studentList.get(findById(id));
    }
}
