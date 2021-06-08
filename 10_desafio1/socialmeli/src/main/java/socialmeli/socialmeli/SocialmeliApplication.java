package socialmeli.socialmeli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import socialmeli.socialmeli.project.repository.UserRepository;

@SpringBootApplication
public class SocialmeliApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialmeliApplication.class, args);

		UserRepository db = new UserRepository();
		db.loadDataBase();
		db.instanceMapUsersFollowers();

	}


}
