package librarysystem.business.usecase;

import java.util.List;

import librarysystem.domain.exception.LoginException;

public interface ControllerInterface {
	public void login(String id, String password) throws LoginException;

	public List<String> allMemberIds();

	public List<String> allBookIds();

}
