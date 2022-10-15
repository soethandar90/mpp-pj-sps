package spslibsys.businessLogic.ifusecase;

import spslibsys.dom.exception.InvalidMemberException;
import syslibsys.dom.LibraryMember;

public interface AddLibraryMemberUseCase {
	public void addLibraryMember(LibraryMember member) throws InvalidMemberException;
}
