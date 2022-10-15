package spslibsys.businessLogic.implementation;

import java.util.HashMap;

import spslibsys.businessLogic.ifusecase.AddLibraryMemberUseCase;
import spslibsys.businessLogic.ifusecase.CheckMemberUseCase;
import spslibsys.dataaccess.DataAccess;
import spslibsys.dataaccess.DataAccessFacade;
import spslibsys.dom.exception.InvalidMemberException;
import syslibsys.dom.LibraryMember;

public class LibraryMemberController implements AddLibraryMemberUseCase, CheckMemberUseCase {
	LibraryMemberController() {
	}

	@Override
	public void addLibraryMember(LibraryMember member) throws InvalidMemberException {
		DataAccess da = new DataAccessFacade();

		if (member == null) {
			throw new InvalidMemberException("Member is null");
		}

		if (member.getMemberId().isEmpty()) {
			throw new InvalidMemberException("Invalid Member Id");
		}

		if (member.getFirstName().isEmpty()) {
			throw new InvalidMemberException("Invalid First Name");
		}

		if (member.getLastName().isEmpty()) {
			throw new InvalidMemberException("Invalid Last Name");
		}

		if (checkMember(member.getMemberId())) {
			throw new InvalidMemberException("Member ID already exist");
		}

		da.saveNewMember(member);

	}

	@Override
	public boolean checkMember(String memberId) {
		if (getMember(memberId) != null)
			return true;

		return false;

	}

	@Override
	public LibraryMember getMember(String memberId) {
		DataAccess da = new DataAccessFacade();
		HashMap<String, LibraryMember> map = da.readMemberMap();
		return map.get(memberId);
	}

}
