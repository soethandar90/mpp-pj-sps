package spslibsys.businessLogic.ifusecase;

import syslibsys.dom.LibraryMember;

public interface CheckMemberUseCase {
	public boolean checkMember(String memberId);

	public LibraryMember getMember(String memberId);
}
