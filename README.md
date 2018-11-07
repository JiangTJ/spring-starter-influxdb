# Spring Starter InfluxDB

本来相对influxdb-java基于spring-boot自动化配置，但似乎没有意义，原因以下两点    
- influxdb与外部服务交互，通过http交互
- influxdb-java会引入okhttp以及retrofit

而在spring cloud中一般使用open-fegin作为http客户端。。。
