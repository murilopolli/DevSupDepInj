package copm.devsup.depinj;

import java.text.DecimalFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import copm.devsup.depinj.entites.Order;
import copm.devsup.depinj.services.OrderService;
import copm.devsup.depinj.services.ShippingService;

@SpringBootApplication
public class DepinjApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepinjApplication.class, args);
		System.out.println();
		
		DecimalFormat df = new DecimalFormat("#,##0.00");
				
		Order order1 = new Order(1034,150.00,20.00);
		Order order2 = new Order(2282,800.00,10.00);
		Order order3 = new Order(1309,95.90,0.00);
		
		ShippingService shippingService = new ShippingService();
		OrderService orderService = new OrderService(shippingService);
		
		System.out.println("Pedido codigo "+order1.getCode());
		System.out.println("Valor total: R$ "+df.format(orderService.total(order1)));
		System.out.println();
		System.out.println("Pedido codigo "+order2.getCode());
		System.out.println("Valor total: R$ "+df.format(orderService.total(order2)));
		System.out.println();
		System.out.println("Pedido codigo "+order3.getCode());
		System.out.println("Valor total: R$ "+df.format(orderService.total(order3)));
	}

}
