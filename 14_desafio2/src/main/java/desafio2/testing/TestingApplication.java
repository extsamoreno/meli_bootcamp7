package desafio2.testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.modelmapper.ModelMapper;

@SpringBootApplication
public class TestingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestingApplication.class, args);
    }

  /*  @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }*/
}
