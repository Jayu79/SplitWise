package SplitWise;

import SplitWise.commands.RegisterUserCommand;
import SplitWise.commands.UpdateProfileCommand;
import SplitWise.commands.registry.CommandRegistry;
import SplitWise.commands.registry.CommandRegistryImplementation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SplitWiseApplication implements CommandLineRunner {

	public static void main(String[] args){
		SpringApplication.run(SplitWiseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		CommandRegistry commandRegistry = new CommandRegistryImplementation();
		commandRegistry.registerCommand(new RegisterUserCommand());
		commandRegistry.registerCommand(new UpdateProfileCommand());

//		String input = "INPUT FROM COMMAND LINE";
//		String input = "Register jayanth 007 nameisjayu";
		String input = "u1 UpdateProfile jayanth";

		commandRegistry.executeCommandLine(input);

//		while(true){
//
//			String input = "INPUT FROM COMMAND LINE";
//			commandRegistry.executeCommandLine(input);
//
//		}

	}
}