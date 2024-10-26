package apisquadra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApiSquadraApplication {

	@GetMapping("/helloword")
	public String helloword(){
		return "hello word";
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiSquadraApplication.class, args);

	}


}
