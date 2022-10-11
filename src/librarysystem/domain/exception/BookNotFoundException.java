package librarysystem.domain.exception;

import java.io.Serializable;

public class BookNotFoundException extends Exception implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public BookNotFoundException(String bookId) {
		super("BookId " + bookId + " is not found");
	}

}
