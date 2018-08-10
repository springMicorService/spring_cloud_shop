package com.xaven.shop.shop_h5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ShopH5Application {

    public static void main(String[] args) {
        SpringApplication.run(ShopH5Application.class, args);
    }
}
