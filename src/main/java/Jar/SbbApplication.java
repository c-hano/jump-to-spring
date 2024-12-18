package Jar;

import Jar.com.mysite.sbb.Question;
import Jar.com.mysite.sbb.QuestionRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class SbbApplication {

    public static void main(String[] args) {

        SpringApplication.run(SbbApplication.class, args);
    }
}
