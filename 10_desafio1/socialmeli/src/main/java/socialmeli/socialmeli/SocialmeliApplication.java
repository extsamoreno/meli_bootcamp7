package socialmeli.socialmeli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import socialmeli.socialmeli.project.utils.Database;

@SpringBootApplication
public class SocialmeliApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialmeliApplication.class, args);

		Database db = new Database();
		db.loadUsersDataBase();
		db.instanceMapUsersFollowers();
		db.loadPostDataBase();
	}



}
