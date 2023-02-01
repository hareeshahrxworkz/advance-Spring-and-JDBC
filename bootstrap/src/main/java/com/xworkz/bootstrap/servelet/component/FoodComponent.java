package com.xworkz.bootstrap.servelet.component;

import javax.ejb.AfterBegin;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("send")

public class FoodComponent {
	public FoodComponent() {
		System.out.println("Running :" + getClass().getSimpleName());
	}

	@GetMapping

	public String getSend(@RequestParam("name") String name , @RequestParam("type") String type,@RequestParam("range") int quantity, @RequestParam("price") int price) {

		System.out.println("creating getsend");
		System.out.println(name);
		System.out.println(type);
		System.out.println(quantity);
		System.out.println(price);


		return new String("sending.jsp");

	}

}
