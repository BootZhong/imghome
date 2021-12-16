package top.bootzhong.imghome;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主启动类
 * @author bootzhong
 */
@MapperScan(value ="top.bootzhong.imghome.mapper")
@SpringBootApplication
public class ImghomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImghomeApplication.class, args);
    }

}
