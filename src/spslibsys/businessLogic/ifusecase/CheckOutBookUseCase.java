package spslibsys.businessLogic.ifusecase;

import spslibsys.dom.exception.BookCopyNotAvailableException;
import spslibsys.dom.exception.BookNotFoundException;
import spslibsys.dom.exception.MemberNotFoundException;

public interface CheckOutBookUseCase extends PrintCheckOutRecordUseCase {
	public void checkOutBook(String memberId, String bookId)
			throws BookNotFoundException, MemberNotFoundException, BookCopyNotAvailableException;
}
