package es.spring.boot.demo.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
	// expose "/" that return "Hello World"
	@GetMapping("/")
	public String sayHello() {
		return "Hello World (time server is " + LocalDateTime.now() + ")";
	}
}
