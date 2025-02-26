package copm.devsup.depinj.services;

import org.springframework.stereotype.Service;

import copm.devsup.depinj.entites.Order;

@Service
public class ShippingService {

	public double shipping(Order order) {
		double shipping = 0.0;
		if(order.getBasic() < 100.00)
			shipping = 20.00;
		if(order.getBasic() >= 100.00 && order.getBasic() < 200.00)
			shipping = 12.00;
		
		return shipping;
	}
}
