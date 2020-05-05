package com.sujia.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import com.sujia.config.info.JdbcInfo;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

@Configuration
@MapperScan("com.sujia.dao.mapper")
public class DataConfig {

    @Resource
    private JdbcInfo jdbcInfo;

    @Bean
    public DataSource getDataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(jdbcInfo.getUrl());
        dataSource.setUsername(jdbcInfo.getUsername());
        dataSource.setPassword(jdbcInfo.getPassword());
        dataSource.setDriverClassName(jdbcInfo.getDriver());
        return dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {

        return new JdbcTemplate(dataSource);
    }


    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(jdbcInfo.getTypeAliasesPackage());
        // 动态获取SqlMapper
//        PathMatchingResourcePatternResolver classPathResource = new PathMatchingResourcePatternResolver();
//        sqlSessionFactoryBean.setMapperLocations(classPathResource.getResources(propertiesConfig.getMapperLocations()));

        return sqlSessionFactoryBean;
    }

}
