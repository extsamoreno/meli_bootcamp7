package socialmeli.socialmeli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import socialmeli.socialmeli.project.repository.UserRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class SocialmeliApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialmeliApplication.class, args);

		UserRepository db = new UserRepository();
		db.loadDataBase();
		db.instanceMapUsersFollowers();
	}



}
