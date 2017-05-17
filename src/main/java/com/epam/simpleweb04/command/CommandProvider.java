package com.epam.simpleweb04.command;

import java.util.HashMap;
import java.util.Map;

import com.epam.simpleweb04.command.impl.BookCommand;
import com.epam.simpleweb04.command.impl.LoginCommand;
import com.epam.simpleweb04.command.impl.LogoutCommand;
import com.epam.simpleweb04.command.impl.NewUserCommand;
import com.epam.simpleweb04.command.impl.PageLoadCommand;
import com.epam.simpleweb04.command.impl.SearchCommand;

public class CommandProvider {

	private static Map<String, Command> commandMap = new HashMap<String, Command>();
	
	public CommandProvider(){
		commandMap.put("get", new PageLoadCommand());
		commandMap.put("login", new LoginCommand());
		commandMap.put("new", new NewUserCommand());
		commandMap.put("logout", new LogoutCommand());
		commandMap.put("search", new SearchCommand());
		commandMap.put("book", new BookCommand());
	}
	
	public Command getCommand(String command){
		return commandMap.get(command);
	}
}
