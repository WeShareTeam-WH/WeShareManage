package com.weshare.manage;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.weshare.manage.common.QiniuConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({QiniuConfig.class})
public class Application {

    public static void main(String[] args) {
       SpringApplication.run(Application.class);
    }
}
