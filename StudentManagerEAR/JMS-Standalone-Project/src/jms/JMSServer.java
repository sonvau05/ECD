package jms;

import javax.annotation.Resource;
import javax.jms.*;

public class JMSServer implements MessageListener {

    public static void main(String[] args) {
        try {
            // Khởi tạo ConnectionFactory và Topic từ context hệ thống (hoặc qua JNDI Mock tùy môi trường test)
            // Code chuẩn chạy trực tiếp trên Glassfish/Payara AppClient Container:
            javax.naming.InitialContext ctx = new javax.naming.InitialContext();
            ConnectionFactory factory = (ConnectionFactory) ctx.lookup("java:comp/DefaultJMSConnectionFactory");
            Topic topic = (Topic) ctx.lookup("java:global/jms/exam_topic");

            Connection connection = factory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer consumer = session.createConsumer(topic);

            consumer.setMessageListener(new JMSServer());
            connection.start();

            System.out.println("Waiting....");
            // Giữ luồng chính luôn chạy để chờ xử lý sự kiện tin nhắn đến
            while (true) {
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                String text = ((TextMessage) message).getText();
                System.out.println("Received: " + text);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
