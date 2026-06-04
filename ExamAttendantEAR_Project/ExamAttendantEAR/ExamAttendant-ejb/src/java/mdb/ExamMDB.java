package mdb;

import entity.Exam;
import java.util.Date;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:global/jms/exam_topic"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class ExamMDB implements MessageListener {

    @PersistenceContext(unitName = "ExamPU")
    private EntityManager em;

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof MapMessage) {
                MapMessage mapMsg = (MapMessage) message;

                Exam exam = new Exam();
                exam.setName(mapMsg.getString("name"));
                exam.setDuration(mapMsg.getInt("duration"));
                exam.setDescription(mapMsg.getString("description"));

                Date currentTime = new Date();
                exam.setCreatedAt(currentTime);
                exam.setUpdatedAt(currentTime);

                em.persist(exam);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}