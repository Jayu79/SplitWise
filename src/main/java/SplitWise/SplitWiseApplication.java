package SplitWise;

import SplitWise.commands.RegisterUserCommand;
import SplitWise.commands.UpdateProfileCommand;
import SplitWise.commands.registry.CommandRegistry;
import SplitWise.commands.registry.CommandRegistryImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SplitWiseApplication implements CommandLineRunner {

	@Autowired
	private CommandRegistry commandRegistry;
	@Autowired
	private RegisterUserCommand registerUserCommand;
	@Autowired
	private UpdateProfileCommand updateProfileCommand;

	public static void main(String[] args){
		SpringApplication.run(SplitWiseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		commandRegistry.registerCommand(registerUserCommand);
		commandRegistry.registerCommand(updateProfileCommand);

//		String input = "INPUT FROM COMMAND LINE";
//		String input = "Register jayanth 007 nameisjayu";
		String input = "2 UpdateProfile miner007";

		commandRegistry.executeCommandLine(input);
//		while(true){
//
//			String input = "INPUT FROM COMMAND LINE";
//			commandRegistry.executeCommandLine(input);
//
//		}

	}
}