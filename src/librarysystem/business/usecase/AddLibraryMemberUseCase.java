package librarysystem.business.usecase;

import librarysystem.domain.LibraryMember;
import librarysystem.domain.exception.InvalidMemberException;

public interface AddLibraryMemberUseCase {
	public void addLibraryMember(LibraryMember member) throws InvalidMemberException;
}
