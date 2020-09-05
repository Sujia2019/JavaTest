package com.example.testspringboot.dao;

import org.apache.hadoop.hbase.client.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StuHBase {
    @Autowired
    HbaseTemplate template;

}
