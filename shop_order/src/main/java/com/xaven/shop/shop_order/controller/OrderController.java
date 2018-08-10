/*
 *
 *  * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 *  * FileName: OrderController.java
 *  * Author:   18051080
 *  * Date:     2018年8月10日下午08:28:30
 *  * Description: //模块目的、功能描述
 *  * History: //修改记录
 *  * <author>      <time>      <version>    <desc>
 *  * 修改人姓名             修改时间            版本号                  描述
 *
 */

package com.xaven.shop.shop_order.controller;

import com.xaven.shop.order.api.OrderService;
import com.xaven.shop.order.entity.Order;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
@RestController
public class OrderController implements OrderService {

    private void sleep(String methodName) {
        int sleepMinTime = new Random().nextInt(3000);
        try {
            Thread.sleep(sleepMinTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String helloService(String name) {
        sleep("get");
        System.out.println(name);
        return "HelloServiceImpl name :"+name;
    }

    @Override
    public String helloService(String name, String password) {
        sleep("header");
        System.out.println(name+"--"+password);
        return "helloServiceHead name :"+name +" password:"+password;
    }

    @Override
    public String helloService(Order order) {
        sleep("post");
        System.out.println(order.toString());
        return order.toString();
    }
}
