package com.example.testspringboot.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.hadoop.hbase.HbaseTemplate;

@Configuration
public class HBaseConfiguration {
    @Bean
    public HbaseTemplate getHbaseTemplate(){
        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();
        conf.set("hbase.zookeeper.quorum", "39.107.33.147");
        return new HbaseTemplate(conf);
    }
}
