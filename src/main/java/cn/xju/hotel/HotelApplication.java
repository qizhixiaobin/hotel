package cn.xju.hotel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@ComponentScan("cn.xju.*")
@MapperScan("cn.xju.mapper")
public class HotelApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HotelApplication.class, args);
		String serverPort = context.getEnvironment().getProperty("server.port");
        log.info("ABIN started at http://localhost:" + serverPort);
	}

}
