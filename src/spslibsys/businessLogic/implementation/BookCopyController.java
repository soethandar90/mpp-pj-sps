package spslibsys.businessLogic.implementation;

import java.util.HashMap;

import spslibsys.businessLogic.ifusecase.BookCopyUseCase;
import spslibsys.dataaccess.DataAccess;
import spslibsys.dataaccess.DataAccessFacade;
import spslibsys.dom.exception.BookNotFoundException;
import syslibsys.dom.Book;

public class BookCopyController implements BookCopyUseCase {
	BookCopyController() {
	}

	@Override
	public Book addBookCopy(Book book, int noOfCopies) throws BookNotFoundException {
		DataAccess da = new DataAccessFacade();
		HashMap<String, Book> hmBooks = da.readBooksMap();

		if (hmBooks.containsKey(book.getIsbn())) {
			Book bookFromDB = hmBooks.get(book.getIsbn());

			for (int i = 0; i < noOfCopies; i++) {
				bookFromDB.addCopy();
			}

			hmBooks.put(bookFromDB.getIsbn(), bookFromDB);
			da.updateBookHM(hmBooks);
			return bookFromDB;
		} else {
			throw new BookNotFoundException(book.getIsbn());
		}

	}

}
