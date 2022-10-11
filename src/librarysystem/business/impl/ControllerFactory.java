package librarysystem.business.impl;

import librarysystem.business.usecase.AddBookUseCase;
import librarysystem.business.usecase.AddLibraryMemberUseCase;
import librarysystem.business.usecase.BookCopyUseCase;
import librarysystem.business.usecase.CheckMemberUseCase;
import librarysystem.business.usecase.CheckOutBookUseCase;
import librarysystem.business.usecase.GetAuthorUseCase;
import librarysystem.business.usecase.LogInUseCase;
import librarysystem.business.usecase.PrintCheckOutRecordUseCase;
import librarysystem.business.usecase.SearchBookUseCase;

public class ControllerFactory {
	private ControllerFactory() {
	}

	public static SearchBookUseCase createSearchBookUseCase() {
		SearchBookUseCase useCase = new BookController();
		return useCase;
	}

	public static AddBookUseCase createAddBookUseCase() {
		AddBookUseCase useCase = new BookController();
		return useCase;
	}

	// Added by WinWin
	public static GetAuthorUseCase createGetAuthorController() {
		GetAuthorUseCase useCase = new GetAuthorController();
		return useCase;
	}

	public static BookCopyUseCase createBookCopyUseCase() {
		BookCopyUseCase useCase = new BookCopyController();
		return useCase;
	}

	public static CheckOutBookUseCase createCheckOutBookUseCase() {
		CheckOutBookUseCase useCase = new CheckOutBookController();
		return useCase;
	}

	public static PrintCheckOutRecordUseCase createPrintCheckOutBookUseCase() {
		PrintCheckOutRecordUseCase useCase = new CheckOutBookController();
		return useCase;
	}

	public static CheckMemberUseCase createCheckMemberUseCase() {
		CheckMemberUseCase useCase = new LibraryMemberController();
		return useCase;
	}

	public static LogInUseCase createLogInUseCase() {
		LogInUseCase useCase = new LogInController();
		return useCase;

	}

	public static AddLibraryMemberUseCase createAddLibraryMemberUseCase() {
		AddLibraryMemberUseCase useCase = new LibraryMemberController();
		return useCase;
	}

}
