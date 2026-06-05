package session;

import entity.Student;
import java.util.List;
import javax.ejb.Local;

@Local
public interface StudentSession {
    List<Student> getAllStudents();
    void addStudent(Student student);
    void deleteStudent(String rollnumber);
}
