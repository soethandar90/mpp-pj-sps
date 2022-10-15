package spslibsys.businessLogic.ifusecase;

import spslibsys.dom.Book;
import spslibsys.dom.exception.BookNotFoundException;

public interface BookCopyUseCase {
	public Book addBookCopy(Book book, int noOfCopies) throws BookNotFoundException;
}
