package spslibsys.dom.exception;

import java.io.Serializable;

public class BookCopyNotAvailableException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	public BookCopyNotAvailableException(String bookId) {
		super("BookId " + bookId + " copy is not available");
	}

}
