package cn.itcast.order.service;

import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.pojo.User;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);//此时 order.user 为空，但是 order.userId 不为空


        /*// 2.利用 RestTemplate 发起 http 请求，查询用户
        // 2.1. url 路径
        String url = "http://userservice/user/" + order.getUserId();
        // 2.2.发起 http 请求，实现远程调用
        User user = restTemplate.getForObject(url, User.class);*/

        // 2.利用 Feign 远程调用 // TODO Feign 远程调用 2
        User user = userClient.findById(order.getUserId());


        // 3.封装 user 到 order
        order.setUser(user);
        // 4.返回
        return order;
    }
}
