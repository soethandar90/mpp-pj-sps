package spslibsys.businessLogic.ifusecase;

import spslibsys.dom.LibraryMember;
import spslibsys.dom.exception.InvalidMemberException;

public interface AddLibraryMemberUseCase {
	public void addLibraryMember(LibraryMember member) throws InvalidMemberException;
}
