package io.github.jiangtj;

import org.influxdb.InfluxDB;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by MrTT (jiang.taojie@foxmail.com)
 * 2018/11/7.
 */
@RestController
@SpringBootApplication
public class SimpleExample {

    @Resource
    private InfluxDB influxDB;

    public static void main(String[] args) {
        SpringApplication.run(SimpleExample.class, args);
    }

    @GetMapping("/query")
    public QueryResult query(String database, String command){
        return influxDB.query(new Query(command, database));
    }

}
