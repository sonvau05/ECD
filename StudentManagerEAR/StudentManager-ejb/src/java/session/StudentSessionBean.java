package session;

import entity.Student;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class StudentSessionBean implements StudentSession {

    @PersistenceContext(unitName = "StudentPU")
    private EntityManager em;

    @Override
    public List<Student> getAllStudents() {
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Override
    public void addStudent(Student student) {
        em.persist(student);
    }

    @Override
    public void deleteStudent(String rollnumber) {
        Student student = em.find(Student.class, rollnumber);
        if (student != null) {
            em.remove(student);
        }
    }
}
