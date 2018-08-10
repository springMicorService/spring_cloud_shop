/*
 *
 *  * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 *  * FileName: OrderFrginService.java
 *  * Author:   18051080
 *  * Date:     2018年8月10日下午08:33:27
 *  * Description: //模块目的、功能描述
 *  * History: //修改记录
 *  * <author>      <time>      <version>    <desc>
 *  * 修改人姓名             修改时间            版本号                  描述
 *
 */

package com.xaven.shop.shop_h5.order.service;

import com.xaven.shop.order.api.OrderService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name="shop-order")
public interface OrderFrginService extends OrderService {
}
