package com.hcbxwy.wegee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 系统服务
 *
 * @author Billson
 * @since 2019-08-18 12:20
 */
@SpringBootApplication
@ServletComponentScan
public class WeGeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeGeeApplication.class, args);
	}

}
