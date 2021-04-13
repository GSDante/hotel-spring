package ufrn.imd.hotelRibbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients("ufrn.imd,hotelRibbon")
@EnableDiscoveryClient
public class HotelRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelRibbonApplication.class, args);
	}

}
