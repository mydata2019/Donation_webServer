package don.point;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import don.point.PointApplication;

@SpringBootApplication
@MapperScan(basePackages ="don.point.mapper")
public class PointApplication {

	public static void main(String[] args) {
		SpringApplication.run(PointApplication.class, args);
	}
}
