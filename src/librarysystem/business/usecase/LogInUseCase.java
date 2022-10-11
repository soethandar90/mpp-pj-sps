package librarysystem.business.usecase;

import librarysystem.dataaccess.Auth;
import librarysystem.domain.exception.LoginException;

public interface LogInUseCase {
	public Auth login(String id, String password) throws LoginException;
}
