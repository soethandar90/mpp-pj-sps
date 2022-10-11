package librarysystem.business.usecase;

import librarysystem.domain.Book;
import librarysystem.domain.exception.BookNotFoundException;

public interface BookCopyUseCase {
	public Book addBookCopy(Book book, int noOfCopies) throws BookNotFoundException;
}
