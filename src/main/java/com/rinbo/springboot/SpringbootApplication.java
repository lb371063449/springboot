package com.rinbo.springboot;

import com.rinbo.springboot.properties.Config;
import com.rinbo.springboot.properties.MyAppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

//@ServletComponentScan
@SpringBootApplication
//@EnableAsync
public class SpringbootApplication {
    private static final Logger log = LoggerFactory.getLogger(SpringbootApplication.class);
	public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootApplication.class, args);
        MyAppProperties bean = applicationContext.getBean(MyAppProperties.class);
        System.out.println(bean);
    }

//    @Configuration
//    @PropertySource("classpath:mysql.properties")
//    class MySQLConfig {
//
//        @Autowired
//        private Environment env;
//
//        @Bean
//        public DataSource getMySQLDataSource() {
//            BasicDataSource dataSource = new BasicDataSource();
//            dataSource.setDriverClassName(env.getProperty("db.driver"));
//            dataSource.setUrl(env.getProperty("db.url"));
//            dataSource.setUsername(env.getProperty("db.username"));
//            dataSource.setPassword(env.getProperty("db.password"));
//            return dataSource;
//        }
//
//    }
    @Autowired
    Config config;

	@Value("${libo.name}")
	String name;

//    @Value("${app.trade-start-date}")
//	Date testDate;

    @Bean
    CommandLineRunner myMethod() {
	    return args -> {
	        for (String server:config.getServers()) {
                log.info("##########   my.server is : " + server);
            }
                log.info("##########   my.server is : " + name);
        };
    }

}
@Component
class MyComponent {
    private static final Logger log = LoggerFactory.getLogger(MyComponent.class);
    @Autowired
    public MyComponent(ApplicationArguments args) {
        //it will expect the argument as --<arg>
        boolean enable = args.containsOption("enable");
        if(enable) {
            log.info("## > You are enable!");
        }
        @SuppressWarnings("AlibabaAvoidStartWithDollarAndUnderLineNaming") List<String> _args = args.getNonOptionArgs();
        log.info("## > extra args ...");
        if(!_args.isEmpty()) {
            _args.forEach(file -> log.info(file));
        }
    }
}
