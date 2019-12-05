package com.swkj.smart.market.regulation;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 81509
 */
@SpringBootApplication
@MapperScan("com.swkj.smart.market.regulation.*.mapper*")
public class SmartMarketRegulationApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmartMarketRegulationApplication.class, args);
    }
}
