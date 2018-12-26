# spring_cloud_shop
springcloud系列微服务开发实践

 TODO:
 
    1、注册中心
    2、配置中心
    3、feign调用实现  
    4、路由
    5、熔断
    6、注册中心集群实现
    7、日志中心
    8、调用链
    9、中间件集成
    10、注册中心bus全局刷新实现

    
 启动顺序：
 
 eureka——config——order——h5——zuul——zipkin
 
 项目结构：
 shop_api提供接口，shop_h5\shop_order等业务相关统一依赖shop_api。

    
    test
   
   test_branch1222
