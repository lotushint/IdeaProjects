package com.lotushint.queue;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

// 消息的消费者  也就是回答消息的系统
public class JmsConsumer {
//    public static final String ACTIVEMQ_URL = "tcp://192.168.245.129:61616";
    // 本地 java 代码启动的
    public static final String ACTIVEMQ_URL = "tcp://localhost:61616";
    // public static final String ACTIVEMQ_URL = "nio://192.168.245.129:61608";
    public static final String QUEUE_NAME = "queue01";

    public static void main(String[] args) throws Exception {
        System.out.println(" 这里是 2 号 消费者 ");

        // 1 创建连接工程：按照给定的 url 创建连接工程，这个构造器采用默认的用户名密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        // 2 通过连接工厂：获得连接 connection 并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        // 启动
        connection.start();
        // 3 创建回话 session
        // 两个参数：第一个事务，第二个签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 4 创建目的地 （两种 ： 队列/主题   这里用队列）
        Queue queue = session.createQueue(QUEUE_NAME);
        // 5 创建消息的消费者
        MessageConsumer messageConsumer = session.createConsumer(queue);


/*        //同步阻塞方式 reveive()   空参数的receive方法是阻塞，有参数的为等待时间
        //订阅者或消费者使用 MessageConsumer 的 receive() 方法接收消息，receive 在接收之前一直阻塞
        while (true) {
            // 这里是 TextMessage 是因为消息发送者是 TextMessage ， 接受处理的
            // 也应该是这个类型的消息
            TextMessage textMessage = (TextMessage) messageConsumer.receive(4000L);  // 4秒,不加这个参数就会一直
            if (null != textMessage) {
                System.out.println("****消费者的消息：" + textMessage.getText());
            } else {
                break;
            }
        }
        messageConsumer.close();
        session.close();
        connection.close();*/


        // 通过监听的方式来消费消息
        // 通过异步非阻塞的方式消费消息
        // 通过messageConsumer 的setMessageListener 注册一个监听器，
        // 当有消息发送来时，系统自动调用MessageListener 的 onMessage 方法处理消息
        messageConsumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                if (null != message && message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println("****消费者接受到消息：" + textMessage.getText());
//                        System.out.println("****消费者接受到消息属性：" + textMessage.getStringProperty("c01"));
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
//                if (null != message && message instanceof MapMessage) {
//                    MapMessage mapMessage = (MapMessage) message;
//                    try {
//                        System.out.println("****消费者接受到消息：" + mapMessage.getString("k1"));
//                    } catch (JMSException e) {
//                        e.printStackTrace();
//                    }
//                }
            }
        });

        // System.in.read(); 保证控制台不灭  不然 activemq 还没连上就关掉了连接（messageConsumer.close();session.close();connection.close();）
        System.in.read();
        messageConsumer.close();
        session.close();
        connection.close();
        /*
         * 1 先生产，     只启动 1 号消费者。问题：1 号消费者能消费消息吗？
         * Yes
         *
         * 2 先生产，     先启动 1 号消费者再启动 2 号消费者。问题：2 号消费者能消费消息吗？
         *   2.1 1号可以消费      Yes
         *   2.2 2号可以消费吗？  No
         *
         * 3 先启动 2 个消费者，再生产 6条消息，请问，消费情况如何？
         *   3.1 2 个消费者都有 6条
         *   3.2 先到先得， 6条全给一个
         *   3.3 一人一半                Yes
         */
    }
}
