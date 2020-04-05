package es.spring.boot.demo.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
	// inject properties for coache name and team name
	@Value("${coach.name}")
	private String coachName;
	@Value("${team.name}")
	private String teamName;

	// expose new endpoint for teaminfo
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "Coach: " + coachName + " team " + teamName;
	}

	// expose "/" that return "Hello World"
	@GetMapping("/")
	public String sayHello() {
		return "Hello World (time server is " + LocalDateTime.now() + ")";
	}

	// expose a new endpoint for "workout"
	@GetMapping("/workout")
	public String getWorkout() {
		return "Run hard!";
	}
}
