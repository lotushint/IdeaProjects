package com.lotushint.principle.inversion.improve;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/3/15 21:39
 * @package com.lotushint.principle.inversion
 * @description
 */
public class DependecyInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());

        person.receive(new WeiXin());
    }
}

interface IReceiver {
    public String getInfo();
}

class Email implements IReceiver {
    @Override
    public String getInfo() {
        return "电子邮件信息: hello,world";
    }
}

class WeiXin implements IReceiver{
    @Override
    public String getInfo() {
        return "微信消息：hello,ok";
    }
}
//完成Person接收消息的功能
//方式1分析
//1. 简单，比较容易想到
//2. 如果我们获取的对象是 微信，短信等等，则新增类，同时Perons也要增加相应的接收方法
//3. 解决思路：引入一个抽象的接口IReceiver, 表示接收者, 这样Person类与接口IReceiver发生依赖
//   因为Email, WeiXin 等等属于接收的范围，他们各自实现IReceiver 接口就ok, 这样我们就符号依赖倒转原则
class Person {
    public void receive(IReceiver receiver) {
        System.out.println(receiver.getInfo());
    }
}
