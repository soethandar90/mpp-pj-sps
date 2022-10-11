package librarysystem.business.usecase;

import librarysystem.domain.LibraryMember;

public interface CheckMemberUseCase {
	public boolean checkMember(String memberId);
	
	public LibraryMember getMember(String memberId);
}
