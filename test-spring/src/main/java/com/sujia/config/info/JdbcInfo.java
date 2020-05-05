package com.sujia.config.info;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:config.properties")
public class JdbcInfo {

    @Value("${URL}")
    private String url;

    @Value("${DRIVER}")
    private String driver;

    @Value("${USERNAME}")
    private String username;

    @Value("${PASSWORD}")
    private String password;

    @Value("${server.ip}")
    private String serverIp;

    @Value("#{${mongo.port}}")
    private int mongoPort;

    @Value("${mybatis.type.alias.package}")
    private String typeAliasesPackage;

    public String getTypeAliasesPackage() {
        return typeAliasesPackage;
    }

    public String getUrl() {
        return url;
    }

    public String getDriver() {
        return driver;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getServerIp() {
        return serverIp;
    }

    public int getMongoPort() {
        return mongoPort;
    }
}
