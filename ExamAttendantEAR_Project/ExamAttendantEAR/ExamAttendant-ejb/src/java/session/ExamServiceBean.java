package session;

import entity.Exam;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ExamServiceBean implements ExamService {

    @PersistenceContext(unitName = "ExamPU")
    private EntityManager em;

    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext jmsContext;

    @Resource(lookup = "java:global/jms/exam_topic")
    private Topic examTopic;

    @Override
    public List<Exam> findAllExams() {
        return em.createQuery("SELECT e FROM Exam e ORDER BY e.id DESC", Exam.class).getResultList();
    }

    @Override
    public void saveExam(String name, int duration, String description) {
        try {
            MapMessage message = jmsContext.createMapMessage();
            message.setString("name", name);
            message.setInt("duration", duration);
            message.setString("description", description);

            jmsContext.createProducer().send(examTopic, message);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}