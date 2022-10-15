package spslibsys.businessLogic.ifusecase;

import java.util.List;

import spslibsys.dom.exception.LoginException;

public interface ControllerInterface {
	public void login(String id, String password) throws LoginException;

	public List<String> allMemberIds();

	public List<String> allBookIds();

}
