package com.hcbxwy.wegee.service.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 系统服务
 *
 * @author Billson
 * @since 2019-08-18 12:20
 */
@SpringBootApplication
@MapperScan("com.hcbxwy.wegee.service.system.**.mapper")
public class ServiceSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceSystemApplication.class, args);
	}

}
