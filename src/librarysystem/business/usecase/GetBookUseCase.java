package librarysystem.business.usecase;

import java.util.List;

import librarysystem.domain.Book;

public interface GetBookUseCase {
	public List<Book> getBookCollection();
}
