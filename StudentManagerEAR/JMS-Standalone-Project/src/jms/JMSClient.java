package jms;

import javax.jms.*;

public class JMSClient {
    public static void main(String[] args) {
        try {
            javax.naming.InitialContext ctx = new javax.naming.InitialContext();
            ConnectionFactory factory = (ConnectionFactory) ctx.lookup("java:comp/DefaultJMSConnectionFactory");
            Topic topic = (Topic) ctx.lookup("java:global/jms/exam_topic");

            try (JMSContext context = factory.createContext()) {
                String msgText = "Hello JMS";
                context.createProducer().send(topic, msgText);
                System.out.println("Published: " + msgText);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
