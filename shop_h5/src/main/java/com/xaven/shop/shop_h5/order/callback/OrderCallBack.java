/*
 *
 *  * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 *  * FileName: OrderCallBack.java
 *  * Author:   18051080
 *  * Date:     2018年8月10日下午08:34:20
 *  * Description: //模块目的、功能描述
 *  * History: //修改记录
 *  * <author>      <time>      <version>    <desc>
 *  * 修改人姓名             修改时间            版本号                  描述
 *
 */

package com.xaven.shop.shop_h5.order.callback;

import com.xaven.shop.order.entity.Order;
import com.xaven.shop.shop_h5.order.service.OrderFeignService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/callback")
public class OrderCallBack implements OrderFeignService {
    @Override
    public String helloService(String name) {
        return "get error:"+name;
    }

    @Override
    public String helloService(String name, String password) {
        return "head error";
    }

    @Override
    public String helloService(Order order) {
        return "post error";
    }
}
