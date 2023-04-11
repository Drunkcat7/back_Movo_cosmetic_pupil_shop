package com.back_movo_cosmetic_pupil_shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.back_movo_cosmetic_pupil_shop.dao")
public class BackMovoCosmeticPupilShopApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackMovoCosmeticPupilShopApplication.class, args);
	}

}
