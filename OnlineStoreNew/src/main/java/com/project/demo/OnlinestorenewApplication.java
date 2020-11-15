package com.project.demo;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.project.demo.persitance.model.UserModel;
import com.project.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;
import java.util.stream.Stream;


@SpringBootApplication
public class OnlinestorenewApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlinestorenewApplication.class, args);
    }

//        @Bean
//        CommandLineRunner init(UserRepository userRepository) {
//        return args -> {
//               List<UserModel> userModels = userRepository.findAll();
//          for (UserModel userModel: userModels){
//               userModel.setPassword("admin");
//               userRepository.save(userModel);
//            }
//        };
//    }

    @Bean
    public Module hibernate5Module()
    {
        return new Hibernate5Module();
    }

}
