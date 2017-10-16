package org.borko.spring.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, 
									DataSourceTransactionManagerAutoConfiguration.class,
									HibernateJpaAutoConfiguration.class,
									ErrorMvcAutoConfiguration.class})
public class SprinStartApp {

	public static void main(String[] args) {
		SpringApplication.run(SprinStartApp.class, args);

	}
}
