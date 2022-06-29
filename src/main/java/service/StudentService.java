package service;

import entity.Student;
import repository.StudentDAO;

import java.util.List;


public class StudentService {
    StudentDAO studentDAO = new StudentDAO();

    public List<Student> getListStudent() {
        return studentDAO.getAll();
    }

    public List<Student> searchListStudentByString(String attribute,String values) {
        return studentDAO.findByStringAttribute(attribute,values);
    }

    public List<Student> searchListStudentByNumber(String attribute,float values) {
        return studentDAO.findByFloatAttribute(attribute,values);
    }

    public Student findID(int id) {
        return studentDAO.findById(id);
    }

    public boolean insert(Student student) {
        List<Student> students = studentDAO.getAll();
        students.sort((o1, o2) -> o1.getId() < o2.getId() ? 1 : -1);
        int id = students.get(0).getId() + 1;
        student.setId(id);
        if (student.getName() == null) {
            System.out.println("no name");
            return false;
        }
        return studentDAO.insert(student);
    }

    public boolean removeStudent(int id) {
        return studentDAO.removeStudent(id);
    }
}
