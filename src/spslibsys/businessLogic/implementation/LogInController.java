package spslibsys.businessLogic.implementation;

import java.util.HashMap;

import spslibsys.businessLogic.ifusecase.LogInUseCase;
import spslibsys.dataaccess.Auth;
import spslibsys.dataaccess.DataAccess;
import spslibsys.dataaccess.DataAccessFacade;
import spslibsys.dataaccess.User;
import spslibsys.dom.exception.LoginException;

public class LogInController implements LogInUseCase {
	LogInController() {
	}

	public static Auth currentAuth = null;

	@Override
	public Auth login(String id, String password) throws LoginException {
		DataAccess da = new DataAccessFacade();
		HashMap<String, User> map = da.readUserMap();

		if (!map.containsKey(id)) {
			throw new LoginException("Invalid Credentials");
		}

		String userPass = map.get(id).getPassword();
		if (!userPass.equals(password)) {
			throw new LoginException("Invalid Credentials");
		}

		currentAuth = map.get(id).getAuthorization();
		return currentAuth;

	}

}
