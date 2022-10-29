package ru.dmitrysoldatov.evaapple;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableWebMvc
@EnableSwagger2
public class SpringbootEvaappleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEvaappleApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
