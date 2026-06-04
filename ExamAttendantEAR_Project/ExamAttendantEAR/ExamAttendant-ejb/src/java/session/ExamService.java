package session;

import entity.Exam;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ExamService {
    List<Exam> findAllExams();
    void saveExam(String name, int duration, String description);
}