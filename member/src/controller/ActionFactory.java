package controller;

import controller.action.JoinAction;
import controller.action.JoinFormAction;
import controller.action.LoginAction;
import controller.action.LogoutAction;
import controller.action.MemberDeleteAction;
import controller.action.MemberUpdateAction;


public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {
		super();
	}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory :"+command);
		if(command.equals("login")) {
			action = new LoginAction();
		} else if(command.equals("logout")) {
			action = new LogoutAction();
		} else if(command.equals("join_form")) {
			action = new JoinFormAction();
		} else if(command.equals("join")) {
			action = new JoinAction();
		} else if(command.equals("member_update")) {
			action = new MemberUpdateAction();
		} else if(command.equals("member_delete")) {
			action = new MemberDeleteAction();
		} 
		return action;
	}
}
