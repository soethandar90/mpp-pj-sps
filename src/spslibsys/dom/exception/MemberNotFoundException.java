package spslibsys.dom.exception;

import java.io.Serializable;

public class MemberNotFoundException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	public MemberNotFoundException(String memberId) {
		super("MemberId " + memberId + " is not found");
	}

}