/*
 *
 *  * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 *  * FileName: OrderService.java
 *  * Author:   18051080
 *  * Date:     2018年8月10日下午07:48:14
 *  * Description: //模块目的、功能描述
 *  * History: //修改记录
 *  * <author>      <time>      <version>    <desc>
 *  * 修改人姓名             修改时间            版本号                  描述
 *
 */

package com.xaven.shop.order.api;

import com.xaven.shop.order.entity.Order;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value="/order-service")
public interface OrderService {

    @RequestMapping(value = "/serviceGet", method = RequestMethod.GET)
    String helloService(@RequestParam("name") String name);

    @RequestMapping(value = "/serviceHead", method = RequestMethod.HEAD)
    String helloService(@RequestHeader("name") String name,
            @RequestHeader("password") String password);

    @RequestMapping(value = "/servicePost", method = RequestMethod.POST)
    String helloService(@RequestBody Order order);
}
