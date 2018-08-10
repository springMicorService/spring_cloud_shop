/*
 *
 *  * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 *  * FileName: IndexController.java
 *  * Author:   18051080
 *  * Date:     2018年8月9日下午07:14:16
 *  * Description: //模块目的、功能描述
 *  * History: //修改记录
 *  * <author>      <time>      <version>    <desc>
 *  * 修改人姓名             修改时间            版本号                  描述
 *
 */

package com.xaven.shop.shop_h5.index;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @Value("${user.userName}")
    private String userName;
    @Value("${user.sex}")
    private String sex;
    @Value("${user.age}")
    private Integer age;

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("user",userName);

        model.addAttribute("name","tom");
        return "index";
    }
}
