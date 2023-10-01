package jpabook.jpashop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpashopApplication {

	public static void main(String[] args) {

		hello hello = new hello();
		hello.setHello("Hello");
		String Data = hello.getHello();

		System.out.println("data = " + Data);




		SpringApplication.run(JpashopApplication.class, args);
	}

}
