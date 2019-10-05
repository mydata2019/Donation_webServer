package dmvno.charging.interface_receive;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages ="dmvno.charging.interface_receive.mapper")
public class InterfaceReceiveApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(InterfaceReceiveApp.class, args);
    }
}
