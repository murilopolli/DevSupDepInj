package copm.devsup.depinj.services;

import org.springframework.stereotype.Service;

import copm.devsup.depinj.entites.Order;

@Service
public class OrderService {

	private ShippingService shippingService;
	
	public OrderService(ShippingService shippingService) {
		this.shippingService = shippingService;
	}

	public double total(Order order) {
		double total = order.getBasic()-(order.getBasic()*order.getDiscount()/100.0);
		total = total + shippingService.shipment(order);
		return total;
	}
}
