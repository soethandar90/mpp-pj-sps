package librarysystem.business.usecase;

import librarysystem.domain.Book;

public interface CheckBookCopyAvailableUseCase {
	public Book checkBookAvailableCopy(String bookId); 
}
