# MyShopPlus
本项目为Spring Cloud Alibaba+Spring Cloud Alibaba Dubbo 分布式项目

后端启动顺序
服务提供者先启动
其余可同时启动

## sentinel熔断器启动
```jshelllanguage
java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard-1.7.0.jar
```
其中 -Dserver.port=8080 用于指定 Sentinel 控制台端口为 8080
Sentinel 控制台引入基本的 登录 功能，默认用户名和密码都是 sentinel

- -Dsentinel.dashboard.auth.username=sentinel 用于指定控制台的登录用户名为 sentinel
- -Dsentinel.dashboard.auth.password=123456 用于指定控制台的登录密码为 123456；如果省略这两个参数，默认用户和密码均为 sentinel
- -Dserver.servlet.session.timeout=7200 用于指定 Spring Boot 服务端 session 的过期时间，如 7200 表示 7200 秒；60m 表示 60 分钟，默认为 30 分钟

在启动配有sentinel的服务提供者时，需要在 JVM 中添加以下启动参数

```shell
-Djava.net.preferIPv4Stack=true
-Dcsp.sentinel.api.port=8720
-Dproject.name=ums-admin-provider
-Dcsp.sentinel.dashboard.server=127.0.0.1:8080
```





