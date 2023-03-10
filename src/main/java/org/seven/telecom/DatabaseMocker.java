package org.seven.telecom;

import org.seven.telecom.domain.CreateUserRequest;
import org.seven.telecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Configuration
class DatabaseMocker {
	@Value("${create.demo.user}")
	private boolean createUser;
	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	CommandLineRunner initDatabase(UserRepository repository, UserController userController) {
		return args -> {
			CreateUserRequest cnuRequest = new CreateUserRequest();
			cnuRequest.setUsername("fly");
			cnuRequest.setPassword("emirates");
			CreateUserRequest cnuRequest2 = new CreateUserRequest();
			cnuRequest2.setUsername("Mert2");
			cnuRequest2.setPassword("mert1234");
			CreateUserRequest cnuRequest3 = new CreateUserRequest();
			cnuRequest3.setUsername("Mert3");
			cnuRequest3.setPassword("mert12345");
			if(createUser) {
				userController.createUser(cnuRequest);
				userController.createUser(cnuRequest2);
				userController.createUser(cnuRequest3);
			}
		};
	}
}
