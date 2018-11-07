package io.github.jiangtj.influxdb;

import lombok.Data;
import org.influxdb.InfluxDB;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

/**
 * Created by MrTT (jiang.taojie@foxmail.com)
 * 2018/9/26.
 */
@Data
@ConfigurationProperties(prefix = "influxdb")
public class InfluxDBProperties {

    /**
     * Open/stop influxdb config, default true.
     */
    private boolean enabled = true;

    /**
     * Connect Addr
     */
    private String host = "http://localhost:8086";

    /**
     * user
     */
    private String user;

    /**
     * password
     */
    private String password;

    /**
     * database name
     */
    private String database;

    /**
     * InfluxDB log level
     */
    private InfluxDB.LogLevel logLevel = InfluxDB.LogLevel.BASIC;

    /**
     * retention policy
     */
    private String retentionPolicy;


}
