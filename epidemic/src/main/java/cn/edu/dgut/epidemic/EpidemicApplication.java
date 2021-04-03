package cn.edu.dgut.epidemic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = org.activiti.spring.boot.SecurityAutoConfiguration.class)
@MapperScan("cn.edu.dgut.epidemic.mapper")
public class EpidemicApplication {

	public static void main(String[] args) {
		SpringApplication.run(EpidemicApplication.class, args);
	}

}
