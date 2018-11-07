package io.github.jiangtj.influxdb;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.util.StringUtils;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Arrays;

/**
 * Created by MrTT (jiang.taojie@foxmail.com)
 * 2018/9/27.
 */
@Configuration
@Import({InfluxDBProperties.class})
@ConditionalOnProperty(prefix = "influxdb", name = "enabled", havingValue = "true", matchIfMissing = true)
public class InfluxDBAutoConfiguration {

    @Resource
    private InfluxDBProperties properties;

    @Bean(destroyMethod = "close")
    public InfluxDB influxDB(){
        String user = properties.getUser();
        InfluxDB influxDB;
        if (StringUtils.isEmpty(user)) {
            influxDB = InfluxDBFactory.connect(properties.getHost());
        } else {
            influxDB = InfluxDBFactory.connect(properties.getHost(), user, properties.getPassword());
        }
        influxDB.setDatabase(properties.getDatabase());
        influxDB.setLogLevel(properties.getLogLevel());
        influxDB.setRetentionPolicy(properties.getRetentionPolicy());
        return influxDB;
    }

}
