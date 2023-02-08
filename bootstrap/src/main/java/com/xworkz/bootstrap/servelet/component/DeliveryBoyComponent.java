package com.xworkz.bootstrap.servelet.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.bootstrap.servelet.dto.DeliveryDTO;

@Component
@RequestMapping("/delivery")
public class DeliveryBoyComponent {

	public DeliveryBoyComponent() {
		System.out.println("Running : " + getClass().getSimpleName());
	}

	@PostMapping

	public String getData(DeliveryDTO deliveryDto) {

		System.out.println("Running Get Data");
		System.out.println(deliveryDto.toString());
		return "sending.jsp";
	}
	
	
	

}
