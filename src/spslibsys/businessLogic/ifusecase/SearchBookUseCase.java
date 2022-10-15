package spslibsys.businessLogic.ifusecase;

import java.util.List;

import syslibsys.dom.Book;

public interface SearchBookUseCase {
	public Book searchBook(String isbn);

	public List<Book> getBookCollection();
}
