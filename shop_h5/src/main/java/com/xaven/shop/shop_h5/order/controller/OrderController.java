/*
 *
 *  * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 *  * FileName: OrderController.java
 *  * Author:   18051080
 *  * Date:     2018年8月10日下午08:32:13
 *  * Description: //模块目的、功能描述
 *  * History: //修改记录
 *  * <author>      <time>      <version>    <desc>
 *  * 修改人姓名             修改时间            版本号                  描述
 *
 */

package com.xaven.shop.shop_h5.order.controller;


import com.xaven.shop.order.entity.Order;
import com.xaven.shop.shop_h5.order.service.OrderFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
    @Autowired
    OrderFeignService orderFeignService;

    @RequestMapping("/orderIndex")
    public String orderIndex(){
        Order order = new Order();
        order.setOrderNo("222");

        System.out.println("----------");
      //  orderFrginService.helloService(order);

        System.out.println(orderFeignService.helloService("123131"));

      //  orderFrginService.helloService("name","pass");
        return "222";
    }
}
