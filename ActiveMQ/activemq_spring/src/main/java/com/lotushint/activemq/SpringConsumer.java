package com.lotushint.activemq;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/9/19 20:40
 * @package com.lotushint.activemq
 * @description
 */
@Service
public class SpringConsumer {
    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-activemq.xml");
        SpringConsumer consumer = (SpringConsumer) context.getBean("springConsumer");
        String retValue = (String) consumer.jmsTemplate.receiveAndConvert();
        System.out.println("**********消费者收到的消息：" + retValue);
    }
}
