package spslibsys.businessLogic.ifusecase;

import spslibsys.dom.exception.BookNotFoundException;
import syslibsys.dom.Book;

public interface BookCopyUseCase {
	public Book addBookCopy(Book book, int noOfCopies) throws BookNotFoundException;
}
