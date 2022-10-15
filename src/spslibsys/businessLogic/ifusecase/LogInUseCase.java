package spslibsys.businessLogic.ifusecase;

import spslibsys.dataaccess.Auth;
import spslibsys.dom.exception.LoginException;

public interface LogInUseCase {
	public Auth login(String id, String password) throws LoginException;
}
