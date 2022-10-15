package spslibsys.businessLogic.ifusecase;

import spslibsys.dom.LibraryMember;

public interface CheckMemberUseCase {
	public boolean checkMember(String memberId);

	public LibraryMember getMember(String memberId);
}
