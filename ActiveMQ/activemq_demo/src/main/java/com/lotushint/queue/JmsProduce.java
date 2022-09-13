package com.lotushint.queue;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsProduce {
    //  linux 上部署的activemq 的 IP 地址 + activemq 的端口号，如果用自己的需要改动
    public static final String ACTIVEMQ_URL = "tcp://192.168.245.129:61616";
    //    public static final String ACTIVEMQ_URL = "nio://192.168.245.130:61608";
    public static final String QUEUE_NAME = "queue01";


    public static void main(String[] args) throws Exception {

        // 1 创建连接工程：按照给定的 url 创建连接工程，这个构造器采用默认的用户名密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        // 设置允许有数据丢失
        //activeMQConnectionFactory.setUseAsyncSend(true);
        // 2 通过连接工厂：获得连接 connection 并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        //  启动
        connection.start();
        // 3 创建回话 session
        // 两个参数：第一个事务，第二个签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 4 创建目的地 （两种 ： 队列/主题   这里用队列）
        Queue queue = session.createQueue(QUEUE_NAME);
        // 5 创建消息的生产者
        MessageProducer messageProducer = session.createProducer(queue);

        // 非持久化消息 和 持久化消息演示
//        messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);   // 持久化模式  如果开启 就会存入文件或数据库中
//        messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);   // 非持久化模式
        // 不设置模式默认：持久化模式

        // 6 通过使用 messageProducer 生产 3 条 消息发送到 MQ 消息队列中
        for (int i = 1; i < 4; i++) {
            // 7  创建字消息，好比学生按照要求写好的面试题信息
            TextMessage textMessage = session.createTextMessage("textMessage msg--" + i);
//            textMessage.setStringProperty("c01", "vip");
            // 8  通过messageProducer发布消息
            messageProducer.send(textMessage);

//            MapMessage mapMessage = session.createMapMessage();
//            mapMessage.setString("k1", "mapMessage---v1");
//            messageProducer.send(mapMessage);
        }
        // 9 关闭资源
        messageProducer.close();
        session.close();
        connection.close();
        // session.commit();
        System.out.println("  **** 消息发送到MQ完成 ****");

        //rdb aof
    }
}
