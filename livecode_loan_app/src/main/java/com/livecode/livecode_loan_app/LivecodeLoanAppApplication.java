package com.livecode.livecode_loan_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LivecodeLoanAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivecodeLoanAppApplication.class, args);
	}

	// @Bean
	// public CommandLineRunner commandLineRunner(
	// AuthenticationService authenticationService) {
	// return args -> {
	// var admin = RegisterRequest.builder()
	// // .firstName("yamate")
	// // .lastName("kudasai")
	// .email("yamatekudasai@gmail.com")
	// .password("1234")
	// .role(Role.ADMIN)
	// .build();
	// System.out.println("Admin token: " +
	// authenticationService.register(admin).getToken());

	// var staff = RegisterRequest.builder()
	// // .firstName("ikehikeh")
	// // .lastName("kimochi")
	// .email("ikehikehkimochi@gmail.com")
	// .password("1234")
	// .role(Role.STAFF)
	// .build();
	// System.out.println("Manager token: " +
	// authenticationService.register(staff).getToken());
	// };
	// }

}
