package dev.balu.runnerz;
import dev.balu.runnerz.run.Location;
import dev.balu.runnerz.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@SpringBootApplication
public class Application {

	private static final Logger log = (Logger) LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
//		log.info("Welcome to the Application");

	}
	@Bean
	CommandLineRunner runner(){
		return args-> {
		//	log.info("Welcome to the application");
			Run run = new Run(1,"FirstRun", LocalDateTime.now(),LocalDateTime.now().plus(1, ChronoUnit.HOURS),5, Location.OUTDOOR);
			log.info("Run: "+run);
		};

	}

}
