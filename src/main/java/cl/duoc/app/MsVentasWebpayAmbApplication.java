package cl.duoc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsVentasWebpayAmbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsVentasWebpayAmbApplication.class, args);
	}

}
