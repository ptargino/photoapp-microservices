package com.example.photoapp.api.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PhotoAppApiUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppApiUsersApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public WebClient.Builder loadBalancedWebClientBuilder() {
		return WebClient.builder();
	}

}
