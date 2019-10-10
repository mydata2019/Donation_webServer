package dmvno.charging.interface_send;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages ="dmvno.charging.interface_send.mapper")
public class InterfaceSendApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(InterfaceSendApp.class, args);
    }
}
