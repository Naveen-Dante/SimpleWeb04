package com.epam.simpleweb04.command;

import java.util.HashMap;
import java.util.Map;

import com.epam.simpleweb04.command.impl.LoginCommand;
import com.epam.simpleweb04.command.impl.LogoutCommand;
import com.epam.simpleweb04.command.impl.NewUserCommand;
import com.epam.simpleweb04.command.impl.PageLoadCommand;

public class CommandProvider {

	private static Map<String, Command> commandMap = new HashMap<String, Command>();
	
	public CommandProvider(){
		commandMap.put("get", new PageLoadCommand());
		commandMap.put("login", new LoginCommand());
		commandMap.put("new", new NewUserCommand());
		commandMap.put("logout", new LogoutCommand());
	}
	
	public Command getCommand(String command){
		return commandMap.get(command);
	}
}
